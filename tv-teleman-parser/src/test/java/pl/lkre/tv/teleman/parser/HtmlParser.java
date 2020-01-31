package pl.lkre.tv.teleman.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HtmlParser {


    @Test
    void firstTest() throws IOException {
        String fileName = "channels/tvp_1.html";
        ClassLoader classLoader = HtmlParser.class.getClassLoader();

        File file = new File(classLoader.getResource(fileName).getFile());
        String content = new String(Files.readAllBytes(file.toPath()));

        Document document = Jsoup.parse(content);
//div class="lista"
        Element filmsElement = document.getElementById("programDzien").getElementsByAttributeValue("class", "lista").get(0).select("ul").get(0);

        assertTrue(file.exists());
    }
}
