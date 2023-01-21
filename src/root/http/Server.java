package root.http;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {
    private HttpServer httpServer;
    private int port;
    private String[] context;
    private Server(int port, String[] context) throws IOException {
        this.port = port;
        this.context = context;
       init(port,context);
        start();
    }

    // init server
    private void init(int port, String[] context) throws IOException {
        httpServer = HttpServer.create(new InetSocketAddress(port),0);
//        for (int i = 0; i < context.length; i++) {
//            httpServer.createContext("/"+(context[i].equals("index")?"":context[i]),new CustomContext(context[i]));
//        }
        httpServer.createContext("/",new CustomContext());
        httpServer.setExecutor(null);
    }
    private void start(){
        httpServer.start();
        System.out.println("Server start at: "+this.port);
    }
    public static Server createServer(int port, String[] context) throws IOException {
        Server server = new Server(port, context);
        return server;
    }

    public void stopServer(int delay){
        httpServer.stop(delay);
        System.out.println("Server stop.");
    }

    public void reStart(int delay) throws IOException {
        stopServer(delay);
        init(this.port,this.context);
        start();
    }
}
