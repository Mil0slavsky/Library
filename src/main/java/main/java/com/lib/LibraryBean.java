package main.java.com.lib;

import java.io.*;
import java.util.*;

class LibraryBean {
    String path;

    void setFilePath(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) file.createNewFile();
        this.path = path;
        getFilePath();
    }

    private void getFilePath() {
        System.out.println("Сurrent path: " + path);
        System.out.println("---------------------------------------------------------------------------");
    }

    HashMap<String, String> fileUpload() throws IOException {
        HashMap<String, String> cache = new HashMap<String, String>();
        BufferedReader breader = new BufferedReader(new FileReader(path));
        String line;
        while ((line = breader.readLine()) != null) {
            String pair[] = line.split(",");
            cache.put(pair[0], pair[1]);
        }
        return cache;
    }

    void fileUnloaded(HashMap<String, String> cache) throws IOException {
        BufferedWriter bwriter = new BufferedWriter(new FileWriter(path, false));
        for (Map.Entry entry : cache.entrySet()) {
            bwriter.write(entry.getKey() + "," + entry.getValue() + System.lineSeparator());
        }
        bwriter.close();
    }

}


