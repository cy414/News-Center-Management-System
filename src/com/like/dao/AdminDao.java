package com.like.dao;

import com.like.domain.Admin;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {
    //获取连接
    Connection conn = DBUtil.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;

    //根据用户名和密码查询用户信息
    public Admin selectUser(String username, String password) {
        Admin admin = new Admin();

        //去数据库查询账号密码
        String sql = "select * from admin where adminname=? and adminpass=?";
        try {
            //查询
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();

            // 封装数据
            while (rs.next()) {
                admin.setAdmind(rs.getInt(1));
                admin.setAdminname(rs.getString(2));
                admin.setAdminpass(rs.getString(3));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //6. 关闭数据库资源
            DBUtil.close(conn, ps, rs);
        }

        return admin;
    }
}
