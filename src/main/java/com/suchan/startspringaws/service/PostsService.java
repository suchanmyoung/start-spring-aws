package com.suchan.startspringaws.service;

import com.suchan.startspringaws.domain.posts.Posts;
import com.suchan.startspringaws.domain.posts.PostsRepository;
import com.suchan.startspringaws.web.dto.PostsListResponseDto;
import com.suchan.startspringaws.web.dto.PostsResponseDto;
import com.suchan.startspringaws.web.dto.PostsSaveRequestDto;
import com.suchan.startspringaws.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/*
    @RequiredArgsConstructor가 final이 선언된 모든 필드를 인자값으로 하는 생성자를 생성해준다.
    생성자를 안 쓰고 롬복을 사용한 이유는 해당 클래스의 의존성 관계가 변경될 때마다 생성자 코드를 계속해서 수정하는 번거로움을 해결하기 위해서
 */

/*
    update 기능에서 DB 쿼리가 없는 이유? JPA의 영속성 때문이다.
    영속성 컨텍스트란 엔티티를 영구 저장하는 환경을 뜻한다.
    JPA의 핵심 내용은 엔티티가 영속성 컨텍스트에 포함되어 있냐 아니냐로 결정된다.
    JPA의 엔티티 매니저가 활성화된 상태(Spring Data Jpa를 쓰면 기본 옵션) 트랙잭션 안에서 데이터베이스 데이터를 가져 오면 이 데이터는 영속선 컨텍스트가 유지된 상태
 */

@RequiredArgsConstructor
@RestController
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        postsRepository.delete(posts);
    }
}
