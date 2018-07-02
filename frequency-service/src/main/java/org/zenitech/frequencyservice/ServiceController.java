package org.zenitech.frequencyservice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ServiceController {
    @PostMapping("/process/{text}")
    public Mono<String> process(@PathVariable String text){
        return Mono.just(text);
    }
}
