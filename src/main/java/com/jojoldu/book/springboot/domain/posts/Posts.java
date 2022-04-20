package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

/**
 * Getter와 NoArgs~~는 롬복의 어노테이션이므로 필수가 아니다.
 * 따라서 필수 JPA어노테이션인 Entity를 클래스와 가까이 위치시키면 이후 롬복이 필요없어져도
 * 손쉽게 삭제가 가능하다.
 *
 * 이 Posts클래스는 실제 DB테이블과 매칭되는 클래스이며, Entity클래스라고도 한다.
 *
 * [JPA 어노테이션]
 * @Entity : 테이블과 링크될 클래스임을 나타낸다.
 *          기본값으로 클래스 카멜케이스 이름과 언더스코어 네이밍의 테이블을 매칭한다.
 *
 * @Id : 해당 테이블의 PK필드를 나타냄
 *
 * @GeneratedValue
 *  - PK 생성 규칙을 나타냄
 *  - GenerationType.IDENTITY는 auto_increment설정임
 *
 * @Column
 * - 테이블의 컬럼을 의미 (굳이 선언하지 않아도 해당 클래스의 필드는 모두 컬럼이 됨)
 * - 그럼에도 사용하는 이유는 추가로 변경이 필요한 옵션을 사용할 때가 있으므로
 * - ex) title의 length는 varchar사이즈를 500으로 설정한 것이다.
 *
 * [참고]
 * Entity의 PK는 Long타입의 Auto_increment를 권장함. 주민번호처럼 비즈니스상에서 유니크한 키나, 여러 키를 조합한
 * 복합키로 PK를 잡으면 난감한 상황이 종종 발생함.
 * 1) FK를 맺을 때, 다른 테이블에서 복합키 전부를 가지고 있거나, 중간 테이블을 하나 더 둬야하는 상황 발생
 * 2) 인덱스에 좋은 영향을 끼치지 못함
 * 3) 유니크한 조건이 변경될 경우 PK 전체를 수정해야 하는 일이 발생
 * 따라서 주민번호, 복합키 등은 그냥 유니크 키로 별도로 추가하는 것을 추천함
 *
 * [lombok 어노테이션]
 * @NoArgsConstructor : 기본 생성자 자동 추가
 *
 * @Builder
 *  - 해당 클래스의 빌더 패턴 클래스를 생성
 *  - 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
 * -> 빌더 패턴 : 싱글톤 패턴처럼 생성 패턴 중 하나임.
 *    생성자 대신 빌더를 쓰는 이유는 어떤 필드에 어떤 값을 채워야하는지 개발자가 명확히 인식할 수 있기 때문임
 *
 * [참고2]
 * Entity클래스는 setter를 무작정 만들지 않는다!!
 * 무분별한 setter생성은 해당 클래스의 인스턴스 값들이 언제 어디서 변해야 하는지 코드상으로 명확하게 구분할 수 없게 된다.
 * 따라서 Entity클래스에는 setter를 절대!! 만들지 않는다.
 * 필드 값 변경이 필요하면 그 변경에 해당하는 메서드를 따로 만들어서 처리한다.
 *
 *
 */