package jpabook.jpashop;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {
    @Autowired  // 멤버 리파지토리 의존주입
    MemberRepository memberRepository;

    @Test // junit4 를 사용할 때는 import org.junit.Test; 를 사용
    @Transactional
    @Rollback(false) // 테스트 완료 시 자동 테이블 롤백 안 함
    public void testMember() {
        // given
        Member member = new Member();
        member.setUsername("member2");
        //when
        Long savedId = memberRepository.save(member);
        Member findMember = memberRepository.find(savedId);
        //then
        /*
        Assertion: 으로 테스트 진행
        */
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        Assertions.assertThat(findMember).isEqualTo(member); //JPA 엔티티 동일성 보장
        /*
        jpa 에서는 엔티티의같은 키값의 객체는 아예 같은 것으로 인식한다는 차이점이 있다.
        * */
        System.out.println("조회된 멤버== 입력값 멤버"+(findMember==member));

    }
}