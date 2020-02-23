package com.playground.reactiveservice.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = DemoController.class)
public class DemoControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void foo() {
        webTestClient.get().uri("/foos").exchange().expectStatus().isOk();
    }
}