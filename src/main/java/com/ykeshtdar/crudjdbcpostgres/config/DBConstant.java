package com.ykeshtdar.crudjdbcpostgres.config;

public class DBConstant {
    public static final String DISPLAY_USER ="select * from loginform where id = ?" ;
    public static final String UPDATE_USER = "update loginform set email = ? , password = ? where id = ? returning *";
    public static final String DISPLAY_ALL_USER = "select * from loginform";
    public final String  GET_USER_By_ID= "select email from loginform where id = ?";
    public final String ADD_USER = "insert into loginform (email,password)values(?,?) returning *";
    public final String initialDatabase = "create table if not exists loginform(id serial primary key,email varchar(50),password varchar(50))";

}
