package application.controllers.admin;

import application.ProblemsResolver.Matrix;
import application.ProblemsResolver.TreeController;
import application.TagsManager.CSVLoader;
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
import java.util.List;

import java.io.IOException;
import java.io.InputStream;


@Controller
public class MakeReservationController {

    @Autowired
    private ResourceLoader resourceLoader;

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
