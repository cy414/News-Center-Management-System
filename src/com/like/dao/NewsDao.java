package com.like.dao;

import com.like.domain.NewInfor;
import com.like.web.NewsInfor;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsDao {
    //获取连接
    Connection conn = DBUtil.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;

    //查询所有新闻
    public List<NewInfor> selectAllNews() {
        List<NewInfor> list = new ArrayList<>();
        NewInfor newsInfor = null;

        //查询所有的新闻
        String sql = "select * from news_infor";
        try {
            //查询
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            // 封装数据
            while (rs.next()) {
                newsInfor = new NewInfor();
                newsInfor.setId(rs.getInt(1));
                newsInfor.setTitle(rs.getString(2));
                newsInfor.setContent(rs.getString(3));
                newsInfor.setAuthor(rs.getString(4));
                newsInfor.setType(rs.getString(5));
                newsInfor.setTime(rs.getTimestamp(6));
                list.add(newsInfor);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //6. 关闭数据库资源
            DBUtil.close(conn, ps, rs);
        }

        return list;
    }

    //根据关键字搜索所有新闻的标题
    public List<NewInfor> selectByKeyword(String keyword) {
        List<NewInfor> list = new ArrayList<>();
        NewInfor newsInfor;

        //查询新闻，根据标题
        String sql = "select * from news_infor where title like ?";
        try {
            //查询
            ps = conn.prepareStatement(sql);
            ps.setString(1, keyword);
            rs = ps.executeQuery();

            // 封装数据
            while (rs.next()) {
                newsInfor = new NewInfor();
                newsInfor.setId(rs.getInt(1));
                newsInfor.setTitle(rs.getString(2));
                newsInfor.setContent(rs.getString(3));
                newsInfor.setAuthor(rs.getString(4));
                newsInfor.setType(rs.getString(5));
                newsInfor.setTime(rs.getTime(6));

                list.add(newsInfor);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //6. 关闭数据库资源
            DBUtil.close(conn, ps, rs);
        }

        return list;
    }

    //根据id获取文章内容
    public NewInfor selectById(Integer id) {
        NewInfor newsInfor = new NewInfor();

        //查询所有的新闻
        String sql = "select * from news_infor where id=?";
        try {
            //查询
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            // 封装数据
            while (rs.next()) {
                newsInfor.setId(rs.getInt(1));
                newsInfor.setTitle(rs.getString(2));
                newsInfor.setContent(rs.getString(3));
                newsInfor.setAuthor(rs.getString(4));
                newsInfor.setType(rs.getString(5));
                newsInfor.setTime(rs.getTimestamp(6));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //6. 关闭数据库资源
            DBUtil.close(conn, ps, rs);
        }

        return newsInfor;
    }

    //添加新闻
    public int insertNews(String title, String type, String author, String content, Timestamp now) {
        int rs = 0;

        //添加文章
        String sql = "insert into news_infor (title,type,author,content,time) values (?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, type);
            ps.setString(3, author);
            ps.setString(4, content);
            ps.setTimestamp(5, now);
            rs = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //6. 关闭数据库资源
            DBUtil.close(conn, ps, null);
        }

        return rs;
    }

    //删除文章
    public void delete(Integer id) {
        //去数据库查询账号密码
        String sql = "delete from news_infor where id=?";
        try {
            //查询
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //6. 关闭数据库资源
            DBUtil.close(conn, ps, null);
        }
    }

    //更新文章
    public int update(String title, String type, String author, String content, Timestamp now) {
        int rs = 0;
        //更新文章
        String sql = "update news_infor set title=?,type=?,author=?,content=?,time=? where title=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, type);
            ps.setString(3, author);
            ps.setString(4, content);
            ps.setTimestamp(5, now);
            ps.setString(6, title);
            rs = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //6. 关闭数据库资源
            DBUtil.close(conn, ps, null);
        }

        return rs;
    }

    //根据用户名查出他所发布的文章
    public List<NewInfor> selectByUserName(String adminname) {
        List<NewInfor> list = new ArrayList<>();
        NewInfor newsInfor;

        //查询用户发布的新闻
        String sql = "select * from news_infor where author=?";
        try {
            //查询
            ps = conn.prepareStatement(sql);
            ps.setString(1, adminname);
            rs = ps.executeQuery();

            // 封装数据
            while (rs.next()) {
                newsInfor = new NewInfor();
                newsInfor.setId(rs.getInt(1));
                newsInfor.setTitle(rs.getString(2));
                newsInfor.setContent(rs.getString(3));
                newsInfor.setAuthor(rs.getString(4));
                newsInfor.setType(rs.getString(5));
                newsInfor.setTime(rs.getTimestamp(6));
                list.add(newsInfor);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //6. 关闭数据库资源
            DBUtil.close(conn, ps, rs);
        }

        return list;
    }
}
