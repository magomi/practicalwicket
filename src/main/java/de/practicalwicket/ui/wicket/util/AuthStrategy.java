package de.practicalwicket.ui.wicket.util;

import de.practicalwicket.ui.wicket.DemoSession;
import de.practicalwicket.ui.wicket.pages.open.LoginPage;
import org.apache.wicket.Component;
import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.authorization.Action;
import org.apache.wicket.authorization.IAuthorizationStrategy;
import org.apache.wicket.authorization.IUnauthorizedComponentInstantiationListener;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.component.IRequestableComponent;


public class AuthStrategy implements IAuthorizationStrategy, IUnauthorizedComponentInstantiationListener {

    @Override
    public boolean isActionAuthorized(final Component component, final Action action) {

        if (action.equals(Component.RENDER)) {
            Class<? extends Component> c = component.getClass();
            if (c.isAnnotationPresent(SecuredPage.class)) {
                if ( ! DemoSession.get().isAuthenticated()) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public <T extends IRequestableComponent> boolean isInstantiationAuthorized(final Class<T> componentClass) {

        if (componentClass.isAnnotationPresent(SecuredPage.class)) {
            if ( ! DemoSession.get().isAuthenticated()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void onUnauthorizedInstantiation(final Component component) {

        if (WebPage.class.isAssignableFrom(component.getClass())) {
            throw new RestartResponseAtInterceptPageException(LoginPage.class);
        }
    }
}
