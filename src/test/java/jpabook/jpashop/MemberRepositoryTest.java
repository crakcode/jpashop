package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.service.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class MemberRepositoryTest {


    @Autowired
    public MemberService memberService;

    @Test
    @Transactional
    @Rollback(false)
    public void testMember(){
        Member member =new Member();
        member.setUsername("신현중");

        memberService.join(member);

        Member member2 =new Member();
        member2.setUsername("신현중");

        memberService.join(member2);

        List<Member> memberList=memberService.findMembers();

        for(int i=0;i<2;i++){
            System.out.println(memberList.get(i).getId());
            System.out.println(memberList.get(i).getUsername());
        }


    }

}