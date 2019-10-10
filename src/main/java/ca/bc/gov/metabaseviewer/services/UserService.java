package ca.bc.gov.metabaseviewer.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private Environment environment;

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

    public static String dashJson(int dashId) {
        String jsonTemplate = "{\"resource\": {\"dashboard\": %d}, \"params\": {}}";
        return String.format(jsonTemplate, dashId);
    }
}