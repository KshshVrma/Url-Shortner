package url.shortner.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
@Controller
public class FormController {
    @GetMapping("/form.html")
    public String showForm() {
        return "form"; // Points to form.html in templates directory
    }
}