package application.controllers.admin;

import application.ProblemsResolver.Matrix;
import application.ProblemsResolver.TreeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.List;


@Controller
public class MakeReservationController {

    @Autowired
    private ResourceLoader resourceLoader;

    @RequestMapping(value = "/admin/nuevareservacion", method = RequestMethod.GET)
    public ModelAndView getMakeReservation(ModelAndView mv){
        mv.setViewName("/admin/nuevareservacion");
        return mv;
    }

    @RequestMapping("/")
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

}
