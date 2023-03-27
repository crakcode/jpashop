package jpabook.jpashop.service;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.exception.NotEnoughStockException;
import jpabook.jpashop.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderServiceTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;


    public Long initiaize(){
        //given
        Member member=new Member();
        member.setUsername("회원1");
        member.setAddress(new Address("서울","강가","123-123"));
        em.persist(member);

        Book book=new Book();
        book.setPrice(9000);
        book.setName("자유서적");
        book.setStockQuantity(10);
        em.persist(book);
        //when
        Long orderId=orderService.order(member.getId(),book.getId(),5);

        return orderId;
    }


    @Test
    public void 상품주문() throws Exception{
        //given
        Member member=new Member();
        member.setUsername("회원1");
        member.setAddress(new Address("서울","강가","123-123"));
        em.persist(member);

        Book book=new Book();
        book.setPrice(9000);
        book.setName("자유서적");
        book.setStockQuantity(10);
        em.persist(book);
        //when
        Long orderId=orderService.order(member.getId(),book.getId(),5);
        Order order=orderRepository.findOne(orderId);

        //then

        System.out.println(order.getTotalPrice());
        System.out.println(book.getStockQuantity());
        for(OrderItem orderItem :order.getOrderItems()){
            System.out.println(orderItem.getItem().getName());
        }


    }
    @Test
    public void 주문취소() throws Exception{
        //given
        Long orderId=initiaize();

        //when
        orderService.cancelOrder(orderId);

        //then
        Order order=orderRepository.findOne(orderId);
        System.out.println(order.getStatus());
        System.out.println(order.getOrderItems().get(0).getItem().getStockQuantity());
    }
    @Test(expected= NotEnoughStockException.class)
    public void 상품주문_재고량초과() throws Exception{
        //given

        //when

        //then

    }
}