package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    //등록 API
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    //수정 API
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    //조회 API
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    //삭제 API
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}
/**
 * {id}는 템플릿 변수이고, 이 값을 @PathVariable을 붙인 파라미터 변수 값으로 사용한다.
 * ex) 요청이 /api/v1/posts/3으로 들어왔다면, update의 파라미터 Long id의 값은 3이된다.
 *
 * @RequestBody, @ResponseBody의 의미
 * Request는 요청 Http Body의 내용을 자바 객체로 변환
 * Response는 자바 객체를 응답 Http Body에 담는다.
 *
 * REST규약 메서드
 * 생성(Create) - POST
 * 읽기(Read) - GET
 * 수정(Update) - PUT
 * 삭제(Delete) - DELETE
 *
 * 실제 CRUD요청을 받아 service로 처리하는 컨트롤러이다.
 */
