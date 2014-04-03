package de.practicalwicket.ui.wicket.pages.formprocessing;

import de.practicalwicket.model.Registration;
import de.practicalwicket.ui.wicket.pages.general.BasePage;
import de.practicalwicket.ui.wicket.util.form.DemoForm;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.EmailTextField;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.validation.EqualPasswordInputValidator;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;

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


        FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
        add(feedbackPanel);

        DemoForm<Registration> form = new DemoForm<Registration>("form"
                , new CompoundPropertyModel<Registration>(new Registration())) {

            @Override
            protected void onSubmit() {
                super.onSubmit();

                setResponsePage(new RegistrationSuccess(getModel()));

            }
        };

        add(form);
        TextField<String> email = new EmailTextField("email");
        email.setRequired(true);

        form.add(email);
        TextField<String> userName = new TextField<String>("userName");
        userName.add(new StringIValidator());
        form.add(userName);

        PasswordTextField passwordField = new PasswordTextField("password");
        form.add(passwordField);
        PasswordTextField passwordRepeatField
                = new PasswordTextField("passwordRepeat", new PropertyModel<String>(this, "passwordRepeat"));
        passwordRepeatField.setRequired(true);
        form.add(passwordRepeatField);
        form.add(new EqualPasswordInputValidator(passwordField, passwordRepeatField));

        form.add(new CheckBox("spam"));


    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }


    /**
     * Demonstrates the usage of the IValidator.
     */
    private static class StringIValidator implements IValidator<String> {
        @Override
        public void validate(IValidatable<String> validatable) {
            if (validatable.getValue().length() < 4 ) {
                ValidationError validationError = new ValidationError().addKey("username.error");
                validationError.setVariable("userName", validatable.getValue());
                validatable.error(validationError);
            }
        }
    }
}
