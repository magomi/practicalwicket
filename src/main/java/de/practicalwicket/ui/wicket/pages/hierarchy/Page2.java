package de.practicalwicket.ui.wicket.pages.hierarchy;

import de.practicalwicket.ui.wicket.pages.general.BasePage;
import org.apache.wicket.Component;

/**
 * Created by bert
 */
public class Page2 extends BasePage {

    public Page2() {
        super("Page 2");
    }

    @Override
    protected Component getFooterPanel(String wicketID) {
        return new Page2FooterPanel(wicketID);
    }
}
