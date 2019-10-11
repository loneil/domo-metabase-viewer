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

import java.security.Principal;
import java.util.Set;

@Controller
public class UserController extends BaseLoggedInController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping(path = "/sec/user")
    public String getUser(Principal principal, Model model) {
        addCommonUserAttributes(principal, model);
        model.addAttribute("userDetails", userService.getUserDetails(principal));

        return "user";
    }
}