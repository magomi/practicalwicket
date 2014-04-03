package de.practicalwicket.entities;

import javax.persistence.Entity;

/**
 * A simple Person
 *
 * @author Grunert, Marco (marco.grunert@intecsoft.de)
 */
@Entity
public class LastWords {
    private String name;
    private String famousLastWord;

    protected LastWords() {
    }

    public LastWords(String name, String famousLastWord) {
        this.name = name;
        this.famousLastWord = famousLastWord;
    }
}