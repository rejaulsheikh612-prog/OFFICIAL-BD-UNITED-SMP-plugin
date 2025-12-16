package bdunited.plugin;

import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.nio.file.Files;

public class WebServer {

    private final ComplaintManager manager;

    public WebServer(ComplaintManager manager) {
        this.manager = manager;
    }

    public void start() {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

            server.createContext("/complaints", exchange -> {
                byte[] data = Files.readAllBytes(manager.getFile().toPath());
                exchange.sendResponseHeaders(200, data.length);
                exchange.getResponseBody().write(data);
                exchange.close();
            });

            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
                  }
