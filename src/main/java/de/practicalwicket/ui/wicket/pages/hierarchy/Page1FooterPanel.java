package de.practicalwicket.ui.wicket.pages.hierarchy;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bert
 */
public class Page1FooterPanel extends Panel {


    public Page1FooterPanel(String id) {
        super(id);

        // we place the current date / time into the footer. Per default, Date would be formatted  without time
        // uncomment the line below and the corresponding WicketApplication.newConverterLocator()
        // add(new Label("currentTime", new Date()));
        add(new Label("currentTime", new SimpleDateFormat("dd.MM.yyyy HH:mm").format(new Date())));

    }
}
