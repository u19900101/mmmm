package service;

import bean.Book;
import config.Config;
import dao.BookDao;
import dao.BookDaoImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author lppppp
 * @create 2021-01-14 10:54
 */
@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    public int bookAdd(Book book){
        int i = bookDao.addBook(book);
        return i;
    }
    public int bookAdd(){
        int i = bookDao.addBook();
        return i;
    }

    @Test
    public void T(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        // int i = bookService.bookAdd(new Book("Java编程思想", "b_1", "1"));
        int i = bookService.bookAdd();
        System.out.println(i);
    }
}
