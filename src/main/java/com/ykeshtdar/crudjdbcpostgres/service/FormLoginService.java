package com.ykeshtdar.crudjdbcpostgres.service;

import com.ykeshtdar.crudjdbcpostgres.dao.*;
import com.ykeshtdar.crudjdbcpostgres.model.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class FormLoginService {
    private final FormLoginDAO formLoginDAO;

    public FormLoginService(FormLoginDAO formLoginDAO) {
        this.formLoginDAO = formLoginDAO;
    }

    public FormLogin addUser(FormLogin formLogin) {
        formLoginDAO.initialDatabaseTable();
        return formLoginDAO.addFormLogin(formLogin);
    }

    public FormLogin findById(Integer id) {
//        return formLoginDAO.findById(id) != null;
        return formLoginDAO.findById(id);
    }

    public FormLogin findByEmail(String email) {
        return formLoginDAO.findByEmail(email);
    }

    public FormLogin displayUserById(Integer id) {
        return formLoginDAO.displayUserById(id);
    }

    public FormLogin updateUser(FormLogin formLogin) {
        if (isUserExist(formLogin.getId())) {
         return formLoginDAO.updateUser(formLogin);
        }else throw new RuntimeException("user not founded");
    }

    private boolean isUserExist(Integer id) {
        return findById(id) != null;
    }

    public List<FormLogin> displayAllUser() {
        return formLoginDAO.displayAllUser();
    }
}
