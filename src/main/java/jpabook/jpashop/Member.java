package jpabook.jpashop;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // JPA 에서 데이터 테이블로 인식하게
@Getter @Setter
public class Member {

    @Id // PK임을 알림
    @GeneratedValue // PK값을 자동 생성
    private Long id;
    private String username;
}
