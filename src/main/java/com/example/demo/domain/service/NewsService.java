package com.example.demo.domain.service;

import com.example.demo.domain.dto.NewsApiResponseDto;
import com.example.demo.domain.dto.NewsResponseDto;
import com.example.demo.domain.repository.NewsApiResponseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.demo.domain.exception.NewsNullException;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class NewsService {

    private final NewsApiResponseRepository newsApiResponseRepository;

    public List<NewsResponseDto> getNaverNewsWithKeyword(String keyword) {
        NewsApiResponseDto newsApiResponseDto = newsApiResponseRepository.getNewsApiResponseDto(keyword)
                .orElseThrow(NewsNullException::new);
        return newsApiResponseDto.getNewsResponseDtoWithImages();
    }

}
