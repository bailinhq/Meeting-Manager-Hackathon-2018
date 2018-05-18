package application.controllers.admin;
import application.EventsManager.CSVLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;


@Controller
public class MakeReservationController {
    @Autowired
    private ResourceLoader resourceLoader;

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
    }
}
