package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}

/**
 * Posts클래스로 Database를 접근하게 해주는 JPA Repository이다. (Entity의 기본 레포지토리)
 *
 * 인터페이스를 만들고, JpaRepository<Entity클래스, PK타입>만 상속하면
 * 기본 CRUD메서드가 자동으로 생성된다. (@Repositoty를 추가할 필요도 없다)
 *
 * [주의점] : Entity클래스와 기본 Entity Repository는 함께 위치해야 한다.
 *
 * [참고]
 * 보통 데이터 조회는 규모가 커지면 FK조인, 복잡한 조건 등으로 Entity 클래스만으로 처리하기 어렵다.
 * 따라서 데이터 조회는 따로 조회용 프레임워크를 사용하고, 등록,수정,삭제는 SpringDataJPA로 처리한다.
 * 조회용 프레임워크는 querydsl, jooq, Mybatis가 대표적이며 보통 JPA와 querydsl이 많이 쓰인다.
 * querydsl의 장점
 * 1. 타입 안정성 : 쿼리를 문자열이 아닌 메서드로 짜기 때문에 오타나 잘못된 문법등을 IDE선에서 처리 가능하다.
 * 2. 사용하는 기업이 많다.
 * 3. 따라서 레퍼런스가 많다.
 *
 */
