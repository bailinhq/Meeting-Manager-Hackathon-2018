package application.TagsManager;

import java.util.ArrayList;

public class Event {
    private int eventNumber;
    private String workingProcess;
    private String processMeasure;
    private String source;
    private String destination;
    private String type;
    private int action;
    private ArrayList<String> owners;
    private String escalation;
    private ArrayList<double> results;
    public Event(int numberE, String wp, String pMeasure, String src, String dest, String t,
                 int act, ArrayList<String> owner, String esc, ArrayList<double> res){
        eventNumber = numberE;
        workingProcess = wp;
        processMeasure = pMeasure;
        source = src;
        destination = dest;
        type = t;
        action = act;
        owners = owner;
        escalation = esc;
        results = res;
    }

    public int getEventNumber() {
        return eventNumber;
    }

    public void setEventNumber(int eventNumber) {
        this.eventNumber = eventNumber;
    }

    public String getWorkingProcess() {
        return workingProcess;
    }

    public void setWorkingProcess(String workingProcess) {
        this.workingProcess = workingProcess;
    }

    public String getProcessMeasure() {
        return processMeasure;
    }

    public void setProcessMeasure(String processMeasure) {
        this.processMeasure = processMeasure;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public ArrayList<String> getOwners() {
        return owners;
    }

    public void setOwners(ArrayList<String> owners) {
        this.owners = owners;
    }

    public String getEscalation() {
        return escalation;
    }

    public void setEscalation(String escalation) {
        this.escalation = escalation;
    }

    public ArrayList<double> getResults() {
        return results;
    }

    public void setResults(ArrayList<double> results) {
        this.results = results;
    }
}
