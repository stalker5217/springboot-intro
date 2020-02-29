package com.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Getter : 선언된 모든 필드의 getter를 생성해 줍니다.
 * RequiredArgsConstructor : 선언된 final field가 포함된 생성자를 생성해줍니다.
 */

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {

    private final String name;
    private final int amount;
}
