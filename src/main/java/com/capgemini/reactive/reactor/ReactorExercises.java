package com.capgemini.reactive.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.function.Supplier;

public class ReactorExercises {

    // TODO Return a Flux which produce strings 'One' and 'Two'
    Flux<String> simpleFlux() {
        return Flux.just("One", "Two");
    }

    // TODO Create a Flux that produce values from 0 to 4 every 1 second.
    // Do not create Flux earlier in test but in Supplier itself;
    Supplier<Flux<Long>> countingFlux() {
        return () -> Flux
                .interval(Duration.ofSeconds(1))
                .take(5);
    }

    // TODO Create Mono with string 'One'
    Mono<String> simpleMono() {
        return Mono.just("One");
    }

    // TODO Create Mono that produce IllegalStateException
    Mono<String> errorMono() {
        return Mono.error(new IllegalStateException());
    }

    // TODO Modify stings in Flux to make them upper case;
    Flux<String> upperCaseMono(Flux<String> flux) {
        return flux.map(String::toUpperCase);
    }

    // TODO Modify stings in Flux to make them upper case using toUpperCaseAsync
    Flux<String> asyncUpperCaseMono(Flux<String> flux) {
        return flux.flatMap(this::toUpperCaseAsync);
    }

    // TODO Merge flux1 and flux2 (first in - first out)
    Flux<String> mergeFluxFifo(Flux<String> flux1, Flux<String> flux2) {
        return flux1.mergeWith(flux2);
    }

    // TODO Merge flux1 and flux2 values with kept order (all flux1 values and then all flux2 values)
    Flux<String> mergeFluxOrdered(Flux<String> flux1, Flux<String> flux2) {
        return flux1.concatWith(flux2);
    }

    // TODO Create a Flux containing the values from mono1 and mono2
    Flux<String> createFluxFromMonos(Mono<String> mono1, Mono<String> mono2) {
        return Flux.concat(mono1, mono2);
    }

    // TODO Return string "Help" when there is an error - otherwise left returned value
    Mono<String> defaultOnError(Mono<String> mono) {
        return mono.onErrorReturn("Help");
    }

    // TODO Create a Flux with string '$firstName $lastName' from separate Flux'es of firstname and lastname.
    Flux<String> joinFluxValues(Flux<String> firstnameFlux, Flux<String> lastnameFlux) {
        return Flux
                .zip(firstnameFlux, lastnameFlux,
                        (firstName, lastName) -> String.format("%s %s", firstName, lastName));
        // alternative
//        return Flux
//                .zip(firstnameFlux, lastnameFlux, (firstname, lastName) -> String.format("%s %s", firstname, lastName))
//                .map(tuple -> tuple.getT1() + " " + tuple.getT2());
    }

    // TODO Return the mono value which was faster
    Mono<String> useFastestMono(Mono<String> mono1, Mono<String> mono2) {
        return Mono.firstWithSignal(mono1, mono2);
    }

    // TODO Convert the input Flux<User> to a Mono<List<User>> containing list of collected flux values
    Mono<List<String>> fluxToMonoCollection(Flux<String> flux) {
        return flux.collectList();
    }

    Mono<String> toUpperCaseAsync(String s) {
        return Mono.just(s.toUpperCase());
    }
}
