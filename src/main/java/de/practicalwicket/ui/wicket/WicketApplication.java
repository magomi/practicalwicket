package de.practicalwicket.ui.wicket;

import de.practicalwicket.ui.wicket.pages.open.LoginPage;
import de.practicalwicket.ui.wicket.pages.secured.HomePage;
import de.practicalwicket.ui.wicket.resources.css.ApplicationCssReference;
import de.practicalwicket.ui.wicket.resources.css.BootstrapCssReference;
import de.practicalwicket.ui.wicket.resources.js.BootstrapResourceReference;
import de.practicalwicket.ui.wicket.util.AuthStrategy;
import org.apache.wicket.Component;
import org.apache.wicket.Session;
import org.apache.wicket.application.IComponentInstantiationListener;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;

public class WicketApplication extends WebApplication {

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

        mountPage("login", LoginPage.class);

        setupAuthorization();

        getResourceBundles().addCssBundle(WicketApplication.class, "styles.css"
                , new BootstrapCssReference()
                , new ApplicationCssReference());

        getResourceBundles().addJavaScriptBundle(WicketApplication.class, "application.js"
                , new BootstrapResourceReference());
	}


    private void setupAuthorization() {
        AuthStrategy authStrategy = new AuthStrategy();
        getSecuritySettings().setAuthorizationStrategy(authStrategy);
        getSecuritySettings().setUnauthorizedComponentInstantiationListener(authStrategy);

        getComponentInstantiationListeners().add(new IComponentInstantiationListener() {

            public void onInstantiation(final Component component) {
                if (!getSecuritySettings().getAuthorizationStrategy()
                        .isInstantiationAuthorized(component.getClass())) {
                    getSecuritySettings()
                            .getUnauthorizedComponentInstantiationListener()
                            .onUnauthorizedInstantiation(component);
                }
            }
        });
    }

    @Override
    public Session newSession(Request request, Response response) {
        return new DemoSession(request);
    }
}
