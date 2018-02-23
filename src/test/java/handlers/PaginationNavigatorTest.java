package handlers;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.google.common.collect.ImmutableSet;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

//Integration test
public class PaginationNavigatorTest {
    private WebClient client;

    @Before
    public void setUpWeClient(){
        client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
    }

    @Test
    public void nav() throws IOException {
        final HtmlPage page = client.getPage("https://www.runningshoesguru.com/reviews/all/stability/");
        final String output = new PaginationNavigator().navToNextPage(page);
        final String[] lines = output.split("\n");
        assertEquals(162, lines.length);
        assertEquals(162, ImmutableSet.copyOf(lines).size());
    }


}