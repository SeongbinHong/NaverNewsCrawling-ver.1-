package com.example.demo.domain.controller;

import com.example.demo.domain.exception.NaverApiCallException;
import com.example.demo.domain.exception.NewsNullException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


/*
만족하는 News가 없다면 404 Not Found로 응답하고,
NaverApi가 작동하지 않을 경우에는 Service_Unavailable을 통해 503으로 응답하도록 하였습니다.
 */
public class NewsControllerAdvice {
    @ExceptionHandler(NewsNullException.class)
    public ResponseEntity<String> handleNewsNullException(NewsNullException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(NaverApiCallException.class)
    public ResponseEntity<String> handleNaverApiCallException(NaverApiCallException e) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(e.getMessage());
    }
}
