package com.dj.controller;

import com.dj.pojo.Books;
import com.dj.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.awt.print.Book;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/book")
public class BookController {
    //controller层调service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    //查询全部的书籍，并且返回到一个书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model, HttpSession session){

        List<Books> list = bookService.queryAllBook();
        List<Books> list1 = list.subList(0,8);
        model.addAttribute("list",list1);

        //总记录条数,传回页面总数，我固定页面大小为8
        List<Books> bookNum = bookService.queryAllBook();
        session.setAttribute("pageNum",(int)Math.ceil(bookNum.size()/8.0));
        System.out.println("================"+(int)Math.ceil(bookNum.size()/8.0));

        return "allBook";
    }


    //跳转到增加书籍界面
    @RequestMapping("/toAddBook")
    public String toAddPage(){
        return "addbook";
    }

    //添加书籍请求
    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("addBook=>"+books);
        bookService.addBook(books);
        return "redirect:/book/allBook";  //重定向到我们的CRequesthapping("/allBook")请求;
    }

    //跳转到更新书籍页面
    @RequestMapping("/toUpdate")
    public String toUpdatePage(int id,Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("book",books);
        return "updateBook";
    }

    //修改书籍信息请求
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        System.out.println("updateBook=>"+books);
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }

    //删除书籍
    @RequestMapping("/del/{bookID}")
    public String deleteBook(@PathVariable("bookID") int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    //查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        List<Books> list = bookService.queryBookByName(queryBookName);
        model.addAttribute("list",list);
        return "allBook";
    }

    @RequestMapping("/limitPage")
    //startIndex数据库索引的起始位置，也是传过来的页码
    public String limitPage(int startIndex,Model model){
        System.out.println("传过来的页码"+startIndex);
        List<Books> totalDataSize = bookService.queryAllBook();
        int currPage = 0;
        if (startIndex>=0 && startIndex <= (int)Math.ceil(totalDataSize.size()/8.0)){
            if (startIndex>=1){
                currPage = (startIndex-1)*8;
                System.out.println("startIndex>=1时"+currPage);
            }else {
                currPage = 0;
            }
            List<Book> list = bookService.getBookByLimit(currPage);
            model.addAttribute("list",list);
            //返回当前页码，给前端
            model.addAttribute("nowPage",(int)Math.ceil(currPage/8.0));
            System.out.println("返回的页码："+((int)Math.ceil(currPage/8.0)+1));
        }else if (startIndex > (int)Math.ceil(totalDataSize.size()/8.0)){  //处理下一页没有了，直接返回第一页
            List<Book> list = bookService.getBookByLimit(0);
            model.addAttribute("list",list);
        }
        return "allBook";
    }
}
