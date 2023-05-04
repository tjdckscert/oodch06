/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.se.ood.model.ch06;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * Author     : tjdckscert
 */
@Slf4j
public class AddBookManager {
    
    private String mysqlServerIp;
    private String mysqlServerPort;
    private String userName;
    private String password;
    private String jdbcDriver;
    
    public AddBookManager() {
        log.debug("AddBookManager() : mysqlServerIp = {}, jdbcDriver = {}", mysqlServerIp, jdbcDriver);
    }
    
    public AddBookManager(String mysqlServerIp, String mysqlServerPort, String userName, String password, String jdbcDriver) {
        this.mysqlServerIp = mysqlServerIp;
        this.mysqlServerPort = mysqlServerPort;
        this.userName = userName;
        this.password = password;
        this.jdbcDriver = jdbcDriver;
        log.debug("AddBookManager() : mysqlServerIp = {}, jdbcDriver = {}", mysqlServerIp, jdbcDriver);
    }
    
    public List<AddBookRow> getAllRows() {
        List<AddBookRow> dataList = new ArrayList<>();
        final String JDBC_URL = String.format("jdbc:mysql://%s:%s/webmail?serverTimezone=Asia/Seoul", this.mysqlServerIp, this.mysqlServerPort);
        
        log.debug("AddBookManager() : mysqlServerIp = {}, jdbcDriver = {}", mysqlServerIp, jdbcDriver);
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            Class.forName(jdbcDriver);
            conn = DriverManager.getConnection(JDBC_URL, userName, password);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM addbook";
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                String email = rs.getString("email");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                dataList.add(new AddBookRow(email, name, phone));
            }
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception ex) {
            log.error("오류가 발생했습니다. (발생 오류: {})", ex.getMessage());
        }
        
        return dataList;
    }    
    
    public void addRow(String email, String name, String phone) {
        final String JDBC_URL = String.format("jdbc:mysql://%s:%s/webmail?serverTimezone=Asia/Seoul", mysqlServerIp, mysqlServerPort);
        
        log.debug("JDBC_URL = {}", JDBC_URL);
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            Class.forName(jdbcDriver);
            conn = DriverManager.getConnection(JDBC_URL, this.userName, this.password);
            String sql = "INSERT into addbook VALUES(?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, name);
            pstmt.setString(3, phone);
            pstmt.executeUpdate();
            if (pstmt != null) {
                pstmt.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }            
        } catch (Exception ex) {
            log.error("오류가 발생했습니다. (발생 오류: {})", ex.getMessage());
        }
    }
}