package de.practicalwicket.ui.wicket.pages.open;

import de.practicalwicket.ui.wicket.DemoSession;
import de.practicalwicket.ui.wicket.pages.general.BasePage;
import de.practicalwicket.ui.wicket.pages.secured.HomePage;
import de.practicalwicket.ui.wicket.util.form.DemoForm;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;

/**
 * Created by bert
 */
public class LoginPage extends BasePage {


    public String userName;
    public String password;



    public LoginPage() {
        super("Login");
    }


    @Override
    protected void onInitialize() {
        super.onInitialize();


        FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
        add(feedbackPanel);

        final DemoForm<LoginPage> form = new DemoForm<LoginPage>("form"
                , new CompoundPropertyModel<LoginPage>(LoginPage.this)) {

            @Override
            protected void onSubmit() {
                super.onSubmit();


                if ("wicket".equalsIgnoreCase(password)) {
                    DemoSession.get().login(userName);
                    setResponsePage(new HomePage());
                } else {
                    error("username or password wrong");
                }
            }
        };

        add(form);

        TextField<String> userName = new TextField<String>("userName");
        userName.setRequired(true);
        form.add(userName);

        PasswordTextField passwordField = new PasswordTextField("password");
        form.add(passwordField);

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
