package com.suchan.startspringaws.domain.posts;

/*
    보통 매퍼에서 Dao라고 불리는 DB Layer 접근자
    JPA에선 Repository라고 부르며 인터페이스로 생성
    JpaRepository를 상속 받으면 CRUD 메소드가 자동으로 생성
 */

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}
