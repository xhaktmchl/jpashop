package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext // 엔티티에 주입을 해준다.
    private EntityManager em;

    // 멤버 생성 : 생성 후 멤버의 id값 반환
    public Long save(Member member){
        em.persist(member);
        return member.getId();
    }

    // 멤버 조회 : id 조회 된 멤버 객체 반환
    public Member find(Long id){
        return em.find(Member.class,id);
    }
}
