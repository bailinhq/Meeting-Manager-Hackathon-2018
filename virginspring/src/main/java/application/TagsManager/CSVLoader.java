package application.TagsManager;
import application.TagsManager.Event;
import jdk.internal.util.xml.impl.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CSVLoader {
    @Autowired
    ResourceLoader resourceLoader;
    private Event e;
    private HashMap<Integer, Event> events;
    public CSVLoader() {
        events = new HashMap<Integer, Event>();
    }

    public HashMap<Integer, Event> getEvents() {
        return events;
    }

    public void setEvents(HashMap<Integer, Event> events) {
        this.events = events;
    }

    public void load(InputStream inputStream) {
        String s = "";
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        try(BufferedReader br = new BufferedReader(inputStreamReader)){
            while ((s = br.readLine()) != null) {
                s += br.readLine();
                String[] attributes = s.split(",");
                int numberE = Integer.parseInt(attributes[0]);
                String workingProcess = attributes[1];
                String processMeasure = attributes[2];
                String source = attributes[3];
                String destination = attributes[4];
                String type = attributes[5];
                int action = Integer.parseInt(attributes[6]);
                ArrayList<String> owners = new ArrayList<String>();
                String temp = attributes[7];
                temp = temp.substring(1,temp.length()-1);
                String[] owner = temp.split(";");
                for (int i = 0; i < owner.length; i++){
                    owners.add(owner[i]);
                }
                String escalation = attributes[8];
                ArrayList<Double> results = new ArrayList<Double>();
                results.add(Double.parseDouble(attributes[9]));
                results.add(Double.parseDouble(attributes[10]));
                results.add(Double.parseDouble(attributes[11]));
                e = new Event(numberE,workingProcess,processMeasure,source,destination,type,action,owners,
                        escalation,results, 0);
                e.setPriority(this.getPrioridad(e));
                events.put(numberE, e);

            }
        } catch (IOException E){

        }
    }

    private int getPrioridad(Event event){
        double porcentaje =  event.getResults().get(0) / (double) event.getAction();
        if (porcentaje >= 1){
            return 0;
        }
        double i = 0.0;
        int prioridad = 0;
        while (porcentaje >= i){
            i += 10.0;
            prioridad++;
        }
        return prioridad;
    }
    public void main(String[] args)  {
    }

}
