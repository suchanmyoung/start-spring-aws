package com.suchan.startspringaws.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/*
    Auditing은 Spring Dat JPA에서 시간에 대해서 자동으로 값을 넣어주는 기능
    @MappedSuperclass : JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 필드들도 칼럼으로 인식
    @EntityListeers : BaseTimeEntity 클래스에 Auditing 기능을 포함
    @CreatedDate : Entity가 생성되어 저장될 때 시간이 자동 저장
    @LastModifiedDate : 조회한 Entity 값을 변경할 때 시간이 자동 저장
 */

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

}
