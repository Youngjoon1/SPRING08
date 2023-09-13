package com.care.root.confing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class FileConfig {
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		//파일업로드 환경설정
		CommonsMultipartResolver  mr = new CommonsMultipartResolver();
		mr.setMaxInMemorySize(52428800); //50MB
		mr.setDefaultEncoding("utf-8");
		return mr;
	}
}
