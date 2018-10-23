package main.java.com.lib;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    LibraryBean libraryBean() {
        return new LibraryBean();
    }

    @Bean
    Library library() {
        return new Library();
    }
}
