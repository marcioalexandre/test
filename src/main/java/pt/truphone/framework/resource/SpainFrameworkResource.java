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
@Path("spain")
public class SpainFrameworkResource {

    @Inject
    @Channel("spain-security-action-in")
    Publisher<String> spainMessage;

    @GET
    @RestStreamElementType(MediaType.TEXT_PLAIN)
    public Publisher<String> spainMessages(){
        return Multi.createFrom().publisher(spainMessage);
    }
}
