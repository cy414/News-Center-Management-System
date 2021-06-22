package com.like.service;

import com.like.dao.NewsDao;
import com.like.domain.NewInfor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class NewsService {

    //查询所有新闻
    public List<NewInfor> getAllNews() {
        NewsDao newsDao = new NewsDao();
        List<NewInfor> list;

        list = newsDao.selectAllNews();
        return list;
    }


    //根据关键字搜索所有新闻的标题
    public List<NewInfor> searchNews(String keyword) {
        NewsDao newsDao = new NewsDao();
        List<NewInfor> list;

        list = newsDao.selectByKeyword(keyword);
        return list;
    }

    //根据id获取文章内容
    public NewInfor getNewsById(Integer id) {
        NewsDao newsDao = new NewsDao();
        NewInfor newsInfor;

        newsInfor = newsDao.selectById(id);
        return newsInfor;
    }

    //添加新闻
    public int addNews(String title, String type, String author, String content) {
        NewsDao newsDao = new NewsDao();
        Timestamp now = new Timestamp(new Date().getTime());
        int rs = 0;

        //添加新闻
        rs = newsDao.insertNews(title, type, author, content, now);
        return rs;
    }

    //删除文章
    public void deleteNews(Integer id) {
        NewsDao newsDao = new NewsDao();
        newsDao.delete(id);
    }

    //更新文章
    public int update(String title, String type, String author, String content) {
        NewsDao newsDao = new NewsDao();
        Timestamp now = new Timestamp(new Date().getTime());
        int rs = newsDao.update(title, type, author, content, now);
        return rs;
    }

    //根据用户名查出他所发布的文章
    public List<NewInfor> getNewsByUserName(String adminname) {
        NewsDao newsDao = new NewsDao();
        List<NewInfor> list = newsDao.selectByUserName(adminname);
        return list;
    }
}
