package web.impl;

import web.WordCounter;

import javax.jws.WebService;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@WebService(endpointInterface = "web.WordCounter")
public class Counter implements WordCounter {
    @Override
    public Integer countWords(String article, String word) {
        ConcurrentHashMap<String, Integer> dict = new ConcurrentHashMap<>();
        article = article.toLowerCase();
        word = word.toLowerCase();

        String[] words = article.split("[^a-zA-Z]+");
        for (String wrd : words) {
            dict.putIfAbsent(wrd, 0);
        }

        for (String wrd : words) {
            dict.put(wrd, dict.get(wrd) + 1);
        }

        Integer integer = dict.get(word);
        return Optional.ofNullable(integer).orElse(0);
    }
}
