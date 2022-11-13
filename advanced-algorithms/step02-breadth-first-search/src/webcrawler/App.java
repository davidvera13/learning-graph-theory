package webcrawler;

public class App {
    // the whole WWW can be represented by a directed graph
    // > vertices(nodes) are domains / URLs / Websites
    // > edges are http links
    // > we have to parse a given website's HTML code and look for URLs
    // With BFS, we are able to traverse web with a webcrawler (Google Spider for example)
    // that can hop from URL to URL and can observe the features of the network

    // a web crawler may acquire important parameters of the web
    // > google has to index all the relevant web pages and hae to find a way to sort
    //   them by relevance in result search
    // > this is why page rank is calculated
    // We can use a web crawler in order to learn about the typology and the degree
    // of distribution of complex network (system)
    // Barabasi model allow to analyse complex network and can learn a lot about
    // the entities of the network
    // for example: who is the most popular person in a group of people ?
    // what company is the most influential
    public static void main(String[] args) {
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.discoverWeb("https://www.bbc.com");
        // bfs.discoverWeb("https://www.facebook.com");
    }
}
