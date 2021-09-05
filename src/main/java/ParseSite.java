import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class ParseSite {
    public static ArrayList<ParsedData> parseSiteApp(String listLinks) throws IOException {

        Document page = Jsoup.connect(listLinks + "/modules.php?name=sud_delo&op=rd&delo_table=G1_DOCUMENT&delo_id=1540005").timeout(5000).get();
        Elements linksNumbersElements = page.select(".lawcase-number-td a");

        ArrayList<ParsedData> listParsedData = new ArrayList<>();

        for (Element linkNumber : linksNumbersElements) {

            String number = linkNumber.text();
            String link = page.select(".vert-align a").attr("href");

            Document doc = Jsoup.connect(listLinks + link).get();
            Elements findSolutionText = doc.select(".WordSection1 p");
            String solutionText = findSolutionText.html();

            Map<String, String> resolution = new HashMap<>();
            resolution.put("caseNumber", number);

            ParsedData.PartData linkTextInHtmlFormat = new ParsedData.PartData();
            linkTextInHtmlFormat.setHtml(solutionText);
            linkTextInHtmlFormat.setData(resolution);

            new ParsedData(null, null, null, linkTextInHtmlFormat);

            listParsedData.add(new ParsedData(null, null, null, linkTextInHtmlFormat));
        }
        return listParsedData;
    }
}
