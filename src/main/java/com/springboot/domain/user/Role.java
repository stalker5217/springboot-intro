package com.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    /**
     * Spring Security에서는 권한 코드 앞에 항상 'ROLE_'이 prefix로 붙어야 한다.
     */
    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반사용자");

    private final String key;
    private final String title;
}
