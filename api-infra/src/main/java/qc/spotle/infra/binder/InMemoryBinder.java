package qc.spotle.infra.binder;

import jakarta.inject.Singleton;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import qc.spotle.application.artist.ArtistService;
import qc.spotle.application.user.UserService;
import qc.spotle.domain.artist.ArtistRepository;
import qc.spotle.domain.user.UserRepository;
import qc.spotle.infra.memory.InMemoryArtistRepository;
import qc.spotle.infra.memory.InMemoryUserRepository;

public final class InMemoryBinder extends AbstractBinder {
    @Override
    protected void configure() {

        /* repositories */
        bind(InMemoryArtistRepository.class)
                .to(ArtistRepository.class)
                .in(Singleton.class);

        bind(InMemoryUserRepository.class)
                .to(UserRepository.class)
                .in(Singleton.class);

        /* service layer */
        bind(ArtistService.class)
                .to(ArtistService.class)
                .in(Singleton.class);

        bind(UserService.class)
                .to(UserService.class)
                .in(Singleton.class);
    }
}
