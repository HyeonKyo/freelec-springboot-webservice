package com.jojoldu.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter //선언된 모든 필드의 getter자동생성
@RequiredArgsConstructor //final로 선언된 모든 필드가 포함된 생성자 생성
public class HelloResponseDto {
    
    private final String name;
    private final int amount;

}
