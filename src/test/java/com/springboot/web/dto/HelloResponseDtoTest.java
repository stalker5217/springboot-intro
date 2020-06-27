package com.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * assertj : 테스트 검증 라이브러리
 * JUnit 대비 장점
 * 1. CoreMatchers와 달리 추가적으로 라이브러리가 필요하지 않음
 * 2. 자동완성이 좀 더 확실하게 지원됌
 */
public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트(){
        // given
        String name = "test";
        int amount = 10000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
