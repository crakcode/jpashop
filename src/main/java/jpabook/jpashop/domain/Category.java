package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Category {


    @Id @GeneratedValue
    @Column(name="category_id")
    private Long id;

    private String name;


    // Category 구조 설정하여 M:N으로 ㅅ설정하기
    @ManyToMany
    @JoinTable (name="category_item",
                joinColumns = @JoinColumn(name="category_id"),
                inverseJoinColumns = @JoinColumn(name="item_id"))
    private List<Item> items=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child =new ArrayList<>();

}
