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

    public String getDashboard() {
        try {
            final String METABASE_SITE_URL = environment.getProperty("metabasesiteurl");
            logger.debug("getDashboard > getting dashboards from {}", METABASE_SITE_URL);
            final String METABASE_SECRET_KEY = environment.getProperty("metabasesecretkey");
            Jwt token = JwtHelper.encode("{\"resource\": {\"dashboard\": 2}, \"params\": {}}", new MacSigner(METABASE_SECRET_KEY));
            String iframeUrl = METABASE_SITE_URL + "/embed/dashboard/" + token.getEncoded() + "#bordered=true&titled=true";
            return iframeUrl;
        } catch (Exception exception) {
            logger.error("getDashboard > failed to create iFrameUrl. Exception: {}", exception.toString());
            throw exception;
        }
    }
}