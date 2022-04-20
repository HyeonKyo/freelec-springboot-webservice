package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}

/**
 * Posts클래스로 Database를 접근하게 해주는 JPA Repository이다. (Entity의 기본 레포지토리)
 *
 * 인터페이스를 만들고, JpaRepository<Entity클래스, PK타입>만 상속하면
 * 기본 CRUD메서드가 자동으로 생성된다. (@Repositoty를 추가할 필요도 없다)
 *
 * [주의점] : Entity클래스와 기본 Entity Repository는 함께 위치해야 한다.
 */
