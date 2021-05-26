package com.capgemini.reactive.controller;

import com.capgemini.reactive.service.ErrorService;
import com.capgemini.reactive.to.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class ErrorController {

    private static final Map<Long, ResponseEntity<Product>> statuses = Map.of(
            0L, ResponseEntity.status(HttpStatus.BAD_REQUEST).build(),
            1L, ResponseEntity.status(HttpStatus.NOT_FOUND).build(),
            2L, ResponseEntity.status(HttpStatus.FORBIDDEN).build()
    );
    private static final ResponseEntity<Product> defaultResponse = ResponseEntity.ok(new Product("Ok Product", 123.99));

    private final ErrorService errorService;

    @GetMapping("/error")
    public ResponseEntity<Product> error() {
        long r = System.currentTimeMillis() % 4;
        return statuses.getOrDefault(r, defaultResponse);
    }

    @GetMapping("/handler")
    public Mono<Product> handler() {
        return errorService.callErrorEndpoint();
    }

    // TODO: Add retry mechanism in case there is an error when calling endpoint. Please set up maximal 3 retires
    //  with 1 second duration between each try.
    //  (+) You can play a little bit with such functionality. Introduce some backoff strategy, add another type of
    //  exception in case of some status and apply retry only on such exception.
    @GetMapping("/handler2")
    public Mono<Product> handler2() {
        return errorService.callErrorEndpoint()
                .retryWhen(Retry.fixedDelay(3, Duration.ofSeconds(1)));
    }

}
