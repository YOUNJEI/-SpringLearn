package com.jojoldu.book.springlearn.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSearchRequestDto {
    private String title;
    private String content;

    @Builder
    PostsSearchRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
