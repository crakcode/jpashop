package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

//  회원가입 과 중복확인, 모든 회원조회
//  Transactional 의 경우 원래 readOnly값이 false라서 전체적으로 True 인 경우 위에서 정의 하고 특정한것에만 변경

//    RequiredArgsConstructor 이 어노테이션을 넣어주서ㅓ Autowired필요없음 생성자로 구현
    private final MemberRepository memberRepository;

//  readonly가  false이면 읽기만 하지 않는다는것ㄱ
    @Transactional(readOnly = false)
    public Long join(Member member){
        vaildateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    public void vaildateDuplicateMember(Member member){
        List<Member> findMembers=memberRepository.findByName(member.getUsername());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("User is already exist.");
        }
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    public Member findOne(Long memberid){
        return memberRepository.findOne(memberid);
    }


}
