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
    public int bookUpdate(Book book){
        int i = bookDao.bookUpdate(book);
        return i;
    }
    public int bookDelete(int id){
        int i = bookDao.bookDelete(id);
        return i;
    }
    public int getCount(){
        int i = bookDao.getCount();
        return i;
    }

    public Book getBookById(int id){
        return bookDao.getBookById(id);
    }


    @Test
    public void T(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        int i = bookService.bookAdd(new Book("2-Java编程思想", 2, "1"));
        int j = bookService.bookAdd();
        System.out.println(i);
        System.out.println(j);
    }

    @Test
    public void T2_update(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        int i = bookService.bookUpdate(new Book("修改_Java编程思想", 1, "x_1"));
        System.out.println(i);
        int j = bookService.bookDelete(2);
        System.out.println(j);
    }

    @Test
    public void T3_count(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        int count = bookService.getCount();
        System.out.println(count);
    }
    @Test
    public void T3_getBookById(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book b = bookService.getBookById(2);
        System.out.println(b);
    }
}
