package eu.iamgio.pokedex.connection;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import lombok.Getter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Utility class for HTTP connections
 * @author Gio
 */
public class HttpConnection {

    private static final String PREFIX = "https://pokeapi.co/api/v2/";

    @Getter private String url;

    public HttpConnection(String url) {
        this.url = PREFIX + url;
    }

    /**
     * Reads a website
     * @return HTML of the website
     * @throws RuntimeException if an error occurred
     */
    private String read() throws RuntimeException {
        try {
            URL website = new URL(url);
            URLConnection connection = website.openConnection();

            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:63.0) Gecko/20100101 Firefox/63.0");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("accept", "application/json");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while((inputLine = in.readLine()) != null) response.append(inputLine);
            in.close();
            return response.toString();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Parses website content to JSON
     * @return Parsed JSON
     * @throws RuntimeException if an error occurred
     */
    public JsonObject getJson() throws RuntimeException {
        JsonReader reader = new JsonReader(new StringReader(read()));
        reader.setLenient(true);
        return new JsonParser().parse(reader).getAsJsonObject();
    }

    /**
     * Parses website content to JSON array
     * @return Parsed JSON array
     * @throws RuntimeException if an error occurred
     */
    public JsonArray getJsonArray() throws RuntimeException {
        JsonReader reader = new JsonReader(new StringReader(read()));
        reader.setLenient(true);
        return new JsonParser().parse(reader).getAsJsonArray();
    }
}