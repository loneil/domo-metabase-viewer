package ca.bc.gov.metabaseviewer.controllers;

import ca.bc.gov.metabaseviewer.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class DashboardController {
    Logger logger = LoggerFactory.getLogger(DashboardController.class);

    @Autowired
    UserService userService;

    @GetMapping(path = "/dashboard")
    public String getDashboardHome(Principal principal, Model model) {
        logger.info("/dashboard");
        model.addAttribute("principal", principal);
        return "welcome";
    }

    @GetMapping(path = "/dashboard/{metabaseId}")
    public String getDashboard(@PathVariable(name = "metabaseId") Integer metabaseId, Principal principal, Model model) {
        logger.info("/dashboard/{}", metabaseId);

        try {
            model.addAttribute("principal", principal);
            model.addAttribute("iframeUrl", userService.getDashboard(metabaseId));
        } catch (Exception ex) {
            logger.error("/dashboard error occurred. Ex: {}", ex.toString());
            model.addAttribute("error", "An error occurred while attempting to fetch the dashboard.");
        }
        return "dashboard";
    }
}