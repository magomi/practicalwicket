package de.practicalwicket;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.CompoundPropertyModel;

public class HomePage extends WebPage {

    private Person goethe = new Person("Goethe", "Mehr Licht!");

	public HomePage() {
        setDefaultModel(new CompoundPropertyModel<Person>(goethe));
		add(new Label("name"));
        add(new Label("famousLastWord"));
    }

    private class Person {
        private String name;
        private String famousLastWord;

        private Person(String name, String famousLastWord) {
            this.name = name;
            this.famousLastWord = famousLastWord;
        }
    }
}
