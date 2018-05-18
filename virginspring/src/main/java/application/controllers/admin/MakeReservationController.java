package application.controllers.admin;

import application.ProblemsResolver.Matrix;
import application.ProblemsResolver.TreeController;
import application.TagsManager.CSVLoader;
import application.TagsManager.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;


@Controller
public class MakeReservationController {

    @Autowired
    private ResourceLoader resourceLoader;

    @RequestMapping(value = "/admin/generarevento", method = RequestMethod.GET)
    public ModelAndView generarEvento(ModelAndView mv){
        mv.setViewName("/admin/nuevareservacion");
        ArrayList<Double> results = new ArrayList<Double>();
        //Cree un evento aleatorio.
        int x = 0;
        Event eventInstance = new Event();
        Random rand = new Random();
        for (int i = 0; i < 11; i++){
            switch (i){
                case 0:
                    x = rand.nextInt(3);
                    switch (x){
                        case 1:
                            eventInstance.setWorkingProcess("Inventory Management");
                            break;
                        case 2:
                            eventInstance.setWorkingProcess("On Time Delivery");
                            break;
                        case 3:
                            eventInstance.setWorkingProcess("Production Management");
                            break;
                    }
                    break;
                case 1:
                    x = rand.nextInt(5);
                    switch (){

                    }
                case 2:
                    x = rand.nextInt(5);
                    switch (x){
                        case 1:
                            eventInstance.setSource("ARGENTINA");
                            break;
                        case 2:
                            eventInstance.setSource("BRAZIL");
                            break;
                        case 3:
                            eventInstance.setSource("GUATEMALA");
                            break;
                        case 4:
                            eventInstance.setSource("NICARAGUA");
                            break;
                        case 5:
                            eventInstance.setSource("COSTA RICA");
                            break;
                    }
/*@ATTRIBUTE source {ARGENTINA,BRAZIL,COSTA RICA,GUATEMALA,NICARAGUA}*/

                case 3:/*@ATTRIBUTE destination {ARGENTINA,BRAZIL,COSTA RICA,GUATEMALA,NICARAGUA}*/
                    x = rand.nextInt(5);
                    switch (x){
                        case 1:
                            eventInstance.setDestination("ARGENTINA");
                            break;
                        case 2:
                            eventInstance.setDestination("BRAZIL");
                            break;
                        case 3:
                            eventInstance.setDestination("GUATEMALA");
                            break;
                        case 4:
                            eventInstance.setDestination("NICARAGUA");
                            break;
                        case 5:
                            eventInstance.setDestination("COSTA RICA");
                            break;
                    }
                case 4:/*@ATTRIBUTE unit {%,MSU,d}*/
                    x = rand.nextInt(3);
                    switch (x){
                        case 1:
                            eventInstance.setType("d");
                            break;
                        case 2:
                            eventInstance.setType("%");
                            break;
                        case 3:
                            eventInstance.setType("MSU");
                            break;
                case 5:/*@ATTRIBUTE action {0,98,120,500,5000,5200}*/
                    x = rand.nextInt(6);
                case 6:/*@ATTRIBUTE owner {"Jose Salazar; Cristian Matamoros;","Laura Camacho; Cristian Matamoros;","Laura Camacho; Hidalgo David; Carlos Lara;","Laura Camacho; Hidalgo David;"}*/
                    x = rand.nextInt(4);
                case 7:/*@ATTRIBUTE escalation {N.A.}*/
                    x = rand.nextInt(1);
                case 8:/*@ATTRIBUTE 10-May {1,5,11,46.96,77.53,78.1,85.76,87.01,90.59,90.83,100,174.25,176.45,183,4000,4786,5100} */
                    x = rand.nextInt(17);
                    switch (x)
                    {
                        case 1:
                            results.add(1.0);
                            eventInstance.setResults(results);
                            break;
                        case 2:
                            results.add(5.0);
                            eventInstance.setResults(results);
                            break;
                        case 3:
                            results.add(11.0);
                            eventInstance.setResults(results);
                            break;
                        case 4:
                            results.add(46.96);
                            eventInstance.setResults(results);
                            break;
                        case 5:
                            results.add(77.53);
                            eventInstance.setResults(results);
                            break;
                        case 6:
                            results.add(78.1);
                            eventInstance.setResults(results);
                            break;
                        case 7:
                            results.add(87.01);
                            eventInstance.setResults(results);
                            break;
                        case 8:
                            results.add(90.59);
                            eventInstance.setResults(results);
                            break;
                        case 9:
                            results.add(90.83);
                            eventInstance.setResults(results);
                            break;
                        case 10:
                            results.add(100.0);
                            eventInstance.setResults(results);
                            break;
                        case 11:
                            results.add(174.25);
                            eventInstance.setResults(results);
                            break;
                        case 12:
                            results.add(176.45);
                            eventInstance.setResults(results);
                            break;
                        case 13:
                            results.add(183.0);
                            eventInstance.setResults(results);
                            break;
                        case 14:
                            results.add(4000.0);
                            eventInstance.setResults(results);
                            break;
                        case 15:
                            results.add(4786.0);
                            eventInstance.setResults(results);
                            break;
                        case 16:
                            results.add(5100.0);
                            eventInstance.setResults(results);
                            break;
                    }
                case 9:/*@ATTRIBUTE 10-May {1,5,11,46.96,77.53,78.1,85.76,87.01,90.59,90.83,100,174.25,176.45,183,4000,4786,5100}*/
                    x = rand.nextInt(17);
                    switch (x)
                    {
                        case 1:
                            eventInstance.getResults().add(1.0);
                            break;
                        case 2:
                            eventInstance.getResults().add(5.0);
                            break;
                        case 3:
                            eventInstance.getResults().add(11.0);
                            break;
                        case 4:
                            eventInstance.getResults().add(46.96);
                            break;
                        case 5:
                            eventInstance.getResults().add(77.3);
                            break;
                        case 6:
                            eventInstance.getResults().add(78.1);
                            break;
                        case 7:
                            eventInstance.getResults().add(85.76);
                            break;
                        case 8:
                            eventInstance.getResults().add(87.01);
                            break;
                        case 9:
                            eventInstance.getResults().add(90.59);
                            break;
                        case 10:
                            eventInstance.getResults().add(100);
                            break;
                        case 11:
                            eventInstance.getResults().add(174.25);
                            break;
                        case 12:
                            eventInstance.getResults().add(176.45);
                            break;
                        case 13:
                            eventInstance.getResults().add(183.0);
                            break;
                        case 14:
                            eventInstance.getResults().add(4000.0);
                            break;
                        case 15:
                            eventInstance.getResults().add(4786);
                            break;
                        case 16:
                            eventInstance.getResults().add(5100.0);
                            break;
                    }
            }
        }
        //Lo evalue en el arbol de decision

        //Con base en el resultado decidir si se envia a meeting o si se toma una decision

        //Si SI se pasa al meeting al grafo
            //+ se notifica
            //+ Se Envia a las colas de los usuarios
            //+ Se notifica
        //Si NO -> se notifica


        return mv;
    }

    @RequestMapping(value = "/admin/nuevareservacion", method = RequestMethod.GET)
    public ModelAndView getMakeReservation(ModelAndView mv){
        mv.setViewName("/admin/nuevareservacion");
        return mv;
    }
/*
    @RequestMapping("/")
    @ResponseBody
    String getMainPage() {
        String r = "";
        try(
        InputStream inputStream = resourceLoader.getResource("url:http://localhost:8080/Datasets/Events.csv").getInputStream())
        {
            CSVLoader loader = new CSVLoader();
            r = loader.load(inputStream);
        }
        catch (IOException e){

        }
        return r;
    }*/
    @RequestMapping("/notificaciones")
    @ResponseBody
    String getMainPage(){
        Matrix dataset = new Matrix();

        try {
            InputStream res = resourceLoader.getResource("url:http://localhost:8080/dataset.arff").getInputStream();
            dataset.loadArff(res);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        TreeController tree = new TreeController(dataset);

        String salida = "";

        return tree.getQuestionAndOptions().toString();
    }

    @RequestMapping(value = "/")
    public String listReservations(@RequestParam(value = "initDate", required = false) String initDate,
                                   @RequestParam(value = "endDate", required = false) String endDate,
                                   @RequestParam(value = "partner", required = false) String partnerId,
                                   @RequestParam(value = "flight", required = false) String flight,
                                   @RequestParam(value = "status", required = false) String reservationStatus,
                                   @RequestParam(value = "reservationName", required = false) String reservationName,
                                   @RequestParam(value = "p", required = false) Integer pageNumber,
                                   @RequestParam(value = "limit", required = false) Integer pageCount,
                                   @RequestParam(value = "orderBy", required = false) String orderBy,
                                   @RequestParam(value = "orderType", required = false) Integer orderType,
                                   Model model) {

        Matrix dataset = new Matrix();

        try {
            InputStream res = resourceLoader.getResource("url:http://localhost:8080/Datasets/Events1.arff").getInputStream();
            dataset.loadArff(res);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        TreeController tree = new TreeController(dataset);

        String salida = "";

        System.out.println(tree.getQuestionAndOptions().toString());

        tree.printTree();

        // Local variables
        /*try {
            if(partnerId != null) {
                partnerId = java.net.URLDecoder.decode(partnerId, "UTF-8");
            }
            if(flight != null) {
                flight = java.net.URLDecoder.decode(flight, "UTF-8");
            }
            if(reservationName != null) {
                reservationName = java.net.URLDecoder.decode(reservationName, "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long millis=System.currentTimeMillis();
        java.sql.Date dat= new java.sql.Date(millis);
        String currentDate = dat.toString();
        String initDateSearched = "";
        String endDateSearched = "";
        int offset = 0;
        int count = 0;
        int limit = 0;
        int maxPages = 0;
        Integer partnerIdNum = null;
        Integer reservationState = null;
        String flightSearched = null;
        String orderTypeString = null;
        String nameSearched = null;

        // Set up
        // If any of the parameters is null, then we won't be using it to filter our query

        // First, we need to check the type of status that we got
        // We can have any of the following type "Pendiente", "Confirmada", "Cancelada" and "Todos"
        if(reservationStatus != null) {
            switch (reservationStatus) {
                case "Pendiente":
                    reservationState = 0;
                    break;
                case "Recibida":
                    reservationState = 1;
                    break;
                case "No recibida":
                    reservationState = 2;
                    break;
                default:
                    reservationState = null;
                    break;
            }
        }
        if(partnerId != null && partnerId != "") partnerIdNum = Integer.parseInt(partnerId.substring(0,partnerId.indexOf(":")));

        if(reservationName != null && reservationName != "") nameSearched = reservationName;

        // Should the pageCount parameter be null, then we will use our default row number
        count = pageCount != null ? pageCount : DEFAULT_ROW_NUMBER;
        if(pageNumber != null) {
            offset = (pageNumber-1)*count;
        }
        limit = offset+count;
        if(flight != "" && flight != null) flightSearched = flight;

        // Check the type of order by we will be using
        if(orderBy != null && orderType != null) {
            switch (orderType) {
                case 1:
                    orderTypeString = "DESC";
                    break;
                case 2:
                    orderTypeString = "ASC";
                    break;
                default:
                    orderTypeString = null;
            }
        }

        // Use current date if either date parameter is null, that way the query won't cause any trouble
        initDateSearched = initDate == null || initDate == "" ? currentDate : initDate;
        endDateSearched = endDate == null || endDate == "" ? currentDate : endDate;

        //Page calculation
        int countResults = reservationService.countReservations(initDateSearched,endDateSearched, partnerIdNum,flightSearched, nameSearched, reservationState);
        int sumPassengers = reservationService.countPassengers(initDateSearched,endDateSearched, partnerIdNum,flightSearched, nameSearched, reservationState);
        maxPages = ((countResults-1)/count)+1;*/

        // Data retrieval
        //model.addAttribute("reservations", reservationService.getReservations(initDateSearched, endDateSearched, partnerIdNum, flightSearched, nameSearched, reservationState, offset, limit, orderBy, orderTypeString ));

        return "admin/reservations";
    }
}
