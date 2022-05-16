package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.*;

public class StreamMain {
    public static void main(String[] args) {

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("Doll",(text) -> text + "DEF");
        poemBeautifier.beautify("Doll",(text) -> text.toUpperCase());
        poemBeautifier.beautify("Doll",(text) -> text.toLowerCase());
        poemBeautifier.beautify("Doll",(text) -> text.substring(1,3));
        poemBeautifier.beautify(" Doll doll    doll ",(text) -> text.trim());
    }
}
