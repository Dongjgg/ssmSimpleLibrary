package com.dj.dao;

import com.dj.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.awt.print.Book;
import java.util.List;
import java.util.Map;

public interface BookMapper {
    //增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBookById(@Param("bookId") int id);
    //更新一本书
    int updateBook(Books books);
    //查询一本书
    Books queryBookById(@Param("bookId")int id);
    //查询所有书
    List<Books> queryAllBook();

    //查询书籍通过书名
    List<Books> queryBookByName(@Param("bookName")String bookName);

    //书籍分页
    List<Book> getBookByLimit(int startIndex);

}
