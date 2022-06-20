package com.kodilla.good.patterns.challenges.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public final class Bigmac {
    private final boolean bun;
    private final int burgers;
    private final String sauce;
    private List<String> ingredients;

    private Bigmac(final boolean bun, final int burgers, final String sauce, List<String> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public boolean isBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bun=" + bun +
                ", burgers=" + burgers +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }

    public static class BigmacBuilder {
        private boolean bun;
        private int burgers;
        private String sauce;
        private List<String> listOfIngredients = new ArrayList<>();

        public BigmacBuilder bun(boolean bun) {
            this.bun = bun;
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredients(String...ingredients) {
            for(String ingredient : ingredients) {
                listOfIngredients.add(ingredient);
            }
            return this;
        }

        public Bigmac build() {
            return new Bigmac(bun, burgers, sauce, listOfIngredients);
        }
    }
}
