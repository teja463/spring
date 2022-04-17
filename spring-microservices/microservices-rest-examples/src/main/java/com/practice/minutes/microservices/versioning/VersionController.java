package com.practice.minutes.microservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = {"application/json"})
public class VersionController {

    @GetMapping("/v1/person")
    public PersonV1 uriV1() {
        return new PersonV1("Teja P");
    }

    @GetMapping("/v2/person")
    public PersonV2 uriV2() {
        return new PersonV2("Teja", "Ponnuru");
    }

    @GetMapping(value = "/param/person", params = "version=1")
    public PersonV1 paramV1() {
        return new PersonV1("Teja P");
    }

    @GetMapping(value = "/param/person", params = "version=2")
    public PersonV2 paramV2() {
        return new PersonV2("Teja", "Ponnuru");
    }

    @GetMapping(value = "/header/person", headers = "X-API-VERSION=1")
    public PersonV1 headerV1() {
        return new PersonV1("Teja P");
    }

    @GetMapping(value = "/header/person", headers = "X-API-VERSION=2")
    public PersonV2 headerV2() {
        return new PersonV2("Teja", "Ponnuru");
    }
}
