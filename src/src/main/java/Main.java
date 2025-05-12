import java.net.URI;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Main {

  private static final String BASE_URI = "http://0.0.0.0:8080/";

  private static HttpServer startServer() {
    final ResourceConfig config = new ResourceConfig();

    return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), config);
  }

  public static void main(String[] args) {
    startServer();
    System.out.printf("Jersey app started with endpoints available at %s%n", BASE_URI);
  }
}
