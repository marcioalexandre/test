package pt.truphone.reputation.integration.messaging.kafka;

import io.smallrye.reactive.messaging.kafka.Record;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;
import pt.truphone.reputation.domain.UntrustedDevice;

import java.util.UUID;

@ApplicationScoped
public class ReputationProducer {

    @Inject @Channel("untrusted-devices-out")
    Emitter<Record<UUID, UntrustedDevice>> emitter;

    private static final Logger LOG = Logger.getLogger(ReputationProducer.class);

    public void sendKafkaData(final UntrustedDevice untrustedDevice){
        LOG.info("Send Kafka Data: " + untrustedDevice.toString());
        try {
            emitter.send(Record.of(UUID.randomUUID(), untrustedDevice)).toCompletableFuture().join();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
