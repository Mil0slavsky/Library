package main.java.com.lib;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        LibraryBean libraryBean = context.getBean(LibraryBean.class);
        Library library = context.getBean(Library.class);
        libraryBean.setFilePath("C:\\Users\\dmotylev\\IdeaProjects\\LibrarySpring-master\\file.txt");
        library.get("12321");
        library.getAll();
    }
}
