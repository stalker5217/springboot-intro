package com.springboot.domain.posts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * MyBatis와 같은 SQL Mapper를 사용하는 경우에는 Dao라고 부르는 DB Layer 접근자이다.
 * interface 생성 후 <Entity_Class, PK_type>을 상속하면,
 * 기본적인 CRUD 메소드가 자동으로 생성된다.
 *
 * 주의할 점은, Entity Class와 같은 패키지에 위치 해야 한다.
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
