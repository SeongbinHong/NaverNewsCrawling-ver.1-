package com.example.demo.domain.controller;

import com.example.demo.domain.dto.NewsResponseDto;
import com.example.demo.domain.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    //쿼리 스트링을 통해 keyword를 전달 받아서 서비스를 호출하고, ResponseEntity를 통해 List를 반환합니다.
    @GetMapping
    public ResponseEntity<List<NewsResponseDto>> getNewsWithKeyword(@RequestParam("keyword") String keyword) {
        return ResponseEntity.ok(newsService.getNaverNewsWithKeyword(keyword));
    }
}
