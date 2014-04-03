package de.practicalwicket.ui.wicket.pages.secured;

import de.practicalwicket.ui.wicket.DemoSession;
import de.practicalwicket.ui.wicket.pages.general.BasePage;
import de.practicalwicket.ui.wicket.util.SecuredPage;
import org.apache.wicket.markup.html.basic.Label;

@SecuredPage
public class HomePage extends BasePage {

	private static final long serialVersionUID = 1L;

	public HomePage() {
        super("Home Page");

        add(new Label("userName", DemoSession.get().getUserName()));

    }
}
