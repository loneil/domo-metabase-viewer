package ca.bc.gov.metabaseviewer.controllers;

import ca.bc.gov.metabaseviewer.model.ContactForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class UserController extends BaseLoggedInController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping(path = "/sec/user")
    public String getUser(Principal principal, Model model) {
        addCommonUserAttributes(model);
        model.addAttribute("userDetails", userService.getUserDetails(principal));

        return "user";
    }

    @GetMapping(path = "/sec/about")
    public String getAbout(Principal principal, Model model) {
        addCommonUserAttributes(model);

        return "about";
    }

    @GetMapping(path = "/sec/contact")
    public String getContact(Principal principal, Model model) {
        addCommonUserAttributes(model);
        model.addAttribute("userDetails", userService.getUserDetails(principal));
        model.addAttribute("contactForm", new ContactForm());

        return "contact";
    }
    @PostMapping("/sec/contact")
    public String contactSubmit(@ModelAttribute ContactForm contactForm, Model model) {
        addCommonUserAttributes(model);
        return "contactFailure";
    }
}