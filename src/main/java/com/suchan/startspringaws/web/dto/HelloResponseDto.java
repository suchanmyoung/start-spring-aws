package com.suchan.startspringaws.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/*
RequiredArgsCostructor : 선언된 모든 final 필드가 포함된 생성자를 생성해 준다. final이 없는 빌드는 생성자에 포함하지 않음
 */

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
