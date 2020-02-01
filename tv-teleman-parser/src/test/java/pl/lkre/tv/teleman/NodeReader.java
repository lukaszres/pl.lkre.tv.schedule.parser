package pl.lkre.tv.teleman;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;

import java.io.IOException;
import java.util.stream.Collectors;

public class NodeReader {

    public static Node read(String fileName, int index) throws IOException {
        final Document document = HtmlFileReader.read(fileName);
        return document
                .childNode(1)
                .childNode(2)
                .childNode(5)
                .childNode(3)
                .childNode(5)
                .childNodes()
                .stream()
                .filter(o -> !"ad".equals(o.attr("class")))
                .collect(Collectors.toList())
                .get(index);
    }
}
