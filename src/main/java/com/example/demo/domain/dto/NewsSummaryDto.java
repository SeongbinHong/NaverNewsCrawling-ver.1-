package com.example.demo.domain.dto;

import com.example.demo.domain.util.JsoupCrawling;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.select.Elements;


import java.util.Optional;

@Getter
@Slf4j
public class NewsSummaryDto {

    @JsonSetter("title")
    private String title;
    @JsonSetter("link")
    private String link;
    @JsonSetter("description")
    private String description;

    public NewsResponseDto toNewsResponseDto(JsoupCrawling jsoupCrawling) {
        String query = "#contents img";
        Optional<Elements> jsoupElements = jsoupCrawling.getJsoupElements(link, query);
        if (jsoupElements.isPresent()) {
            return NewsResponseDto.builder()
                    .imageLink(jsoupElements.get().attr("data-src"))
                    .title(title)
                    .link(link)
                    .description(description)
                    .build();
        }
        return NewsResponseDto.builder()
                .title(title)
                .link(link)
                .description(description)
                .build();
    }

}
