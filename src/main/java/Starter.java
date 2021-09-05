import java.io.IOException;
import java.util.LinkedList;

public class Starter {
    public static void main(String[] args) throws IOException {

        LinkedList<String> listlinks = new LinkedList<>();

        listlinks.add("http://parkovy.komi.msudrf.ru");
        listlinks.add("http://galtms3.ralt.msudrf.ru");
        listlinks.add("http://baun.bur.msudrf.ru");
        listlinks.add("http://maikop2.adg.msudrf.ru");
        listlinks.add("http://5.bkr.msudrf.ru");
        listlinks.add("http://8.ing.msudrf.ru");

        ParseSite parseSite = new ParseSite();

        for (String link : listlinks) {
            parseSite.parseSiteApp(link);
        }
    }
}

