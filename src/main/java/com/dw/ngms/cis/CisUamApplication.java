package com.dw.ngms.cis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@ServletComponentScan
@SpringBootApplication
@EnableJpaAuditing
public class CisUamApplication extends SpringBootServletInitializer {


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CisUamApplication.class);
    }


    public static void main(String[] args) {
        SpringApplication.run(CisUamApplication.class, args);
    }


}
