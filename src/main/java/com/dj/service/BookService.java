package com.dj.service;

import com.dj.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.awt.print.Book;
import java.util.List;
import java.util.Map;

public interface BookService {
    //增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBookById(int id);
    //更新一本书
    int updateBook(Books books);
    //查询一本书
    Books queryBookById(int id);
    //查询所有书
    List<Books> queryAllBook();
    //通过名字查书籍
    List<Books> queryBookByName(String bookName);
    //书籍分页
    List<Book> getBookByLimit(int startIndex);
}
