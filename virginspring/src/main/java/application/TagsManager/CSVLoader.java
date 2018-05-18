package application.EventsManager;
import jdk.internal.util.xml.impl.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class CSVLoader {
    @Autowired
    ResourceLoader resourceLoader;

    public CSVLoader() {

    }

    public String load(InputStream inputStream) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        String s = "what";
        try(BufferedReader br = new BufferedReader(inputStreamReader)){
            br.readLine();
            br.readLine();
            s = br.readLine();
        } catch (IOException E){

        }
        return s;
    }

    public void main(String[] args) throws IOException {

    }

}
