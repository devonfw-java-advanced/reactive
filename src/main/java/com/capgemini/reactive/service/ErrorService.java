package com.capgemini.reactive.service;

import com.capgemini.reactive.to.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class ErrorService {

    private final WebClient localClient;

    // TODO: Look how looks like response from endpoint /handler now. Please adjust this method that when some error
    //  with HTTP status code 4xx (404, 401, etc.) is returned when invoking this method then exception
    //  ServiceNotAvailableException is thrown by this Mono object.
    public Mono<Product> callErrorEndpoint() {
        return null;
    }
}
