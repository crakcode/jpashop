package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
//    repository는 함수를 구현 : 저장, 한명조회, 전체조회

    private final EntityManager em;

    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(Long id){
        return em.find(Member.class,id);
    }

//  JPQL은 SQL 과 비슷한데 다른점은 테이블이 아닌 Member 즉 엔티티를 가르킨다.
    public List<Member> findAll(){
        return em.createQuery("select m from Member m",Member.class)
                .getResultList();

    }

//   JPQL을 이용하여 처리하기
   public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.username=:name")
                .setParameter("name",name)
                .getResultList();
   }



}
