package com.springboot.domain.posts;

import com.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

/**
 * @Entity : JPA의 annotation. 실제 DB 테이블에 링크될 클래스를 나타냄.
 * @NoArgsContructor : lombok의 annotation. 비어 있는 기본 생성자를 자동 추가. public Post(){}
 * @Getter : getter method 자동 생성
 *
 * Entity class에서는 setter를 절대 만들지 않는다. 값의 변경이 필요 하면 명확히 의도와 목적을 나타낼 수 있는 메소드를 별도로 생성한다.
 */

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id // PK를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    /**
     * Builder Pattern은 유용하다.
     * 만약, public Cons(String a, String b) { this.a = a; this.b = b; } 라는 생성자가 있다고 했을 때,
     * 개발자가 실수로 값을 바꿔, new Cons(b, a)로 넣었을 때에 실행 전까지는 문제를 찾을 수 없다.
     *
     * 하지만, Builder를 사용하면 어느 필드에 어떤 값을 채울지 명확히 할 수 있다.
     * Cons.Builder()
     *  .a(a)
     *  .b(b)
     *  .build();
     */

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
