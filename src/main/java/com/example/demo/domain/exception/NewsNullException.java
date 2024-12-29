package com.example.demo.domain.exception;

public class NewsNullException extends RuntimeException {
    public NewsNullException() {
        super("News data not found");
    }
}
