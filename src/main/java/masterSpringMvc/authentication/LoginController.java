package masterSpringMvc.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dlok on 03/12/2015.
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String authenticate() {
        return "directory/login";
    }
}
