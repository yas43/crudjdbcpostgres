package com.ykeshtdar.crudjdbcpostgres.dao;

import com.ykeshtdar.crudjdbcpostgres.config.*;
import com.ykeshtdar.crudjdbcpostgres.model.*;
import org.springframework.stereotype.*;

import java.sql.*;
import java.util.*;

@Component
public class FormLoginDAO {
    DatabaseConfig databaseConfig = new DatabaseConfig();

    public FormLogin findById(Integer id){
        Connection con = null;
        FormLogin formLogin = new FormLogin();
        try {
            con = databaseConfig.getConnection();
            PreparedStatement ps = con.prepareStatement(DBConstant.GET_USER_By_ID);
            ps.setInt(1,id);
            ps.execute();
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                formLogin.setId(rs.getInt(1));
                formLogin.setEmail(rs.getString(2));
                formLogin.setPassword(rs.getString(3));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }finally {
            databaseConfig.closeConnection(con);
        }
        return formLogin;
    }


    public FormLogin findByEmail(String email){
        Connection con = null;
        FormLogin formLogin = new FormLogin();
        try {
            con = databaseConfig.getConnection();
            PreparedStatement ps = con.prepareStatement(DBConstant.GET_USER_By_EMAIL);
            ps.setString(1,email);
            ps.execute();
            ResultSet rs = ps.executeQuery();
//            return rs.next();
            while (rs.next()){
                formLogin.setId(rs.getInt(1));
                formLogin.setEmail(rs.getString(2));
                formLogin.setPassword(rs.getString(3));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }finally {
            databaseConfig.closeConnection(con);
        }
        return formLogin;
    }

    public FormLogin addFormLogin(FormLogin formLogin) {
        Connection conn = databaseConfig.getConnection();
        FormLogin formLogin1 = new FormLogin();
        try {
            PreparedStatement ps = conn.prepareStatement(DBConstant.ADD_USER);
            ps.setString(1,formLogin.getEmail());
            ps.setString(2, formLogin.getPassword());
//            ps.executeUpdate();
            ResultSet rs = ps.executeQuery();
//            ResultSet rs = ps.executeUpdate();
//            System.out.println("rs is "+rs);
            if (rs.next()){
                formLogin1.setId(rs.getInt(1));
                formLogin1.setEmail(rs.getString(2));
                formLogin1.setPassword(rs.getString(3));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            databaseConfig.closeConnection(conn);
            return formLogin1;
        }
    }

    public void initialDatabaseTable(){
        Connection con = databaseConfig.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(DBConstant.initialDatabase);
            ps.executeQuery();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            databaseConfig.closeConnection(con);
        }
    }


    public FormLogin displayUserById(Integer id) {
        Connection con = databaseConfig.getConnection();
        FormLogin formLogin = new FormLogin();
        try {
            PreparedStatement ps = con.prepareStatement(DBConstant.DISPLAY_USER);
            ps.setInt(1,id);
           ResultSet rs =  ps.executeQuery();
            while (rs.next()){
                formLogin.setId(rs.getInt(1));
                formLogin.setEmail(rs.getString(2));
                formLogin.setPassword(rs.getString(3));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            databaseConfig.closeConnection(con);
            return formLogin;
        }
    }

    public FormLogin updateUser(FormLogin formLogin) {
        Connection con = databaseConfig.getConnection();
        FormLogin formLogin1 = new FormLogin();
        try {
            PreparedStatement ps = con.prepareStatement(DBConstant.UPDATE_USER);
            ps.setString(1,formLogin.getEmail());
            ps.setString(2,formLogin.getPassword());
            ps.setInt(3,formLogin.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                formLogin1.setId(rs.getInt(1));
                formLogin1.setEmail(rs.getString(2));
                formLogin1.setPassword(rs.getString(3));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            databaseConfig.closeConnection(con);
            return formLogin1;
        }
    }

    public List<FormLogin> displayAllUser() {
        Connection con = databaseConfig.getConnection();
//        FormLogin formLogin = new FormLogin();
        List<FormLogin>formLoginList = new LinkedList<>();
        try {
            PreparedStatement ps = con.prepareStatement(DBConstant.DISPLAY_ALL_USER);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = (rs.getInt(1));
                String email = (rs.getString(2));
                String password = (rs.getString(3));
                formLoginList.add(new FormLogin(id,email,password));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            databaseConfig.closeConnection(con);
            return formLoginList;
        }
    }
}
