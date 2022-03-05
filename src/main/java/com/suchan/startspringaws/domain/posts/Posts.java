package com.suchan.startspringaws.domain.posts;

import com.suchan.startspringaws.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*  JPA
    @Entity : 테이블과 링크될 클래스. 기본값으로 클래스의 카멜 케이스 > 스네이크 네이밍으로 테이블 이름 매칭
    @Id : 해당 테이블의 PK
    @GeneratedValue : PK의 생성 규칙, GenerationType.IDENTIFY를 추가하면 auto_increment
    @Column : 선언하지 않아도 클래스의 필드는 모두 칼럼이 되나 Customize가 필요할 경우 선언함
    문자열의 경우 VARCHAR(255)가 기본값이지만 사이즈를 늘릴 때나, 타입을 TEXT로 변경할 때나.
 */

/*  Lombok
    @NoArgsConstructor : 기본 생성자 자동 추가(public Post(){})
    @Builder : 해당 클래스의 빌더 패턴 클래스 생성. 생성자에 포함된 빌드만 빌더에 포함
 */


@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String content;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String title;
    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
