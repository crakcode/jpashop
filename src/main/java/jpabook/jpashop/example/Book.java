package jpabook.jpashop.example;


// Book 이라는 엔티티 생성 name price
// 책을 저장한뒤에 책을 tymeleaf로 정보 보내기


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Book {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private Integer price;

}
