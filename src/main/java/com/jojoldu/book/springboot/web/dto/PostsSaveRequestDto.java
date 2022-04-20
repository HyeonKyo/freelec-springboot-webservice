package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * [굳이 Posts와 비슷한 Dto객체를 따로 만든 이유?]
 *
 * Posts는 Entity클래스이다. 수많은 서비스 클래스나 비즈니스 로직들이 Entity클래스를 기준으로 동작한다.
 * 이런 클래스의 변경은 여러 클래스에 영향을 끼치게 된다.
 *
 * 그런데 Request, Response용 Dto는 View를 위한 클래스여서 변경이 잦다.
 * 또한 Controller에서 결과값으로 여러 테이블을 조인해서 줘야 하는 경우도 빈번하여 Entity클래스로는 표현하기 어렵다.
 * 따라서 Entity클래스와 Controller에서 쓸 Dto는 반드시 분리해서 사용해야한다!!
 *
 */

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    //toEntity메서드는 DTO정보를 Entity클래스 빌더에 넣어주면서 Entity객체를 만들어서 리턴해준다.
    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
