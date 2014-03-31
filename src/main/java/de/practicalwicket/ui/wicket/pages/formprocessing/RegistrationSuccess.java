package de.practicalwicket.ui.wicket.pages.formprocessing;

import de.practicalwicket.model.Registration;
import de.practicalwicket.ui.wicket.pages.general.BasePage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

/**
 * Created by bert
 */
public class RegistrationSuccess extends BasePage {


    public RegistrationSuccess(IModel<Registration> model) {
        super("Registration Success", model);
    }


    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new Label("userName"));
        add(new Label("email"));
        add(new Label("password"));
        add(new Label("spam"));

    }
}
