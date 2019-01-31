package Main;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TimerTask;

public class News {
    private Map<String, String> map = new LinkedHashMap<>();
    private int count = 0;

    private void getNews() throws IOException {
        String url_news = "https://stopgame.ru/news";
        String url_main = "https://stopgame.ru";

        Document doc = Jsoup.connect(url_news).get();

        Elements element = doc.getElementsByAttributeValue("class", "title lent-title");

        element.forEach(element1 -> {
            Element aElement = element1.child(0);
            map.put(url_main + aElement.attr("href"), element1.text());
        });

        Set<Map.Entry<String, String>> set = map.entrySet();
        System.out.println("\nСписок новостей: ");
        for (Map.Entry<String, String> m : set) {
            System.out.println("\n" + m.getValue() + ": \n" + m.getKey());
        }
    }

    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            try {
                System.out.println("\nКолличество новостей перед проверкой: " + map.size());
                getNews();
                count++;
                System.out.println("\nПоиск новостей осуществлялся: " + count + " раз");
                System.out.println("Колличество новых новостей после проверки: " + map.size());
                System.out.println();
            } catch (IOException e) {
                System.err.println("Ошибка при подключении к сайту " + e);

            }
        }
    };
}
