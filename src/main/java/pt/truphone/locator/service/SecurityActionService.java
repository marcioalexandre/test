package pt.truphone.locator.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;
import pt.truphone.locator.entity.Device;
import pt.truphone.locator.entity.SecurityAction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class SecurityActionService {

    @Inject
    DeviceService deviceService;
    @Inject
    FogService fogService;
    @Inject
    TruphoneConfigurationService configurationService;

    private static final Logger LOG = Logger.getLogger(SecurityActionService.class);

    public List<SecurityAction> buildSecurityActions(final UUID modelId, final Integer score){
        LOG.info("building security action from modelid "+ modelId +" and score "+ score);
        List<SecurityAction> securityActions = new ArrayList<>();
        List<Device> devices = deviceService.getDevicesByModelId(modelId);
        devices.forEach(device -> this.buildSecurityActionFromDevice(securityActions, device, score));
        return securityActions;
    }

    private void buildSecurityActionFromDevice(final List<SecurityAction> securityActions,
                                               final Device device,
                                               final Integer score){
        securityActions.add(
                new SecurityAction(
                        device.getFrameworkId(),
                        fogService.getFogById(device.getFogId()).getRegion(),
                        configurationService.getConfigurationByScore(score)
                ));
    }
}
