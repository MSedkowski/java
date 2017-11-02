package webreaderapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class OpenUrl {

    private static final String PATTERN = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\\\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
//    private static final String PATTERN = "[a-z0-9]+@+[a-z0-9]+[.]+[a-z]{2,3}";

    ArrayList readEmailsFromURL(String address) throws MalformedURLException, IOException {
        URL urlData = new URL(address);
        BufferedReader data = new BufferedReader(
                new InputStreamReader(urlData.openStream()));
        ArrayList listOfEmails = new ArrayList();
        Pattern p = Pattern.compile(PATTERN);

        String line;
        while ((line = data.readLine()) != null) {
            Matcher m = p.matcher(line);
            if (m.find()) {
                listOfEmails.add(m.group(0));
            }
        }
        return listOfEmails;
    }

    ArrayList readLinksFromURLJSub(String address) throws IOException {
        String url = address;

        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("[href]");
        ArrayList listOfLinks = new ArrayList();
        for (Element link : links) {
            listOfLinks.add(link.attr("abs:href"));
        }
        return listOfLinks;
    }

    String readHTMLHead(String address) throws IOException {
        String url = address;

        Document doc = Jsoup.connect(url).get();
        Element head = doc.head();
        String contentOfHead = new String();
        contentOfHead = head.toString();
        return contentOfHead;
    }

    String readHTMLConnectionAttribute(URL address, int line) throws IOException {
        URL myUrl = address;
        URLConnection myURLConnection = myUrl.openConnection();
        myURLConnection.connect();
        String contentOfHead = new String();
        contentOfHead = myURLConnection.getHeaderField(line);
        return contentOfHead;
    }

}
