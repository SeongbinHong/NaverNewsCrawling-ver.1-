package com.example.demo.domain.dto;

import com.example.demo.domain.util.JsoupCrawling;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class NewsApiResponseDto { //NewsApiResponseDto는 NewsSummaryDto를 가진 일급 컬렉션으로 설계
    @JsonSetter("items")
    private List<NewsSummaryDto> items;


    //getOnlyNaverNews : items로 부터 네이버 뉴스에 등록된 items만 반환합니다.
    public List<NewsSummaryDto> getOnlyNaverNews() {
        return items.stream()
                .filter(item -> item.getLink().startsWith("https://n.news"))
                .collect(Collectors.toList());
    }


    /*
    getOnlyNaverNews를 이용하여 필터링 된 뉴스들을 활용
    JsoupCrawling 객체를 주입하여 크롤링을 수행한 뒤
    validateImageLink를 통해 이미지가 있는 데이터들로 한번더 필터링하여
    최대 10개까지 반환합니다.
     */
    public List<NewsResponseDto> getNewsResponseDtoWithImages() {
        return getOnlyNaverNews().stream()
                .map(item -> item.toNewsResponseDto(new JsoupCrawling()))
                .filter(NewsResponseDto::validateImageLink)
                .limit(10L)
                .collect(Collectors.toList());
    }
}
