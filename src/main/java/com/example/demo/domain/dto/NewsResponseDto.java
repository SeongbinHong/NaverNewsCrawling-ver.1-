package com.example.demo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class NewsResponseDto {
    private String title; // 제목
    private String link; // 링크
    private String description; //내용
    private String imageLink; //URL

    //ImageLink가 없을 때 validation 로직을 추가 하기 위해, validateImageLink 메서드를 추가하였습니다.
    public boolean validateImageLink() {
        return imageLink != null && !imageLink.isEmpty(); //이미지
    }
}
