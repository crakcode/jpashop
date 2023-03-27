package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

// 회원가입고 중복회원 가입 안되는걸 테스트
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

//
    @Test
    @Rollback(value = false)
    public void 회원가입() throws Exception{
        // given
        Member member=new Member();
        member.setUsername("신현중");

        // when
        memberService.join(member);

        // then
        assertEquals(member,memberRepository.findOne(member.getId()));

    }


    @Test(expected = IllegalStateException.class)
    @Rollback(false)
    public void 중복_회원() throws Exception{
        // given
        Member member1=new Member();
        member1.setUsername("신현중");

        Member member2=new Member();
        member2.setUsername("신현중");

        // when
        memberService.join(member1);
        memberService.join(member2); //예외가 발생해야 한다.

        //then
        fail("must be happen exception ");
    }
}