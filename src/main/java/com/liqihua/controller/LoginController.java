package com.liqihua.controller;

import com.liqihua.dao.interf.SysUserDao;
import io.shardingjdbc.core.jdbc.core.datasource.MasterSlaveDataSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/loginController")
public class LoginController {
    @Resource
    private MasterSlaveDataSource dataSource;
    @Resource
    private SysUserDao userDao;

    @RequestMapping("/login1")
    public String login1(){
        String sql = "SELECT * FROM sys_user";
        try {
            Connection conn =dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String id = rs.getString("id");
                String username = rs.getString("username");
                System.out.println("id:"+id+",username:"+username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "-- login1 --";
    }


    @RequestMapping("/login2")
    public String login2(){
        String id = "id-"+System.currentTimeMillis();
        String username = "un-"+System.currentTimeMillis();
        String password = "pw-"+System.currentTimeMillis();
        String locked = "0";
        String gender = "1";
        String nickname = "nn-"+System.currentTimeMillis();
        String createDate = new Date().toLocaleString();
        String updateDate = new Date().toLocaleString();

        String sql = "INSERT INTO sys_user VALUES ('"+id+"','"+username+"','"+password+"','"+locked+"','"+gender+"','"+nickname+"','"+updateDate+"','"+createDate+"')";
        try {
            Connection conn =dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            int num = ps.executeUpdate();
            System.out.println("num:"+num);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "-- login2 --";
    }



    @RequestMapping("/login3")
    public String login3(){
        List<Map<String,Object>> list = userDao.findListSQL("SELECT * FROM sys_user");
        System.out.println(list);
        return "-- login3 --";
    }



}
