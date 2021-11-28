package com.catchb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.IOException;

@SpringBootApplication(scanBasePackages = "com.catchb")
public class Application1  extends SpringBootServletInitializer {

    public static void main(String[] args) throws IOException{
        SpringApplication.run(Application1.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(Application1.class);
    }
}
