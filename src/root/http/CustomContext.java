package root.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class CustomContext implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String requestMethod = exchange.getRequestMethod();
        String query = exchange.getRequestURI().toASCIIString() ;
        String response = "<b>Bonjour !</b></br>Méthode :  </br>"+requestMethod+" query "+query ;
        byte[] r = response.getBytes(Charset.forName("ISO-8859-1"));
        exchange.sendResponseHeaders(200, r.length );
        OutputStream os = exchange.getResponseBody();
        os.write(r);
        os.close();
    }
}
