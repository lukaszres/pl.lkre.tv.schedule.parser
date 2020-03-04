package pl.lkre.tv.teleman;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import pl.lkre.tv.schedule.model.Station;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class MainClass {

//    @Test
    void test() throws IOException {
        StationFactory stationFactory = new StationFactory();
        String content = new Scanner(new URL("https://www.teleman.pl/program-tv/stacje/TVP-1?hour=-1").openStream(), "UTF-8").useDelimiter("\\A").next();
        Document document = Jsoup.parse(content);
        Station tvp1 = stationFactory.build(document);
        System.out.println(tvp1);
    }
}
