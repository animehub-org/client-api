package org.animefoda.client.entities.producer;

import org.animefoda.client.response.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/producer")
class ProducerController {

    private final ProducerService producerService;

    ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping("/{id}")
    public ApiResponse<ProducerSummaryDTO> get(@PathVariable String id){
        return new ApiResponse<>(null);
    }
}
