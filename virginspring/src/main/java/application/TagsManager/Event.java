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
    private ArrayList<Double> results;
    private int priority;

    public Event(){}

    public Event(int numberE, String wp, String pMeasure, String src, String dest, String t,
                 int act, ArrayList<String> owner, String esc, ArrayList<Double> res, int prioridad){
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
        priority = prioridad;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
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

    public ArrayList<Double> getResults() {
        return results;
    }

    public void setResults(ArrayList<Double> results) {
        this.results = results;
    }

    public ArrayList<String> getArray(){
        ArrayList<String> result = new ArrayList<String>();

        result.add(getWorkingProcess());
        result.add(getProcessMeasure());
        result.add(getSource());
        result.add(getDestination());
        result.add(getType());
        result.add(String.valueOf(getAction()));

        //Owners
        String owners = "";
        for (int i = 0; i < getOwners().size();i++)
            owners += getOwners().get(i) + " ";
        result.add(owners);

        result.add(getEscalation());
        result.add(getResults().get(0).toString());
        result.add(getResults().get(1).toString());
        result.add(getResults().get(2).toString());
        return result;
    }
}
