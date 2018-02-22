package main;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



public class ResultsExtractor {
    private static final String DOM_ATTRIBUTES = "src/test/resources/dom-attributes.json";
    private static final String ELEMENT_NAME = "elementName";
    private static final String ATTRIBUTE_NAME = "attributeName";
    private static final String ATTRIBUTE_VALUE = "attributeValue";


    protected DomSettings setDomSettings(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filename), new TypeReference<DomSettings>() {
        });
    }

    public String getAsText(HtmlPage page) throws IOException {
        DomSettings settings = setDomSettings(DOM_ATTRIBUTES);
        List<HtmlElement> elements = page.getByXPath(settings.getReviewsXpath());
        return elements.stream().map(e -> formatText(e, settings)).collect(Collectors.joining("\n"));
    }

    private String formatText(HtmlElement element, DomSettings settings) {
        final String title = extractTitle(element, settings.getTitle());
        return title + "\n" + extractEditorRating(element, settings.getEditorRating())
                + "\n" + extractReview(title, settings.getReviewUrlDetails());
    }

    private String extractTitle(HtmlElement element, Map<String, String> title) {
        return element.getOneHtmlElementByAttribute(title.get(ELEMENT_NAME), title.get(ATTRIBUTE_NAME),
                title.get(ATTRIBUTE_VALUE)).asText();
    }

    private String extractEditorRating(HtmlElement element, Map<String, String> editorRating) {
        return element.getOneHtmlElementByAttribute(editorRating.get(ELEMENT_NAME), editorRating.get(ATTRIBUTE_NAME),
                editorRating.get(ATTRIBUTE_VALUE)).asText();
    }

    //TODO still too customised to specific site
    private String extractReview(String title, Map<String, String> reviewUrlDetails) {
        return reviewUrlDetails.get("prefix")
                + title.toLowerCase().replace(" ", "-")
                + reviewUrlDetails.get("suffix");
    }
}
