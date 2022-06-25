package com.jojoldu.book.springlearn.web.dto;

import com.jojoldu.book.springlearn.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getTitle();
        this.modifiedDate = entity.getModifiedDate();
    }
}
