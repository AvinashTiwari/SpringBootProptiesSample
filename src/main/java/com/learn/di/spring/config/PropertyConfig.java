package com.learn.di.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.learn.di.spring.examplebeans.FakeDataSource;

@Configuration
@PropertySource("classpath:datasource.properties")
public class PropertyConfig {
	@Value("${guru.username}")
	String username;
	@Value("${guru.password}")
	String password;
	@Value("${guru.dburl}")
	String url;
	
	@Bean
	public FakeDataSource fakeDataSource(){
		FakeDataSource fakeDataSource = new FakeDataSource();
		fakeDataSource.setUser(username);
		fakeDataSource.setPassword(password);
		fakeDataSource.setUrl(url);
		return fakeDataSource;
		
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		return propertySourcesPlaceholderConfigurer;
	}
}
