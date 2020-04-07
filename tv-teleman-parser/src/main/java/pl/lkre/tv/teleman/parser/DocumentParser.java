package pl.lkre.tv.teleman.parser;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import pl.lkre.tv.schedule.model.Seance;

import java.util.List;
import java.util.stream.Collectors;

public class DocumentParser {

    public List<Seance> parse(Document document) {
        return buildSeances(buildNodes(document));
    }

    private List<Node> buildNodes(Document document) {
        final Node body = document
                .childNode(1)
                .childNode(2);
        final Node content = body
                .childNodes()
                .stream()
                .filter(o -> o.attr("id").equals("content"))
                .findFirst().get();

        return content
                .childNode(3)
                .childNode(5)
                .childNodes()
                .stream()
                .filter(o -> !"ad".equals(o.attr("class")))
                .collect(Collectors.toList());
    }

    private List<Seance> buildSeances(List<Node> nodes) {
        return nodes
                .stream()
                .map(SeanceParser::parse)
                .collect(Collectors.toList());
    }
}
