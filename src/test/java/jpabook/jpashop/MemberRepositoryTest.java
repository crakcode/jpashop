package jpabook.jpashop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class MemberRepositoryTest {


    @Autowired
    public MemberRepository memberRepository;

    Member member=new Member();

    @Test
    @Transactional
    @Rollback(false)
    public void testMember(){
        Member member=new Member();
        member.setUsername("memberA");

        Long saveId=memberRepository.Save(member);
        Member findmember=memberRepository.find(saveId);

        System.out.println(member.getId());
        System.out.println(findmember.getId());

    }

}