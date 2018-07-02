package org.zenitech.frequencyapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import reactor.core.publisher.Mono;

@FeignClient("frequency-service")
public interface FrequencyServiceClient {

    @PostMapping("/process/{text}")
    String process(@PathVariable("text") String text);
}
