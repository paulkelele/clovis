package root.http;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {
    private HttpServer httpServer;
    private Server(int port, String[] context) throws IOException {
        httpServer = HttpServer.create(new InetSocketAddress(port),0);
         for (int i = 0; i < context.length; i++) {
            httpServer.createContext("/"+(context[i].equals("index")?"":context[i]),new CustomContext(context[i]));
        }
        start();
    }

    private void start(){
        httpServer.start();
    }
    public static Server createServer(int port, String[] context) throws IOException {
        Server server = new Server(port, context);
        return server;
    }

    public void stopServer(int delay){
        httpServer.stop(delay);
    }

    public void reStart(int delay){
        stopServer(delay);
        start();
    }
}
