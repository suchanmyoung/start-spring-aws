package com.suchan.startspringaws.web.dto;

import com.suchan.startspringaws.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
    Entity 클래스와 거의 유사한 형태임에도 Dto 클래스를 추가로 생성한 이유는 Entity 클래스는 DB와 맞닿은 핵심 클래이기 떄문이다.
    Entity 클래스를 ㅣㄱ준으로 테이블이 생성되고, 스키마가 변경되기 때문에 화면 변경이라는 사소한 기능 변경으로 Entity 클래스를 변경하는 것은 위험하다.
 */

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
