package sia.pastebincopy.presentation;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/error")
public class ServerErrorController implements ErrorController {

    @GetMapping
    public String error() {
        return "serverError";
    }
}
