package main;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

//Integration Test, TODO but a really crap one
public class RunnerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    public void testWebClientFetchesDom(){
        String expected = null;
        try(Stream<String> text = Files.lines(Paths.get("src/test/resources/expected-output.txt"))){
            expected = text.collect(Collectors.joining("\n")) + "\n";
            ScrapingRunner.main(new String[0]);
        }catch(IOException e){
            e.printStackTrace();
        }
        assertEquals(expected, outContent.toString());

    }

}
