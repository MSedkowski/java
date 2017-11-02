package webreaderapplication;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class WebReaderApplication {

    public static void main(String[] args) throws IOException {
        OpenUrl newSite = new OpenUrl();
        ArrayList listOfLinks = new ArrayList();
        ArrayList listOfEmails = new ArrayList();
        
        SaveToFile savingBuffer = new SaveToFile(new SimpleDateFormat("yyyyMMddHHmm").format(new Date()));
        savingBuffer.save("**********************Log********************\n");
        savingBuffer.save("Adres strony: " + args[0]);
        URL myUrl = new URL(args[0]);
        InetAddress address = InetAddress.getByName(myUrl.getHost());
        String ip = address.getHostAddress();
        savingBuffer.save("Adres ip strony: " + ip + "\n");
        savingBuffer.save("**********************Linki********************\n");
        listOfLinks = newSite.readLinksFromURLJSub(args[0]);
        for (int i = 0; i < listOfLinks.size(); i++) {
            savingBuffer.save(listOfLinks.get(i).toString() + "\n");
        }
        savingBuffer.save("**********************E-mail*********************");
        listOfEmails = newSite.readEmailsFromURL(args[0]);
        for (int i = 0; i < listOfEmails.size(); i++) {
            savingBuffer.save(listOfEmails.get(i).toString());
        }
        savingBuffer.save("***********************Head*************************");
        savingBuffer.save(newSite.readHTMLHead(args[0]));
        savingBuffer.save("***********************Connection**************************");
        int line = 0;
        for (; line < 20; line++) {
            savingBuffer.save(newSite.readHTMLConnectionAttribute(myUrl, line));
        }
    }
}
