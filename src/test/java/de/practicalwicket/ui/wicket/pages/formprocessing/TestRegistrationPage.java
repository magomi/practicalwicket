package de.practicalwicket.ui.wicket.pages.formprocessing;

import de.practicalwicket.model.Registration;
import de.practicalwicket.ui.wicket.WicketApplication;
import org.apache.wicket.util.tester.FormTester;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the {@link de.practicalwicket.ui.wicket.pages.formprocessing.RegistrationPage}.
 */
public class TestRegistrationPage {
    private WicketTester tester;
    private FormTester formTester;

    @Before
    public void setUp() {
        tester = new WicketTester(new WicketApplication());
        tester.startPage(RegistrationPage.class);
        formTester = tester.newFormTester("form", false);
    }

    @Test
    public void rendersSuccessfully() {
        tester.startPage(RegistrationPage.class);
        tester.assertRenderedPage(RegistrationPage.class);
    }

    @Test
    public void formProcessionSucess() {
        formTester.setValue("email", "007@hmsc.uk");
        formTester.setValue("userName", "jbond");
        formTester.setValue("password", "verysecret");
        formTester.setValue("passwordRepeat", "verysecret");
        formTester.submit();
        tester.assertRenderedPage(RegistrationSuccess.class);
    }

    @Test
    public void invalidUsername() {
        formTester.setValue("email", "007@hmsc.uk");
        formTester.setValue("userName", "jb");
        formTester.setValue("password", "verysecret");
        formTester.setValue("passwordRepeat", "verysecret");
        formTester.submit();
        tester.assertRenderedPage(RegistrationPage.class);
        tester.assertErrorMessages("invalid user name: jb");
    }

}
