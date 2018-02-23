package handlers;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void testExtractReviewReturnsUrlWithDashSeparatedTitle(){

        assertEquals("www.test.com/title-is-dash-separated-with-suffix/",
                new ResultsExtractor().extractReview("Title is Dash Separated",
                        ImmutableMap.of("prefix", "www.test.com/", "suffix", "-with-suffix/")));
    }

}
