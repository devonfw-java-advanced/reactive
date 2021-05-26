package com.capgemini.reactive.service;

import com.capgemini.reactive.to.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final WebClient localClient;

    public Flux<Product> getFavourites() {
        return localClient.get()
                .uri("/favourites")
                .retrieve()
                .bodyToFlux(Product.class);
    }

    public Flux<Product> getPropositions() {
        return localClient.get()
                .uri("/propositions")
                .retrieve()
                .bodyToFlux(Product.class);
    }
}
