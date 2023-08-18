package pt.truphone.locator.resource;

import com.google.gson.Gson;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;
import pt.truphone.locator.entity.SecurityAction;
import pt.truphone.locator.integration.messaging.kafka.SecurityActionProducer;
import pt.truphone.locator.service.SecurityActionService;
import pt.truphone.reputation.domain.UntrustedDevice;

import java.util.List;

@ApplicationScoped
public class DeviceResource {

    @Inject
    SecurityActionService securityActionService;
    @Inject
    SecurityActionProducer securityActionProducer;

    private static final Logger LOG = Logger.getLogger(DeviceResource.class);

    @Transactional
    @Incoming("untrusted-devices-in")
    public void message(String message){
        try {
            LOG.info("getting message from kafka topic [untrusted-devices]: " + message);
            Gson gson = new Gson();
            UntrustedDevice untrustedDevice = gson.fromJson(message, UntrustedDevice.class);
            List<SecurityAction> securityActions = securityActionService
                    .buildSecurityActions(untrustedDevice.getIdModel(), untrustedDevice.getScore());
            securityActionProducer.send(securityActions);
        }catch (Exception e){
            LOG.error(e.getMessage());
        }
    }
}
