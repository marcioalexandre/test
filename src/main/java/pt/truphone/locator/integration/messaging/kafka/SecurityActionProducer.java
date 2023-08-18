package pt.truphone.locator.integration.messaging.kafka;

import io.smallrye.reactive.messaging.kafka.Record;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;
import pt.truphone.locator.entity.SecurityAction;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class SecurityActionProducer {

    @Inject
    @Channel("spain-security-action-out")
    Emitter<Record<UUID, SecurityAction>> spainEmitter;

    @Inject
    @Channel("portugal-security-action-out")
    Emitter<Record<UUID, SecurityAction>> portugalEmitter;

    private static final Logger LOG = Logger.getLogger(SecurityActionProducer.class);

    public void send(final List<SecurityAction> actions){
        LOG.info("Sending action to Kafka topic: ");
        actions.forEach(this::sendToRightTopic);
    }

    private void sendToRightTopic(SecurityAction action){
        try {
            switch (action.getFogRegion()){
                case "spain" -> {
                    LOG.info("[spain-security-action]: " + action.toString());
                    spainEmitter.send(Record.of(UUID.randomUUID(), action)).toCompletableFuture().join();
                }
                case "portugal" -> {
                    LOG.info("[portugal-security-action]: " + action.toString());
                    portugalEmitter.send(Record.of(UUID.randomUUID(), action)).toCompletableFuture().join();
                }
                default -> {
                    LOG.info("There is no Fog region to send: " + action.toString());
                }
            }
        }catch (Exception e){
            LOG.error(e.getMessage());
        }
    }
}
