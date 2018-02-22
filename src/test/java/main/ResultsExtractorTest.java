package main;

import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.WebWindow;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ResultsExtractorTest {



    @Test
    public void testJsonMapsProperly() throws IOException {
        DomSettings dom = new ResultsExtractor().setDomSettings("src/test/resources/dom-attributes.json");
        assertEquals("https://www.runningshoesguru.com/reviews/all/stability/", dom.getUrl());
        assertEquals("//article[@class='row post-list']", dom.getReviewsXpath());
        assertEquals("https://www.runningshoesguru.com/2018/02/", dom.getReviewUrlDetails().get("prefix"));
        assertEquals("h2", dom.getTitle().get("elementName"));
        assertEquals("class", dom.getTitle().get("attributeName"));
        assertEquals("entry-title", dom.getTitle().get("attributeValue"));
        assertEquals("div", dom.getEditorRating().get("elementName"));
        assertEquals("class", dom.getEditorRating().get("attributeName"));
        assertEquals("col-xs-6 col-ms-4 col-sm-4 col-lg-3", dom.getEditorRating().get("attributeValue"));
    }

}
