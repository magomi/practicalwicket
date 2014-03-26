package de.practicalwicket.ui.wicket;

import de.practicalwicket.ui.wicket.pages.HomePage;
import de.practicalwicket.ui.wicket.pages.hierarchy.Page1;
import de.practicalwicket.ui.wicket.pages.hierarchy.Page2;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

public class WicketApplication extends WebApplication
{
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init() {
		super.init();

        mountPage("page1", Page1.class);
        mountPage("page2", Page2.class);

	}
}
