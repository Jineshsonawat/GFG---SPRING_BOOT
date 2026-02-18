package com.learning.sb.Service;

import com.learning.sb.config.GoogleDrive;
import org.springframework.stereotype.Component;

import java.io.File;

// this annotation marked this class as bean.

@Component
public class TestService {

//    We do not mark the class with @Component still using as Bean bcz we marked as @Bean.
    public GoogleDrive googleDrive;

    public TestService(GoogleDrive googleDrive) {
        this.googleDrive = googleDrive;
    }

    public void sayHello(){
        this.googleDrive.upload(new File("/About SpringBoot"));
        System.out.println("Hello World");
    }
}
