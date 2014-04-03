package de.practicalwicket.ui.wicket.pages;

import de.practicalwicket.ui.wicket.WicketApplication;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

/**
 * Simple test using the WicketTester
 */
public class TestHomePage {
    private WicketTester tester;

    @Before
    public void setUp() {
        tester = new WicketTester(new WicketApplication());
    }

    @Test
    public void rendersSuccessfully() {
        tester.startPage(HomePage.class);
        tester.assertRenderedPage(HomePage.class);
    }

    @Test
    public void hasTitle() {
        tester.startPage(HomePage.class);
        tester.assertLabel("title", "Home Page");
    }

    @Test
    public void navigateToRegistration() {
        tester.startPage(HomePage.class);
        tester.clickLink("registration");
        tester.assertLabel("title", "Registration");
    }
}
