package ru.job4j.stream.card;

import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {

        Stream.of(Suit.values())
                .flatMap(su -> Stream.of(Value.values())
                        .map(val -> new Card(su, val)))
                .forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Card{"
                + "suit=" + suit
                + ", value=" + value
                + '}';
    }
}