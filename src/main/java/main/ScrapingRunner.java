package main;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import handlers.ResultsExtractor;

import java.io.IOException;

public class ScrapingRunner {

    private String run(String url){
        WebClient webClient = new WebClient();
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setCssEnabled(false);
        try {
            HtmlPage page = webClient.getPage(url);
            ResultsExtractor results = new ResultsExtractor();
            return results.getAsText(page);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //TODO handle errors better
        return "Failed to scrape website";
    }

    //TODO not using json url yet
    public static void main(String[] args) {
        String url = args.length!=0 ? args[0] :
                "https://www.runningshoesguru.com/reviews/all/stability/";
        System.out.println(new ScrapingRunner().run(url));
    }
}
