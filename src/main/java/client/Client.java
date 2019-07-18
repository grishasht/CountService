package client;

import java.io.*;
import java.net.URL;
import java.net.MalformedURLException;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import web.WordCounter;

public class Client {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://localhost:8888/count?wsdl");
        QName qname = new QName("http://impl.web/", "CounterService");

        Service service = Service.create(url, qname);
        WordCounter hello = service.getPort(WordCounter.class);


        Integer wordCount = hello.countWords(getArticle("src/main/resources/article.txt"), "Elvis");
        System.out.println(wordCount);
    }

    private static String getArticle(String filePath){
        File file = new File(filePath);
        BufferedReader reader;
        StringBuilder article = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tmp;
            while ((tmp = reader.readLine())!= null){
                article.append(tmp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return article.toString();
    }
}
