package root.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

public class CustomContext implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String requestMethod = exchange.getRequestMethod();
        String query = exchange.getRequestURI().toASCIIString() ;
        File index  ;
        try {
            index = new File(getClass().getResource("/resources/html/index.html").toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        FileInputStream fileInputStream = new FileInputStream(index);
        exchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
        byte[] r = fileInputStream.readAllBytes();
        exchange.sendResponseHeaders(200, r.length );
        OutputStream os = exchange.getResponseBody();
        os.write(r);
        os.close();
    }
}
