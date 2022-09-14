package com.capgemini.reactive.service;

import com.capgemini.reactive.exception.ServiceNotAvailableException;
import com.capgemini.reactive.to.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class ErrorService {

    private final WebClient localClient;

    // TODO: Look how looks response from endpoint /handler now (ErrorController.handler). Please adjust this method that when some error
    //  with HTTP status code 4xx (404, 401, etc.) is returned when invoking this method then exception
    //  ServiceNotAvailableException is thrown by this Mono object.
    public Mono<Product> callErrorEndpoint() {
        return localClient
                .get()
                .uri("/error")
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, response -> Mono.error(ServiceNotAvailableException::new))
                .bodyToMono(Product.class);
    }
}
