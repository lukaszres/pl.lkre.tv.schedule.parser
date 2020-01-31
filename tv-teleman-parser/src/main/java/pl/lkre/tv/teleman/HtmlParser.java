package pl.lkre.tv.teleman;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;

import java.util.List;

public interface HtmlParser {
    List<Node> parse(Document document);
}
