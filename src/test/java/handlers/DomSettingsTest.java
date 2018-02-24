package handlers;

import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class DomSettingsTest {


    @Test
    public void sanityCheckNoNextLink(){
        final DomSettings domSettings = new DomSettings("", "",
                Collections.emptyMap(), Collections.emptyMap(),
                Collections.emptyMap());

        assertEquals(Collections.emptyMap(), domSettings.getEditorRating());
    }
}