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

    @RequestMapping(value = "/admin/generarevento")
    public ModelAndView generarEvento(ModelAndView mv){

        //Lo evalue en el arbol de decision

        ArrayList<String> owners = new ArrayList<String>();
        owners.add("Jose Salazar;");
        owners.add(" Cristian Matamoros;");
        ArrayList<Double> results = new ArrayList<Double>();
        results.add(90.83);
        results.add(90.59);//results.add(77.53);
        results.add(46.96);//results.add(174.25);
        Event event = new Event(1,"On Time Delivery", "Production - BRAZIL", "ARGENTINA", "BRAZIL", "MSU",98, owners, "N.A.", results,5);

        Matrix dataset = new Matrix();

        try {
            InputStream res = resourceLoader.getResource("url:http://localhost:8080/Datasets/Events1.arff").getInputStream();
            dataset.loadArff(res);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        TreeController tree = new TreeController(dataset);


        //Con base en el resultado decidir si se envia a meeting o si se toma una decision

        //Si SI se pasa al meeting al grafo
            //+ se notifica
            //+ Se Envia a las colas de los usuarios
            //+ Se notifica
        //Si NO -> se notifica
        ArrayList<String> array = event.getArray();
        String result = array.get(0) + " " + array.get(1) + " " + array.get(2) + " " + array.get(3) + " " + array.get(4) + " " + array.get(5) + " " + array.get(6) + " " + array.get(7) + " " + array.get(8) + " " + array.get(9) + " " +  array.get(10) + " ";

        mv.setViewName("admin/reservations");
        mv.addObject("workprocess"     ,array.get(0));
        mv.addObject("inprocessmeasure",array.get(1));
        mv.addObject("source",          array.get(2));
        mv.addObject("destination",     array.get(3));
        mv.addObject("unit",            array.get(4));
        mv.addObject("action",          array.get(5));
        mv.addObject("owner",           array.get(6));
        mv.addObject("escalation",      tree.evaluateEvent(event.getArray()));
        mv.addObject("10-May",          array.get(8));
        mv.addObject("09-May",          array.get(9));
        mv.addObject("07-May",          array.get(10));
        return  mv;
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


        //TreeController tree = new TreeController(dataset);

        String salida = "";

        //System.out.println(tree.getQuestionAndOptions().toString());

        //tree.printTree();

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
        model.addAttribute("workprocess"     ,"");
        model.addAttribute("inprocessmeasure","");
        model.addAttribute("source",          "");
        model.addAttribute("destination",     "");
        model.addAttribute("unit",            "");
        model.addAttribute("action",          "");
        model.addAttribute("owner",           "");
        model.addAttribute("escalation",      "");
        model.addAttribute("10-May",          "");
        model.addAttribute("09-May",          "");
        model.addAttribute("07-May",          "");
        return "admin/reservations";
    }
}
