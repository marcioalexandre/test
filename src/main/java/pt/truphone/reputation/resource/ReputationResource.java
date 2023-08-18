package pt.truphone.reputation.resource;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import pt.truphone.reputation.domain.UntrustedDevice;
import pt.truphone.reputation.integration.messaging.kafka.ReputationProducer;

@ApplicationScoped
@Path("/reputation")
public class ReputationResource {

    @Inject
    ReputationProducer producer;

    @POST
    public Response sendUntrustedDevice(UntrustedDevice untrustedDeviceList) {
        producer.sendKafkaData(untrustedDeviceList);
        return Response.ok("Message has been sent to Kafka successfully").build();
    }

}
