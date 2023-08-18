package pt.truphone.locator.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;
import pt.truphone.locator.entity.Device;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class DeviceService {

    @Inject
    private Device device;

    private static final Logger LOG = Logger.getLogger(DeviceService.class);

    public List<Device> getDevicesByModelId(final UUID modelId){
        LOG.info("getting devices by model id: " + modelId.toString());
        return Device.list("modelId = ?1", modelId);
    }
}
