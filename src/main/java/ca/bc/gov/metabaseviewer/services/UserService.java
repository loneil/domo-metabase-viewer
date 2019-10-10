package ca.bc.gov.metabaseviewer.services;

import ca.bc.gov.metabaseviewer.model.Dashboard;
import ca.bc.gov.metabaseviewer.model.UserDetails;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.IDToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private Environment environment;

//    public List<String> getAvailableDashboards(Principal user) {
////
////    };

    public String getDashboard(int metabaseId) {
        try {
            final String METABASE_SITE_URL = environment.getProperty("METABASE_URL");
            final String METABASE_SECRET_KEY = environment.getProperty("metabasesecretkey");
            logger.debug("getDashboard > getting dashboard no{} from {}", metabaseId, METABASE_SITE_URL);

            Jwt token = JwtHelper.encode(dashJson(metabaseId), new MacSigner(METABASE_SECRET_KEY));
            String iframeUrl = METABASE_SITE_URL + "/embed/dashboard/" + token.getEncoded() + "#bordered=true&titled=true";
            return iframeUrl;
        } catch (Exception exception) {
            logger.error("getDashboard > failed to create iFrameUrl for dashboard no{}. Exception: {}", metabaseId, exception.toString());
            throw exception;
        }
    }

    /**
     * @param dashId the id corresponding to the metabase embed
     * @return the json string to pass to the iframe to call metabase
     */
    public static String dashJson(int dashId) {
        String jsonTemplate = "{\"resource\": {\"dashboard\": %d}, \"params\": {}}";
        return String.format(jsonTemplate, dashId);
    }

    public UserDetails getUserDetails(Principal principal) {
        if (principal == null) {
            throw new IllegalArgumentException("Supplied principal is null");
        }

        UserDetails user = new UserDetails();

        KeycloakAuthenticationToken kcPrincipal = (KeycloakAuthenticationToken) principal;
        IDToken token = kcPrincipal.getAccount().getKeycloakSecurityContext().getIdToken();
        if (token != null) {
            user.setName(token.getName());
            user.setEmail(token.getEmail());
            user.setUserId(token.getPreferredUsername());
        } else {
            throw new IllegalArgumentException("Id Token from supplied principal is null");
        }

        return user;
    }

    public List<Dashboard> getAvailableDashboards() {
        // TODO: This needs to pull from some static config or json or something instead of coded in this method.
        // In that, dictate which roles are allowed to see the dashboard, or have some other static/config mapping roles to dashboards
        // Could be in a configmap in OS, but maybe not worth the effor if it doesn't change frequently enough.
        Dashboard expenseDash = new Dashboard("Hosting Expense Report", 2);
        Dashboard sampleDash = new Dashboard("Sample Dashboard", 5);
        Dashboard anotherSampleDash = new Dashboard("Additional Sample Dashboard", 6);
        List<Dashboard> list = new ArrayList<Dashboard>();
        list.add(expenseDash);
        list.add(sampleDash);
        list.add(anotherSampleDash);
        return list;
    }
}