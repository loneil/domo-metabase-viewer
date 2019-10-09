package ca.bc.gov.metabaseviewer.controllers;

import ca.bc.gov.metabaseviewer.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class DashboardController {
    Logger logger = LoggerFactory.getLogger(DashboardController.class);

    @Autowired
    UserService userService;

    @Autowired
    private Environment environment;

    @GetMapping(path = "/dashboard")
    public String getPersons(Principal principal, Model model) {
        logger.info("/dashboard");

        try {
            model.addAttribute("principal", principal);
            model.addAttribute("iframeUrl", userService.getDashboard());
        } catch (Exception ex) {
            logger.error("/dashboard error occurred. Ex: {}", ex.toString());
            model.addAttribute("error", "An error occurred while attempting to fetch the dashboard.");
        }
        return "dashboard";
    }
}