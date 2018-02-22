package main;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public class DomSettings {
    private final String url;
    private final String reviewsXpath;
    private final Map<String, String> reviewUrlDetails;
    private final Map<String, String> title;
    private final Map<String, String> editorRating;

    public DomSettings(@JsonProperty(value = "url", required = true) String url,
                       @JsonProperty(value = "reviewsXpath", required = true) String reviewsXpath,
                       @JsonProperty(value = "reviewUrlDetails", required = true) Map<String, String> reviewUrlDetails,
                       @JsonProperty(value = "title", required = true) Map<String, String> title,
                       @JsonProperty(value = "editorRating", required = true) Map<String, String> editorRating) {
        this.url = url;
        this.reviewsXpath = reviewsXpath;
        this.reviewUrlDetails = reviewUrlDetails;
        this.title = title;
        this.editorRating = editorRating;
    }

    public String getUrl() {
        return url;
    }

    public String getReviewsXpath() {
        return reviewsXpath;
    }

    public Map<String, String> getTitle() {
        return title;
    }

    public Map<String, String> getEditorRating() {
        return editorRating;
    }


    public Map<String,String> getReviewUrlDetails() {
        return reviewUrlDetails;
    }
}
