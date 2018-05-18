package application.EventsManager;
import application.TagsManager.Event;
import jdk.internal.util.xml.impl.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class CSVLoader {
    @Autowired
    ResourceLoader resourceLoader;
    private Event e;
    public CSVLoader() {

    }

    public String load(InputStream inputStream) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        String s = "what";
        try(BufferedReader br = new BufferedReader(inputStreamReader)){
            s = br.readLine();
            s += br.readLine();
        } catch (IOException E){

        }
        return s;
    }

    public void main(String[] args)  {
        System.out.println("");
    }

}
