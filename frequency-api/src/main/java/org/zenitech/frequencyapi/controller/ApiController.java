package org.zenitech.frequencyapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.http.codec.multipart.Part;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.zenitech.frequencyapi.client.FrequencyServiceClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.Function;
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
        return files.stream()
                .map((Function<MultipartFile, Object>) MultipartFile::getInputStream);
    }

}
