package pl.lkre.tv.teleman.parser;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import pl.lkre.tv.teleman.HtmlParser;

import java.util.List;
import java.util.stream.Collectors;

public class HtmlParserImpl implements HtmlParser {
    @Override
    public List<Node> parse(Document document) {
        return document
                .childNode(1)
                .childNode(2)
                .childNode(5)
                .childNode(3)
                .childNode(5)
                .childNodes()
                .stream()
                .filter(o -> !"ad".equals(o.attr("class")))
                .collect(Collectors.toList());
    }
}
