package com.capgemini.reactive.controller;

import com.capgemini.reactive.service.ProductService;
import com.capgemini.reactive.to.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/favourites")
    public Flux<Product> favourites() {
        return Flux.just(
                new Product("Prod1", 19.99),
                new Product("Prod2", 29.99)
        ).delaySequence(Duration.ofSeconds(3));
    }

    @GetMapping("/propositions")
    public Flux<Product> propositions() {
        return Flux.just(
                new Product("Prod3", 9.99),
                new Product("Prod4", 4.99)
        ).delaySequence(Duration.ofSeconds(5));
    }

    // TODO: Implement this endpoint to receive all favourites and propositions and return in as a single list of Products.
    //  To gather data please invoke endpoint prepared above ( via HTTP call). To do so please implement service methods appropriately.
    @GetMapping("/products")
    public Flux<Product> products() {
        Flux<Product> favourites = productService.getFavourites();
        Flux<Product> propositions = productService.getPropositions();

        return favourites.mergeWith(propositions);
    }
}
