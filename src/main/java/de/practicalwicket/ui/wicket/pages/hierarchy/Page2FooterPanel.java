package de.practicalwicket.ui.wicket.pages.hierarchy;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * Created by bert
 */
public class Page2FooterPanel extends Panel {

    public Page2FooterPanel(String id) {
        super(id);

        add(new Label("className", getClass().getName()));
    }
}
