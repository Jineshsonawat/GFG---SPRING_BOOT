package com.learning.sb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GoogleDriveConfiguration {

//  Only used inside @Configuration. Make the return type of method as a Bean.
    @Bean
    public  GoogleDrive makeGoogleDrive(){
//        Some Complicated logic
        return new GoogleDrive();
    }
}
