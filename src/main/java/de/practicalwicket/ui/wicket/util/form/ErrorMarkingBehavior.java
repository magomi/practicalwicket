package de.practicalwicket.ui.wicket.util.form;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.FormComponent;

/**
 * @author Bert.radke <bert.radke@t-systems.com>
 */
public class ErrorMarkingBehavior extends Behavior {


    @Override
    public void onComponentTag(Component component, ComponentTag tag) {

        if ( ! ((FormComponent)component).isValid()) {

            String oldValue = tag.getAttribute("class");
            if (oldValue == null) {
                tag.put("class", "error");
            } else {
                tag.put("class", "error " + oldValue);
            }
        }

    }
}
