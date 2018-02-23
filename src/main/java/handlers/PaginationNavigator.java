package handlers;

import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.StringJoiner;

public class PaginationNavigator {

    public String navToNextPage(HtmlPage currentPage) throws IOException {
        StringJoiner sj = new StringJoiner("\n");
        final ResultsExtractor resultsExtractor = new ResultsExtractor();
        nav(currentPage, sj, resultsExtractor);
        return sj.toString();
    }

    private void nav(HtmlPage currentPage, StringJoiner sj, ResultsExtractor resultsExtractor) throws IOException {
        sj.add(resultsExtractor.getAsText(currentPage));
        final Optional<HtmlElement> nextLink = Optional.ofNullable(currentPage
                .getFirstByXPath("//a[@class='next page-numbers fontello-icon-right-open']"));
        if (nextLink.isPresent()) {
            nav(nextLink.get().click(), sj, resultsExtractor);
        }
    }

    public void writeToCsv(String results) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("src/test/resources/reviews-summary.csv"))) {
            writer.write(results);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
