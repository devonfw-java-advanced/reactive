package com.capgemini.reactive.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Supplier;

public class ReactorExercises {

    // TODO Return a Flux which produce strings 'One' and 'Two'
    Flux<String> simpleFlux() {
        return null;
    }

    // TODO Create a Flux that produce values from 0 to 4 every 1 second.
    //  Do not create Flux earlier in test but in Supplier itself;
    Supplier<Flux<Long>> countingFlux() {
        return null;
    }

    // TODO Create Mono with string 'One'
    Mono<String> simpleMono() {
        return null;
    }

    // TODO Create Mono that produce IllegalStateException
    Mono<String> errorMono() {
        return null;
    }

    // TODO Modify stings in Flux to make them upper case;
    Flux<String> upperCaseMono(Flux<String> flux) {
        return null;
    }

    // TODO Modify stings in Flux to make them upper case using toUpperCaseAsync
    Flux<String> asyncUpperCaseMono(Flux<String> flux) {
        return null;
    }

    // TODO Merge flux1 and flux2 (first in - first out)
    Flux<String> mergeFluxFifo(Flux<String> flux1, Flux<String> flux2) {
        return null;
    }

    // TODO Merge flux1 and flux2 values with kept order (all flux1 values and then all flux2 values)
    Flux<String> mergeFluxOrdered(Flux<String> flux1, Flux<String> flux2) {
        return null;
    }

    // TODO Create a Flux containing the values from mono1 and mono2
    Flux<String> createFluxFromMonos(Mono<String> mono1, Mono<String> mono2) {
        return null;
    }

    // TODO Return string "Help" when there is an error - otherwise left returned value
    Mono<String> defaultOnError(Mono<String> mono) {
        return null;
    }

    // TODO Create a Flux with string '$firstName $lastName' from separate Flux'es of firstname and lastname.
    Flux<String> joinFluxValues(Flux<String> firstnameFlux, Flux<String> lastnameFlux) {
        return null;
    }

    // TODO Return the mono value which was faster
    Mono<String> useFastestMono(Mono<String> mono1, Mono<String> mono2) {
        return null;
    }

    // TODO Convert the input Flux<User> to a Mono<List<User>> containing list of collected flux values
    Mono<List<String>> fluxToMonoCollection(Flux<String> flux) {
        return null;
    }

    Mono<String> toUpperCaseAsync(String s) {
        return Mono.just(s.toUpperCase());
    }
}
