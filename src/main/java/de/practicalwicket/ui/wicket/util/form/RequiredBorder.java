package de.practicalwicket.ui.wicket.util.form;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.border.BorderBehavior;
import org.apache.wicket.markup.html.form.FormComponent;

/**
 * @author Bert.radke <bert.radke@t-systems.com>
 */
public class RequiredBorder extends BorderBehavior {

    @Override
    public void afterRender(Component component) {

        if (((FormComponent)component).isRequired()) {
            super.afterRender(component);
        }

    }
}
