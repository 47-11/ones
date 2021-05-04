package de.fourtyseveneleven.ones.common.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Supplier;

@RestController
class ExceptionThrowingController {

    static final String EXCEPTION_URL = "/test/exception";

    private Supplier<? extends Throwable> exceptionSupplier;

    @GetMapping(EXCEPTION_URL)
    void throwException() throws Throwable {

        throw exceptionSupplier.get();
    }

    void throwNext(Supplier<? extends Throwable> exceptionSupplier) {

        this.exceptionSupplier = exceptionSupplier;
    }
}
