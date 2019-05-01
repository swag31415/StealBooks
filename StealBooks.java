import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class StealBooks {
    public static void main(String[] args) throws IOException {
        String baseUrl = "https://boxnovel.com/novel/release-that-witch/chapter-";
        int start = 1238;
        int end = 1243;
        String name = "RTW";

        FileWriter writer = new FileWriter(name + ".txt");

        for(int x = start; x <= end; x++) {
            try {
                writer.write("CHAPTER " + x + "\n" + getText(getPage(baseUrl + x)) + "\n");
                writer.flush();
                System.out.print(".");
            } catch (Exception e) {
                System.out.println("\nException at" + x);
            }
        }
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

    public static String getText(String page) {
        // page = page.substring(page.indexOf("<div class=\"fr-view\">"),
        //         page.indexOf("</div>", page.indexOf("<div class=\"fr-view\">")));

        // page = page.replaceAll("</p>", "\n");
        // page = page.replaceAll("\\<(.*?)\\>", "");
        // page = page.replaceAll("&nbsp", "");
        // page = page.replaceAll("Previous Chapter(.*?)Next Chapter", "");
        // page = page.replaceAll("Chapter(.*?)\n", "");

        return page;
    }
}