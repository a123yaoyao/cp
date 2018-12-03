package com.cn.count;

import com.cn.count.model.CwrProject;
import com.google.gson.Gson;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import javax.sql.RowSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


/**
 * @Auther: Administrator
 * @Date: 2018/11/30/030 15:01
 * @Description:
 */
@PropertySource(value = "classpath:conn_oracle.properties", ignoreResourceNotFound = true)
public  class MysqlDataSyncToOracleTest {

    Logger logger = LoggerFactory.getLogger(MysqlDataSyncToOracleTest.class);

    @Value("${URL}")
    String URL ;

    @Test
    public  void oracleDataSyncToMysql(){
        Connection conn;
        try {
            System.out.println("URL:"+URL);

           conn =JDBCConnect.getConnect("jdbc:oracle:thin:@47.93.87.207:1522:ticwr","ticwr","ticwr@2017THIT");
           PreparedStatement pst= conn.prepareStatement("select * from CWR_PROJECT where rownum < 100");
            ResultSet rs = pst.executeQuery();
            String[] colNames = JDBCConnect.getColNames(rs);
            List<Object> list = JDBCConnect.getObjects( rs,CwrProject.class);
            System.out.println(list);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCConnect.closeCon();
        }

    }

}
