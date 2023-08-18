package pt.truphone.locator.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;
import pt.truphone.locator.entity.Fog;

@ApplicationScoped
public class FogService {

    private static final Logger LOG = Logger.getLogger(FogService.class);

    public Fog getFogById(Long id){
        LOG.info("getting fog by id: " + id);
        return Fog.findById(id);
    }
}
