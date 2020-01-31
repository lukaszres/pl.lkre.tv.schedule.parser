package pl.lkre.tv.teleman.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class HtmlFileReader {
    public static Document read(String fileName) throws IOException {
        ClassLoader classLoader = HtmlFileReader.class.getClassLoader();

        File file = new File(classLoader.getResource(fileName).getFile());
        String content = new String(Files.readAllBytes(file.toPath()));

        return Jsoup.parse(content);
    }
}
