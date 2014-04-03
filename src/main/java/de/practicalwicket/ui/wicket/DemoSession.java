package de.practicalwicket.ui.wicket;

import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

/**
 * @author bert
 */
public class DemoSession extends WebSession {

    private String userName;

    public DemoSession(Request request) {
        super(request);
    }

    public boolean isAuthenticated() {
        return userName != null;
    }

    public void logout() {
        userName = null;
        this.invalidate();
    }

    public String getUserName() {
        return userName;
    }

    public static DemoSession get() {
        return (DemoSession) Session.get();
    }

    public void login(String userName) {
        this.userName = userName;
    }

}
