package com.dj.service;

import com.dj.dao.BookMapper;
import com.dj.pojo.Books;

import java.awt.print.Book;
import java.util.List;
import java.util.Map;

public class BookServiceImpl implements BookService {

    //service调用dao层：组合dao
    private BookMapper bookMapper;
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    public List<Books> queryBookByName(String bookName) {
        return bookMapper.queryBookByName(bookName);
    }

    public List<Book> getBookByLimit(int startIndex) {
        return bookMapper.getBookByLimit(startIndex);
    }
}
