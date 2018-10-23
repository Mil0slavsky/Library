package main.java.com.lib;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Component
class Library {

    @Autowired
    private LibraryBean libraryBean;

    void put(String k, String v) throws IOException {
        HashMap<String, String> cache = libraryBean.fileUpload();
        File file = new File(libraryBean.path);
        if (file.exists() && file.length() != 0) check(cache);
        else checked = true;
        if ((k.length() == 5 && k.matches("^[0-9]+$") && checked)
                || ((k.length() == 4) && (k.matches("^[a-zA-Z]+$")) && checked))
            cache.put(k, v);
        else {
            System.out.println("Wrong record or incorrect dictionary. ");
            System.out.println("---------------------------------------------------------------------------");
        }
        libraryBean.fileUnloaded(cache);
    }

    void getAll() throws IOException {
        HashMap<String, String> cache = libraryBean.fileUpload();
        System.out.println("Dictionary: ");
        int i = 1;
        for (Map.Entry entry : cache.entrySet()) {
            System.out.println(i + ". " + entry.getKey() + " -- " + entry.getValue());
            i++;
        }
        System.out.println("---------------------------------------------------------------------------");
    }

    void get(String key) throws IOException {
        HashMap<String, String> cache = libraryBean.fileUpload();
        boolean boo = false;
        for (Map.Entry entry : cache.entrySet()) {
            if (entry.getKey().equals(key)) {
                System.out.println("Pair found: " + entry.getKey() + " -- " + entry.getValue());
                System.out.println("---------------------------------------------------------------------------");
                boo = true;
            }
        }
        if (!boo) {
            System.out.println("Record not found or check the library is correct. ");
            System.out.println("---------------------------------------------------------------------------");
        }

    }

    void delete(String key) throws IOException {
        HashMap<String, String> cache = libraryBean.fileUpload();
        boolean boo = false;
        for (Map.Entry entry : cache.entrySet()) {
            if (entry.getKey().equals(key)) {
                cache.remove(key);
                System.out.println("Record " + entry.getKey() + " : " + entry.getValue() + " deleted. ");
                System.out.println("---------------------------------------------------------------------------");
                boo = true;
                break;
            }
        }
        if (!boo) System.out.println("Record not found or check the library is correct. ");
        System.out.println("---------------------------------------------------------------------------");
        libraryBean.fileUnloaded(cache);
    }

    private boolean checked = false;

    private void check(HashMap<String, String> cache) throws IOException {
        cache = libraryBean.fileUpload();
        for (Map.Entry entry : cache.entrySet()) {
            if ((entry.getKey().toString().length() == 5 && entry.getKey().toString().matches("^[0-9]+$"))
                    || ((entry.getKey().toString().length() == 4) && (entry.getKey().toString().matches("^[a-zA-Z]+$")))) {
                checked = true;
            } else break;
        }
    }
}


