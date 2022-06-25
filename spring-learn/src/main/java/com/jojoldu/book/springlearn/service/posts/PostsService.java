package com.jojoldu.book.springlearn.service.posts;

import com.jojoldu.book.springlearn.domain.posts.Posts;
import com.jojoldu.book.springlearn.domain.posts.PostsRepository;
import com.jojoldu.book.springlearn.web.dto.PostsListResponseDto;
import com.jojoldu.book.springlearn.web.dto.PostsResponseDto;
import com.jojoldu.book.springlearn.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.springlearn.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());
        // 업데이트 쿼리를 날리는 부분은 없어도 무방
        // JPA의 Dirty checking
        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                // .map(posts -> new PostsListResponseDto(posts))
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }
}
