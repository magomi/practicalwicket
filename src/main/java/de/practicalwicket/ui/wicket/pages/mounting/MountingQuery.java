package de.practicalwicket.ui.wicket.pages.mounting;

import de.practicalwicket.ui.wicket.pages.general.BasePage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * @author bert
 */
public class MountingQuery extends BasePage {


    public MountingQuery(PageParameters parameters) {
        super("mounting page with query parameters");

        String author = parameters.get("demoParam").toString("default");
        String foo = parameters.get(1).toString("default-foo");

        add(new Label("par0", author));
        add(new Label("par1", foo));

    }
}
