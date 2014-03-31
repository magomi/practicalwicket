package de.practicalwicket.ui.wicket.pages.formprocessing;

import de.practicalwicket.model.Registration;
import de.practicalwicket.ui.wicket.pages.general.BasePage;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;

/**
 * Created by bert
 */
public class RegistrationPage extends BasePage {


    private String passwordRepeat;

    public RegistrationPage() {
        super("Registration");
    }


    @Override
    protected void onInitialize() {
        super.onInitialize();

        Form<Registration> form = new Form<Registration>("form"
                , new CompoundPropertyModel<Registration>(new Registration())) {
            @Override
            protected void onSubmit() {
                super.onSubmit();

                setResponsePage(new RegistrationSuccess(getModel()));

            }
        };

        add(form);
        form.add(new TextField<String>("email"));
        form.add(new TextField<String>("userName"));
        form.add(new PasswordTextField("password"));
        form.add(new PasswordTextField("passwordRepeat", new PropertyModel<String>(this, "passwordRepeat")));
        form.add(new CheckBox("spam"));

    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }
}
