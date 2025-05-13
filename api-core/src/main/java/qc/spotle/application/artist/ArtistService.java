package qc.spotle.application.artist;

import jakarta.inject.Inject;
import qc.spotle.domain.artist.ArtistRepository;

public class ArtistService {
    private final ArtistRepository repo;

    @Inject
    public ArtistService(ArtistRepository repo) { this.repo = repo; }
}
