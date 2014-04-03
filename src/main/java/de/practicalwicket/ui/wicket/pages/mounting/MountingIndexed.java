package de.practicalwicket.ui.wicket.pages.mounting;

import de.practicalwicket.ui.wicket.pages.general.BasePage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * @author bert
 */
public class MountingIndexed extends BasePage {

    public MountingIndexed(PageParameters parameters) {
        super("mounting page with named parameters");

        String author = parameters.get("author").toString();
        String foo = parameters.get("foo").toString();

        add(new Label("author", author));
        add(new Label("foo", foo));

    }
}
