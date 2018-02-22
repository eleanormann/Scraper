package main;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

public class ScrapingRunner {

    private void run(String url){
        WebClient webClient = new WebClient();
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setCssEnabled(false);
        try {
            HtmlPage page = webClient.getPage(url);
            ResultsExtractor results = new ResultsExtractor();
            System.out.println(results.getAsText(page));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TODO not using json url yet
    public static void main(String[] args) {
        String url = args.length!=0 ? args[0] :
                "https://www.runningshoesguru.com/reviews/all/stability/";
        new ScrapingRunner().run(url);
    }
}
