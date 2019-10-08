package ca.bc.gov.metabaseviewer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.MacSigner;

import ca.bc.gov.metabaseviewer.services.ProductService;

import java.security.Principal;

@Controller
public class DashboardController {
   @Autowired ProductService productService;

   @Autowired
   private Environment environment;

   @GetMapping(path = "/dashboard")
   public String getPersons(Principal principal, Model model) {
      try {
         model.addAttribute("principal",principal);

         String METABASE_SITE_URL = environment.getProperty("metabasesiteurl");
         String METABASE_SECRET_KEY = environment.getProperty("metabasesecretkey");
         model.addAttribute("url", "1234");
         Jwt token = JwtHelper.encode("{\"resource\": {\"dashboard\": 2}, \"params\": {}}", new MacSigner(METABASE_SECRET_KEY));
         String iframeUrl = METABASE_SITE_URL + "/embed/dashboard/" + token.getEncoded() + "#bordered=true&titled=true";
         model.addAttribute("iframeUrl", iframeUrl);
      } catch (Exception exception){
         //Invalid Signing configuration / Couldn't convert Claims.
      }
      return "dashboard";
   }
}