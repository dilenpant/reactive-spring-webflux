package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

public class FluxAndMonoGeneratorService {
    static Flux<String> fluxExample(){
        return Flux.fromIterable(Arrays.asList("Subash", "Rajat", "Deepak", "Jyoti", "Raja"));
    }
    public static void main(String[] args) {
        fluxExample().subscribe(a -> System.out.println(a));
        // Subash
        //Rajat
        //....
        System.out.println(" first 3 names skip ");
        var fluxExample = fluxExample().skip(3);
        fluxExample.subscribe(System.out::println);
        // Jyoti
        // Raja

        System.out.println(" Log......(And skipped all names)");
        var fluxExample3 = fluxExample().skip(5).log();
        fluxExample3.subscribe(System.out::println);
        /*
        00:57:02.521 [main] INFO reactor.Flux.Skip.1 - onSubscribe(FluxSkip.SkipSubscriber)
        00:57:02.524 [main] INFO reactor.Flux.Skip.1 - request(unbounded)
        00:57:02.524 [main] INFO reactor.Flux.Skip.1 - onComplete()
         */



    }
}
