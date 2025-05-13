package qc.spotle.starter;

import org.glassfish.jersey.jsonb.JsonBindingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import qc.spotle.api.artist.ArtistResource;
import qc.spotle.api.health.HealthResource;
import qc.spotle.api.user.UserResource;
import qc.spotle.infra.binder.InMemoryBinder;
import qc.spotle.infra.binder.PostgresBinder;

public class JerseyStarter {
    private static final String DEFAULT_PROFILE = "memory";

    public static ResourceConfig buildConfig() {
        ResourceConfig rc = new ResourceConfig()
                .register(JsonBindingFeature.class)
                .register(HealthResource.class)
                .register(ArtistResource.class)
                .register(UserResource.class);

        String profile = System.getenv("SPOTLE_PROFILE");
        if (profile == null) {
            profile = System.getProperty("spotle.profile", DEFAULT_PROFILE);
        }

        if ("persistence".equalsIgnoreCase(profile)) {
            rc.register(new PostgresBinder());
        } else {
            rc.register(new InMemoryBinder());
        }
        return rc;
    }
}
