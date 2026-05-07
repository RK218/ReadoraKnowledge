import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Backend {

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(
            new InetSocketAddress(8080),
            0
        );

        server.createContext("/books", new BookHandler());

        server.setExecutor(null);

        server.start();

        System.out.println(
            "Server running on http://localhost:8080/books"
        );
    }
}

class BookHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange){

        try{

            String response = "[" +

            "{\"id\":1,\"title\":\"Atomic Habits\",\"genre\":\"Self Help\",\"price\":500}," +
            "{\"id\":2,\"title\":\"Ikigai\",\"genre\":\"Self Help\",\"price\":350}," +
            "{\"id\":3,\"title\":\"Deep Work\",\"genre\":\"Self Help\",\"price\":450}," +
            "{\"id\":4,\"title\":\"The Power of Now\",\"genre\":\"Self Help\",\"price\":1400}," +
            "{\"id\":5,\"title\":\"Think Like a Monk\",\"genre\":\"Self Help\",\"price\":550}," +

            "{\"id\":6,\"title\":\"The Hobbit\",\"genre\":\"Fantasy\",\"price\":650}," +
            "{\"id\":7,\"title\":\"Harry Potter\",\"genre\":\"Fantasy\",\"price\":700}," +
            "{\"id\":8,\"title\":\"Percy Jackson\",\"genre\":\"Fantasy\",\"price\":600}," +
            "{\"id\":9,\"title\":\"Game of Thrones\",\"genre\":\"Fantasy\",\"price\":1850}," +
            "{\"id\":10,\"title\":\"The Name of the Wind\",\"genre\":\"Fantasy\",\"price\":750}," +

            "{\"id\":11,\"title\":\"Sherlock Holmes\",\"genre\":\"Mystery\",\"price\":450}," +
            "{\"id\":12,\"title\":\"Gone Girl\",\"genre\":\"Mystery\",\"price\":500}," +
            "{\"id\":13,\"title\":\"The Silent Patient\",\"genre\":\"Mystery\",\"price\":620}," +
            "{\"id\":14,\"title\":\"Murder on the Orient Express\",\"genre\":\"Mystery\",\"price\":1580}," +
            "{\"id\":15,\"title\":\"The Girl with the Dragon Tattoo\",\"genre\":\"Mystery\",\"price\":720}," +

            "{\"id\":16,\"title\":\"Dune\",\"genre\":\"Sci-Fi\",\"price\":800}," +
            "{\"id\":17,\"title\":\"Foundation\",\"genre\":\"Sci-Fi\",\"price\":650}," +
            "{\"id\":18,\"title\":\"Neuromancer\",\"genre\":\"Sci-Fi\",\"price\":700}," +
            "{\"id\":19,\"title\":\"The Martian\",\"genre\":\"Sci-Fi\",\"price\":550}," +
            "{\"id\":20,\"title\":\"Ready Player One\",\"genre\":\"Sci-Fi\",\"price\":1600}," +

            "{\"id\":21,\"title\":\"Treasure Island\",\"genre\":\"Adventure\",\"price\":500}," +
            "{\"id\":22,\"title\":\"The Call of the Wild\",\"genre\":\"Adventure\",\"price\":1450}," +
            "{\"id\":23,\"title\":\"Life of Pi\",\"genre\":\"Adventure\",\"price\":620}," +
            "{\"id\":24,\"title\":\"Into the Wild\",\"genre\":\"Adventure\",\"price\":580}," +
            "{\"id\":25,\"title\":\"Journey to the Center of the Earth\",\"genre\":\"Adventure\",\"price\":700}" +

            "]";

            exchange.getResponseHeaders().add(
                "Access-Control-Allow-Origin",
                "*"
            );

            exchange.getResponseHeaders().add(
                "Content-Type",
                "application/json"
            );

            exchange.sendResponseHeaders(
                200,
                response.length()
            );

            OutputStream os = exchange.getResponseBody();

            os.write(response.getBytes());

            os.close();

        }catch(Exception e){

            e.printStackTrace();
        }
    }
}