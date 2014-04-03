package de.practicalwicket;

import de.practicalwicket.entities.LastWords;
import de.practicalwicket.services.DateService;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class HomePage extends WebPage {

    @SpringBean(name = "dateService")
    private DateService dateService;

    private LastWords goethe = new LastWords("Goethe", "Mehr Licht!");

	public HomePage() {
        setDefaultModel(new CompoundPropertyModel<LastWords>(goethe));
		add(new Label("name"));
        add(new Label("famousLastWord"));
        add(new Label("curDate", Model.of(dateService.getDate())));
    }
}
