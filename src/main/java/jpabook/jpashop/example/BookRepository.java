package jpabook.jpashop.example;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BookRepository {

  @PersistenceContext
  private EntityManager em;

  @Transactional
  public Long Save(Book book){
      em.persist(book);
      return book.getId();
  }

  public Book find(Long id){
      return em.find(Book.class,id);
  }

}
