package com.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // email 값으로 신규 사용자인지, 아닌지 구분하는 역할
    Optional<User> findByEmail(String email);
}
