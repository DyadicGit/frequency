package org.zenitech.frequencyapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import reactor.core.publisher.Mono;

@FeignClient(value = "frequency-service", fallback = FrequencyServiceClient.Fallback.class)
public interface FrequencyServiceClient {

    @PostMapping("/process/{text}")
    String process(@PathVariable("text") String text);

    @Service
    class Fallback implements FrequencyServiceClient {
        @Override
        public String process(final String text) {
            return "Fallback"+text;
        }
    }
}
