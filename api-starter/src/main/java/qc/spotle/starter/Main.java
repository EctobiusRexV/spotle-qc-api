package qc.spotle.starter;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

import java.net.URI;

public final class Main {

    private static final String BASE_URI = "http://0.0.0.0:8080/";

    public static void main(String[] args) {
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(
                URI.create(BASE_URI), JerseyStarter.buildConfig());

        Runtime.getRuntime().addShutdownHook(new Thread(server::shutdownNow));
        System.out.printf("Jersey app started with endpoints at %s%n", BASE_URI);
    }
}