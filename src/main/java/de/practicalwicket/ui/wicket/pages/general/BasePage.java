package de.practicalwicket.ui.wicket.pages.general;

import de.practicalwicket.model.Registration;
import de.practicalwicket.ui.wicket.pages.HomePage;
import de.practicalwicket.ui.wicket.pages.formprocessing.RegistrationPage;
import de.practicalwicket.ui.wicket.pages.hierarchy.Page1;
import de.practicalwicket.ui.wicket.pages.hierarchy.Page2;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.model.IModel;

/**
 * Created by bert
 */
public class BasePage extends WebPage {


    private final String title;

    public BasePage(String title) {
        this(title, null);
    }

    public BasePage(String title, IModel<Registration> model) {
        super(model);
        this.title = title;

    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new Label("title", title));
        add(new BookmarkablePageLink<HomePage>("homepage", HomePage.class));
        add(new BookmarkablePageLink<Page1>("page1", Page1.class));
        add(new BookmarkablePageLink<Page2>("registration", RegistrationPage.class));

        add(getFooterPanel("footerPanel"));
    }

    /**
     * Component to be placed into the footer.
     *
     * Sub-pages can overwrite this to place any component into the footer.
     * The basePage puts a empty panel into the footer.
     *
     * @param wicketID wicket:id the returned Component must use.
     * @return Component to be placed into the footer.
     */
    protected Component getFooterPanel(String wicketID) {
        return new EmptyPanel(wicketID);
    }

}
