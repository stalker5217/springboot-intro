package com.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * 모든 Entity의 상위 클래스가 되어, 데이터 생성, 수정일을 자동으로 관리하는 역할.
 *
 * @MappedSuperclass : JPA Entity class들이 이 클래스를 상속했을 때, 멤버들을 column으로 인식할 수 있게함.
 * @EntityListener(AuditingEntityListener.class) : Auditing 기능을 포함시킴.
 */

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {
    
    // Entity가 생성되어 저장될 때 시간이 자동 저장
    @CreatedDate
    private LocalDateTime createdDate;
    
    // 조회된 Entity가 수정될 때 시간이 자동 저장
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
