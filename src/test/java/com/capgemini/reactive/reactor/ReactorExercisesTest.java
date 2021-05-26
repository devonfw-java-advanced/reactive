package com.capgemini.reactive.reactor;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class ReactorExercisesTest {

    private final ReactorExercises exercises = new ReactorExercises();

    @Test
    public void simpleFluxTest() {
        Flux<String> flux = exercises.simpleFlux();
        StepVerifier
                .create(flux)
                .expectNext("One", "Two")
                .verifyComplete();
    }

    @Test
    public void countingFluxTest() {
        Supplier<Flux<Long>> fluxSupplier = exercises.countingFlux();
        StepVerifier
                .withVirtualTime(fluxSupplier)
                .expectSubscription()
                .expectNoEvent(Duration.ofSeconds(1))
                .expectNext(0L)
                .thenAwait(Duration.ofSeconds(1))
                .expectNext(1L)
                .thenAwait(Duration.ofSeconds(1))
                .expectNext(2L)
                .thenAwait(Duration.ofSeconds(1))
                .expectNext(3L)
                .thenAwait(Duration.ofSeconds(1))
                .expectNext(4L)
                .verifyComplete();
    }

    @Test
    public void simpleMonoTest() {
        Mono<String> mono = exercises.simpleMono();
        StepVerifier.create(mono)
                .expectNext("One")
                .verifyComplete();
    }

    @Test
    public void errorMonoTest() {
        Mono<String> mono = exercises.errorMono();
        StepVerifier.create(mono)
                .verifyError(IllegalStateException.class);
    }

    @Test
    public void upperCaseMonoTest() {
        Flux<String> flux = Flux.just("One", "Two", "Three");
        StepVerifier
                .create(exercises.upperCaseMono(flux))
                .expectNext(
                        "ONE",
                        "TWO",
                        "THREE")
                .verifyComplete();
    }

    @Test
    public void  asyncUpperCaseMonoTest() {
        Flux<String> flux = Flux.just("One", "Two", "Three");
        StepVerifier
                .create(exercises.asyncUpperCaseMono(flux))
                .expectNext(
                        "ONE",
                        "TWO",
                        "THREE")
                .verifyComplete();
    }

    @Test
    public void mergeFluxFifoTest() {
        Flux<String> flux1 = Flux.just("One", "Two")
                .delaySequence(Duration.ofSeconds(1));
        Flux<String> flux2 = Flux.just("Three", "Four");

        Flux<String> flux = exercises.mergeFluxFifo(flux1, flux2);
        StepVerifier
                .create(flux)
                .expectNext("Three", "Four", "One", "Two")
                .verifyComplete();
    }

    @Test
    public void mergeFluxOrderedTest() {
        Flux<String> flux1 = Flux.just("One", "Two")
                .delaySequence(Duration.ofSeconds(1));
        Flux<String> flux2 = Flux.just("Three", "Four");

        Flux<String> flux = exercises.mergeFluxOrdered(flux1, flux2);
        StepVerifier
                .create(flux)
                .expectNext("One", "Two", "Three", "Four")
                .verifyComplete();
    }

    @Test
    public void createFluxFromMonosTest() {
        Mono<String> mono1 = Mono.just("One");
        Mono<String> mono2 = Mono.just("Two");
        Flux<String> flux = exercises.createFluxFromMonos(mono1, mono2);
        StepVerifier
                .create(flux)
                .expectNext("One", "Two")
                .verifyComplete();
    }

    @Test
    public void defaultOnErrorTest() {
        Mono<String> mono = exercises.defaultOnError(Mono.error(new IllegalArgumentException()));
        StepVerifier
                .create(mono)
                .expectNext("Help")
                .verifyComplete();

        mono = exercises.defaultOnError(Mono.just("Test"));
        StepVerifier.
                create(mono)
                .expectNext("Test")
                .verifyComplete();
    }

    @Test
    public void joinFluxValuesTest() {
        Flux<String> firstnameFlux = Flux.just("John", "Luke");
        Flux<String> lastnameFlux = Flux.just("Doe", "Skywalker");
        Flux<String> userFlux = exercises.joinFluxValues(firstnameFlux, lastnameFlux);
        StepVerifier
                .create(userFlux)
                .expectNext("John Doe", "Luke Skywalker")
                .verifyComplete();
    }

    @Test
    public void useFastestMonoTest() {
        Mono<String> mono1 = Mono
                .just("One")
                .delayElement(Duration.ofSeconds(1));
        Mono<String> mono2 = Mono.just("Two");

        Mono<String> mono = exercises.useFastestMono(mono1, mono2);
        StepVerifier
                .create(mono)
                .expectNext("Two")
                .verifyComplete();

        mono1 = Mono
                .just("One")
                .delayElement(Duration.ofSeconds(1));
        mono2 = Mono.just("Two");

        mono = exercises.useFastestMono(mono2, mono1);
        StepVerifier
                .create(mono)
                .expectNext("Two")
                .verifyComplete();
    }

    @Test
    public void fluxToMonoCollectionTest() {
        Flux<String> just = Flux.just("One", "Two");
        Mono<List<String>> collection = exercises.fluxToMonoCollection(just);
        StepVerifier
                .create(collection)
                .expectNext(Arrays.asList("One", "Two"))
                .verifyComplete();
    }
}
