package com.jojoldu.book.springboot.service.posts;

import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor //final로 선언된 모든 필드가 포함된 생성자 생성 -> 생성자 자동주입이 적용됨
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        //Entity객체로 save작업을 수행하고 그 id값을 반환
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        //DB에 id에 해당되는 entity를 찾는다. 없으면 예외 던지기(optional로 감싸져서 리턴되기때문에 orElseThrow()메서드 사용)
        Posts posts = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        //JPA는 트랜잭션 안에서 DB의 데이터를 가져오면, 이 데이터는 '영속성 컨텍스트'가 유지된 상태다.
        //이 상태에서 Entity값을 변경하면 트랜잭션 종료 시점에 해당 테이블에 변경분을 반영한다.
        //즉, Entity값만 변경하면 Update쿼리를 날릴 필요가 없다.(더티 체킹) (repository까지 갈 필요없음)
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }
}
