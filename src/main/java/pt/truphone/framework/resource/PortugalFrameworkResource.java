package pt.truphone.framework.resource;

import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.jboss.resteasy.reactive.RestStreamElementType;
import java.util.concurrent.Flow.Publisher;

@ApplicationScoped
@Path("portugal")
public class PortugalFrameworkResource {

    private Integer frameworkId = 1;

    @Inject
    @Channel("portugal-security-action-in")
    Publisher<String> portugalMessage;

    @GET
    @RestStreamElementType(MediaType.TEXT_PLAIN)
    public Publisher<String> portugalMessages(){
        return Multi.createFrom().publisher(portugalMessage);
    }


}
