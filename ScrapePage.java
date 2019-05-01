import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class ScrapePage {
    public static void main(String[] args) throws IOException {
        String url = args[0];
        String name = args[1];

        FileWriter writer = new FileWriter(name + ".html");
        writer.write(getPage(url));
        writer.close();
    }

    public static String getPage(String url) throws IOException {
        URLConnection conn = (new URL(url)).openConnection();
        conn.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String output = "", line = "";
        while ((line = br.readLine()) != null) {
            output += line;
        }
        return output;
    }


}