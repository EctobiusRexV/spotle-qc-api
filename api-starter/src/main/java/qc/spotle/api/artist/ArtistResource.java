package qc.spotle.api.artist;

import qc.spotle.shared.dto.input.ArtistInputDTO;
import qc.spotle.application.artist.ArtistService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/artist")
public class ArtistResource {

    private final ArtistService artistService;

    @Inject
  public ArtistResource(ArtistService artistService) {
      this.artistService = artistService;
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response addArtist(ArtistInputDTO artist) {
    return Response.ok().entity(artist).build();
  }

  @GET
  @Path("/name/{artistName}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getArtist(@PathParam("artistName") String artistName) {
    return Response.ok().entity(artistName).build();
  }

  @GET
  @Path("/{artistId:[0-9a-fA-F\\-]+}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getArtistById(@PathParam("artistId") String artistID) {
      return Response.ok().entity(artistID).build();
  }

  @PUT
  @Path("/{artistId:[0-9a-fA-F\\-]+}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response updateArtist(@PathParam("artistId") String artistID, ArtistInputDTO artist) {
      return Response.ok().entity(artistID).build();
  }
}
