package com.myCompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@EnableCassandraRepositories("com.myCompany.dao.")
@SpringBootApplication
public class MyDockerCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyDockerCompanyApplication.class, args);
	}
}
