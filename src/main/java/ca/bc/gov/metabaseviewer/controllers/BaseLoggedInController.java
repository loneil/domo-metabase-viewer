package ca.bc.gov.metabaseviewer.controllers;

import ca.bc.gov.metabaseviewer.services.UserService;
import org.keycloak.representations.AccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.Set;

@Controller
public abstract class BaseLoggedInController {

    @Autowired
    protected UserService userService;

    protected void addCommonUserAttributes(final Principal principal, final Model model) {
        model.addAttribute("principal", principal);
        model.addAttribute("dashboards", userService.getAvailableDashboards());
    }
}