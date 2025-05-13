plugins {
    id("java")
    id("org.springframework.boot") version "3.0.2"
    id("io.spring.dependency-management") version "1.1.0"

}

group = "org.js"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
   implementation("org.springframework.boot:spring-boot-starter-web")
   implementation("org.springframework.boot:spring-boot-starter-data-jpa")
   runtimeOnly("com.h2database:h2")
   compileOnly("org.projectlombok:lombok")
   annotationProcessor("org.projectlombok:lombok")
   testImplementation("org.springframework.boot:spring-boot-starter-test")
   implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
   // 1. 스프링 시큐리티를 사용하기 위한 스타터 추가
   implementation("org.springframework.boot:spring-boot-starter-security")
   // 2. 타임리프에서 스프링 시큐리티를 테스트하기 위한 의존성 추가
   implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity6")
   // 3. 스프링 시큐리티를 테스트하기 위한 의존성 추가
   testImplementation("org.springframework.security:spring-security-test")
   testAnnotationProcessor("org.projectlombok:lombok")
   testImplementation("org.projectlombok:lombok")
   implementation("io.jsonwebtoken:jjwt:0.9.1") //자바 JWT 라이브러리
   implementation("javax.xml.bind:jaxb-api:2.3.1") // XML 문서와 Java 객체 간 매핑을 자동화
   // OAuth2를 사용하기 위한 스타터 추가
   implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
}

tasks.test {
    useJUnitPlatform()
}