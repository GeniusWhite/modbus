package lv.modbusProject.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import java.time.LocalDate;

@Controller
public class Controller1 {


    @GetMapping("/")
    public String login1() {


        LocalDate localDate = LocalDate.now();

        System.out.println("hello-LoginController");
        System.out.println(localDate.toString());


        return "home";
    }

}
