package root.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URLConnection;
import java.util.Objects;

public class CustomContext implements HttpHandler {
    private  String context;
    public CustomContext(String context) {
        this.context = context;
    }

    public CustomContext() {
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod();
       // System.out.println(requestMethod);
        String query = exchange.getRequestURI().toASCIIString();
        System.out.println("query "+query);
        File index = null;
        try {
            index = new File(getClass().getResource("/resources/html/toto").toURI());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
       // System.out.println(index.listFiles());
        File[] lf = index.listFiles(pathname -> pathname.isFile() );
        for(File f : lf){
            System.out.println(f.getAbsolutePath());
        }

//        try {angu
//            index = new File(getClass().getResource("/resources/html/"+context+".html").toURI());
//        } catch (URISyntaxException e) {
//            throw new RuntimeException(e);
//        }
       // System.out.println(lf.length);
     exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
        exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
        exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "*");
        exchange.getResponseHeaders().add("Access-Control-Allow-Credentials", "true");
        exchange.getResponseHeaders().add("Access-Control-Allow-Credentials-Header", "*");
        if(query.equals("/")){
            System.out.println("racine");
            File ff = new File(index+"/index.html");
            sendData(exchange,ff);

        }else if(query.equals("/rr")){
            System.out.println("racine 2");
            File ff = new File(index+"/index2.html");
            sendData(exchange,ff);
        } else if(query.equals("/favicon.ico")) {
            System.out.println("fav");
            File ff = new File(index+"/ico/favicon.ico");
            sendData(exchange,ff);
        }

   /*     for (File f : Objects.requireNonNull(index.listFiles())) {


          *//*  System.out.println(f.getName());
            exchange.getResponseHeaders().set("Content-Type", URLConnection.guessContentTypeFromName(f.getPath()));
            FileInputStream fileInputStream = new FileInputStream(f);
            byte[] r = fileInputStream.readAllBytes();
            System.out.println(r.length);
             exchange.sendResponseHeaders(200, r.length);
            exchange.getResponseBody().write(r);*//*

        }*/           // exchange.getResponseBody().close();


    }

    private void sendData(HttpExchange exchange, File f) throws IOException {
        System.out.println(f.getPath());
        FileInputStream fis = new FileInputStream(f);
        byte[] r = fis.readAllBytes();
        System.out.println("l: "+r.length);
        exchange.getResponseHeaders().set("Content-Type", URLConnection.guessContentTypeFromName(f.getPath()));
        exchange.sendResponseHeaders(200, r.length);
        exchange.getResponseBody().write(r);
        exchange.getResponseBody().close();
    }

      
}
