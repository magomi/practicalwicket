package de.practicalwicket.ui.wicket.pages.hierarchy;

import de.practicalwicket.ui.wicket.pages.general.BasePage;
import org.apache.wicket.Component;

/**
 * Created by bert
 */
public class Page1 extends BasePage {


    public Page1() {
        super("Page 1");
    }

    @Override
    protected Component getFooterPanel(String wicketID) {
        return new Page1FooterPanel(wicketID);
    }
}
