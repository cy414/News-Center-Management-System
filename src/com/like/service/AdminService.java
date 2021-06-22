package com.like.service;

import com.like.dao.AdminDao;
import com.like.domain.Admin;
import util.DBUtil;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminService {

    //验证账号密码
    public String verifyAccount(String username, String password, HttpSession session) {
        Admin admin = new Admin();
        String status;
        AdminDao adminDao = new AdminDao();
        admin = adminDao.selectUser(username, password);

        //登录成功
        if (admin.getAdminname() != null ){
            //将结果存到session中
            session.setAttribute("admin", admin);
            session.setAttribute("status", null);
            status = "success";
        }
        //登录失败
        else{
            session.setAttribute("status", "账号或密码错误...");
            status = "fail";
        }

        return status;
    }
}
