package com.playground.reactiveservice.controller;

import com.playground.reactiveservice.dto.Foo;
import java.time.Duration;
import java.util.stream.Stream;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

@RestController
public class DemoController {

    @GetMapping(value = "/foos", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Foo> foo() {
        Flux<Foo> eventFlux = Flux.fromStream(Stream.generate(() -> new Foo(System.currentTimeMillis(), "Fixed-name")));
        Flux<Long> durationFlux = Flux.interval(Duration.ofSeconds(1));
        return Flux.zip(eventFlux, durationFlux).map(Tuple2::getT1);
    }

}
