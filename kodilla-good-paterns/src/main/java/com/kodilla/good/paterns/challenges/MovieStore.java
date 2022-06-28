package com.kodilla.good.paterns.challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class MovieStore {
    private final List<String> ironManTranslations = new ArrayList<>();
    private final List<String> avengersTranslations = new ArrayList<>();
    private final List<String> flashTranslations = new ArrayList<>();
    private final Map<String, List<String>> booksTitlesWithTranslations = new HashMap<>();

    public Map<String, List<String>> getMovies() {
        ironManTranslations.add("Żelazny Człowiek");
        ironManTranslations.add("Iron Man");

        avengersTranslations.add("Mściciele");
        avengersTranslations.add("Avengers");

        flashTranslations.add("Błyskawica");
        flashTranslations.add("Flash");

        booksTitlesWithTranslations.put("IM", ironManTranslations);
        booksTitlesWithTranslations.put("AV", avengersTranslations);
        booksTitlesWithTranslations.put("FL", flashTranslations);

        return booksTitlesWithTranslations;
    }

    public void showMovieTitles() {
        getMovies();

        String movieTitles = booksTitlesWithTranslations.entrySet().stream()
                .map(e -> e.getValue())
                .flatMap(List::stream)
                .collect(Collectors.joining("!"));

        System.out.print(movieTitles);
    }
}
