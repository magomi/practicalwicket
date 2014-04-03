package de.practicalwicket.ui.wicket;

import de.practicalwicket.ui.wicket.pages.HomePage;
import de.practicalwicket.ui.wicket.pages.formprocessing.RegistrationPage;
import de.practicalwicket.ui.wicket.pages.hierarchy.Page1;
import de.practicalwicket.ui.wicket.pages.hierarchy.Page2;
import de.practicalwicket.ui.wicket.resources.css.ApplicationCssReference;
import de.practicalwicket.ui.wicket.resources.css.BootstrapCssReference;
import de.practicalwicket.ui.wicket.resources.js.BootstrapResourceReference;
import de.practicalwicket.ui.wicket.util.DemoDateConverter;
import org.apache.wicket.ConverterLocator;
import org.apache.wicket.IConverterLocator;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

import java.util.Date;

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
        mountPage("registration", RegistrationPage.class);


        getResourceBundles().addCssBundle(WicketApplication.class, "styles.css"
                , new BootstrapCssReference()
                , new ApplicationCssReference());

        getResourceBundles().addJavaScriptBundle(WicketApplication.class, "application.js"
                , new BootstrapResourceReference());
	}





    @Override
    protected IConverterLocator newConverterLocator() {
        ConverterLocator converterLocator = new ConverterLocator();
        converterLocator.set(Date.class, new DemoDateConverter());
        return converterLocator;
    }
}
