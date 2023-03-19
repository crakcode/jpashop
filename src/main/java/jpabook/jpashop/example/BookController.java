package jpabook.jpashop.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/book")
    public String book(Model model){
        Book book=new Book();
        book.setName("Guide");
        bookRepository.Save(book);
        Book newbook=bookRepository.find(book.getId());
        model.addAttribute("book",newbook.getName());
        return "book";
    }

}
