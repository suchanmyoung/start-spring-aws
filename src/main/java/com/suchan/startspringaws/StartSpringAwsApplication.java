package com.suchan.startspringaws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/*
@SpringBootApplication으로 부트의 자동 설정, Bean 읽기와 생성 모두 자동으로 설정.
이 위치로부터 설정을 읽기 때문에 항상 프로젝트의 최상단에 위치해야 함.
내장 WAS도 여기 붙어 있음
외장 WAS를 쓰면 모든 서버가 같은 WAS 환경을 일치시켜야 하지만, 내장 WAS는 언제 어디서나 같은 환경에서 스프링 부트를 배포 가능
 */

@EnableJpaAuditing
@SpringBootApplication
public class StartSpringAwsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartSpringAwsApplication.class, args);
	}

}
