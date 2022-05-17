package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.*;

public class StreamMain {
    public static void main(String[] args) {

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("Doll",(text) -> text + "DEF");
        poemBeautifier.beautify("Doll",(text) -> text.toUpperCase());
        poemBeautifier.beautify("Doll",(text) -> text.toLowerCase());
        poemBeautifier.beautify("Doll",(text) -> text.substring(1,3));
        poemBeautifier.beautify(" Doll doll    doll ",(text) -> text.trim());
    }
}
