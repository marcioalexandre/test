package pt.truphone.locator.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;
import pt.truphone.locator.entity.TruphoneConfiguration;

@ApplicationScoped
public class TruphoneConfigurationService {

    private static final Logger LOG = Logger.getLogger(TruphoneConfigurationService.class);

    public TruphoneConfiguration getConfigurationByScore(final Integer score){
        LOG.info("getting configuration by score: " + score);
        return TruphoneConfiguration.find("score = ?1", score).firstResult();
    }
}
