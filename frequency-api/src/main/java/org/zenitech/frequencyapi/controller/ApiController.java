package org.zenitech.frequencyapi.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.zenitech.frequencyapi.client.FrequencyServiceClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class ApiController {

    private final FrequencyServiceClient frequencyServiceClient;

    public ApiController(final FrequencyServiceClient frequencyServiceClient) {
        this.frequencyServiceClient = frequencyServiceClient;
    }

    @GetMapping("/echo/{text}")
    public Mono<String> echo(@PathVariable("text") String text) {
             return Mono.just(frequencyServiceClient.process(text));
    }

    @GetMapping("/config")
    public Mono<Integer> config(@Value("${my.value}") Integer value) {
        return Mono.just(value);
    }

    @GetMapping("/upload")
    public String uploading() {
        return "uploading";
    }

    @PostMapping("/upload")
    public Callable<String> upload(@RequestBody List<MultipartFile> files) {
         Stream<InputStream> streamList = files.stream().map(multipartFile -> {
             try {
                 return multipartFile.getInputStream();
             } catch (IOException e) {
                 e.printStackTrace();
             }
             return null;
         });
        byte[] targetArray = new byte[0];
         streamList.forEach(inputStream -> {
             try {
                 IOUtils.readFully(inputStream, targetArray);
             } catch (IOException e) {
                 e.printStackTrace();
             }
         });
         return () -> targetArray.toString();
    };


}
