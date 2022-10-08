package co.istad.bms.dashboard.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    
    @GetMapping("/dashboard")
    String requestMainView() {
        return "dashboard/main";
    }

}
