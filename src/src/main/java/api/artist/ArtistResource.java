package api.artist;

import api.artist.dto.input.ArtistInputDTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/artist")
public class ArtistResource {

  public ArtistResource() {}

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response addArtist(ArtistInputDTO artist) {
    return Response.ok().entity(artist).build();
  }

  @GET
  @Path("/{artistName}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response getArtist(@PathParam("artistName") String artistName) {
    return Response.ok().entity(artistName).build();
  }
}
