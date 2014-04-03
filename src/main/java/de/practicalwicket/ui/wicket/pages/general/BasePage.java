package de.practicalwicket.ui.wicket.pages.general;

import de.practicalwicket.ui.wicket.pages.HomePage;
import de.practicalwicket.ui.wicket.pages.hierarchy.Page1;
import de.practicalwicket.ui.wicket.pages.hierarchy.Page2;
import de.practicalwicket.ui.wicket.pages.mounting.MountingIndexed;
import de.practicalwicket.ui.wicket.pages.mounting.MountingQuery;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

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

        PageParameters parametersNamed = new PageParameters();
        parametersNamed.add("author", "Friedrich Schiller");
        parametersNamed.add("foo", "Die Räuber");
        add(new BookmarkablePageLink<MountingIndexed>("named", MountingIndexed.class, parametersNamed));

        PageParameters parametersQuery = new PageParameters();
        parametersQuery.add("demoParam", "Friedrich Schiller");
        add(new BookmarkablePageLink<MountingQuery>("query",MountingQuery.class, parametersQuery));


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
