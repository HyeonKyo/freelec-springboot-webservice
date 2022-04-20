package com.jojoldu.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
/**
 * [JPA Auditing]
 * 거의 모든 엔티티(테이블)가 생성일, 수정일 등을 컬럼으로 가지고 있음.
 * 수정일을 매번 갱신하려면 메서드를 호출해야함.
 * 이런 것들을 편하게 자동화처리해주는 Audit기능을 JPA가 제공한다.
 *
 * [abstract class]
 * @See https://limkydev.tistory.com/188
 * 추상클래스를 의미한다. 추상클래스는 실체클래스의 공통적인 부분을 묶어놓은 클래스로 행동이나 상태가 구체적이지 않아
 * 객체 생성이 불가하다.
 * 1. 추상클래스는 실체클래스의 공통적인 부분(변수,메서드)를 추출해서 선언한 클래스 (A사 키보드, B사 키보드) -> 키보드로 통일
 * 2. 추상클래스는 객체를 생성할 수 없다! 아직은 실체성이 없고 구체적이지 않기 때문에!
 * 3. 추상클래스와 실체클래스는 상속관계!
 *
 * @MappedSuperclass
 *  JPA Etity클래스들이 BaseTimeEntity를 상속할 경우, BaseTimeEntity의 필드들도 컬럼으로 인식함
 *
 * @EntityListeners(AuditingEntityListener.class)
 *  BaseTimeEntity클래스에 Auditing기능을 포함시킴
 *
 * @CreateDate : Entity가 생성되어 저장될 때, 시간이 자동 저장된다.
 *
 * @LastModifiedDate : 조회한 Entity값을 변경할 때 시간이 자동 변경된다.
 *
 * 마지막으로 JPA Auditing 어노테이션들을 모두 활성화할 수 있도록
 * Application클래스에 활성화 어노테이션인 @EnableJpaAuditing 을 추가한다.
 *
 * */