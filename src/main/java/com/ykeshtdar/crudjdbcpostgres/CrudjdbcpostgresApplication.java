package com.ykeshtdar.crudjdbcpostgres;

import com.ykeshtdar.crudjdbcpostgres.dao.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudjdbcpostgresApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrudjdbcpostgresApplication.class, args);

//		FormLoginDAO formLoginDAO = new FormLoginDAO();
//		formLoginDAO.isUserExist(1);
	}

}
