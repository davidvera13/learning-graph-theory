package webcrawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BreadthFirstSearch {
    private Queue<String> queue;
    private List<String> discoveredWebsites;

    public BreadthFirstSearch() {
        this.queue = new LinkedList<>();
        this.discoveredWebsites = new ArrayList<>();
    }
    // let conside the www.bbc.com as root 
    public void discoverWeb(String root) {
        this.queue.add(root);
        this.discoveredWebsites.add(root);
        while (!queue.isEmpty()) {
            String currentVertex = this.queue.remove();
            String rawHtml = readUrl(currentVertex);

            // get URLS using regex
            String regexp = "https://(\\w+\\.)*(\\w+)";
            Pattern pattern = Pattern.compile(regexp);
            Matcher matcher = pattern.matcher(rawHtml);
            // if we find URL
            while (matcher.find()) {
                String website = matcher.group();
                // if we don't have the website in the list, we visit it
                if(!discoveredWebsites.contains(website)) {
                    discoveredWebsites.add(website);
                    System.out.println("Website found " + website);
                    queue.add(website);
                }
            }
        }
    }

    // read html content of an html page and we return html content in HTML
    private String readUrl(String currentVertex) {
        StringBuilder rawHtml = new StringBuilder("");
        try {
            URL url = new URL(currentVertex);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            String line = "";
            // we'll read each line until the end
            while ((line = reader.readLine()) != null) {
                rawHtml.append(line);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Problem while crawling website: " + e.getMessage());
        }

        return rawHtml.toString();
    }
}