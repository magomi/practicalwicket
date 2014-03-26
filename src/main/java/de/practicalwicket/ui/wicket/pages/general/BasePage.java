package de.practicalwicket.ui.wicket.pages.general;

import de.practicalwicket.ui.wicket.pages.HomePage;
import de.practicalwicket.ui.wicket.pages.hierarchy.Page1;
import de.practicalwicket.ui.wicket.pages.hierarchy.Page2;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

/**
 * Created by bert
 */
public class BasePage extends WebPage {


    private final String title;

    public BasePage(String title) {
        this.title = title;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new Label("title", title));
        add(new BookmarkablePageLink<HomePage>("homepage", HomePage.class));
        add(new BookmarkablePageLink<Page1>("page1", Page1.class));
        add(new BookmarkablePageLink<Page2>("page2", Page2.class));
    }
}
