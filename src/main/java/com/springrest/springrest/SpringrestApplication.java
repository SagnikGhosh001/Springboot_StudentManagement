package com.springrest.springrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.springrest.config.JwtFilter;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
public class SpringrestApplication {
	@SuppressWarnings({"unchecked","rawtypes"})
	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean=new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/admin/*");
		registrationBean.addUrlPatterns("/course/*");
		registrationBean.addUrlPatterns("/api/*");
		registrationBean.addUrlPatterns("/student/AllStudents");
		registrationBean.addUrlPatterns("/student/StudentbyId/{id}");
		registrationBean.addUrlPatterns("/student/UpdateStudents/{id}");
		registrationBean.addUrlPatterns("/student/ForgetPassword/{email}");
		registrationBean.addUrlPatterns("/student/DeleteStudent/{id}");
		registrationBean.addUrlPatterns("/student/StudentbystudentEmail/{studentEmail}");
		registrationBean.addUrlPatterns("/student/StudentbystudentPhoneNo/{studentPhoneNo}");
		registrationBean.addUrlPatterns("/student/StudentbystudentUserName/{userName}");
		return registrationBean;
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringrestApplication.class, args);
		System.out.println("Welcome To STUDENT MANAGEMENT SYSTEM");
	}

}
