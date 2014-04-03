package de.practicalwicket.ui.wicket.util.form;

import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.util.visit.IVisit;
import org.apache.wicket.util.visit.IVisitor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Bert
 */
public class DemoFormVisitor implements IVisitor<FormComponent<?>,Void>, Serializable {

    private final Set<FormComponent> visited = new HashSet<FormComponent>();

    @Override
    public void component(FormComponent<?> component, IVisit<Void> visit) {

        if ( ! visited.contains(component)) {
            visited.add(component);
            component.add(new RequiredBorder());
            component.add(new ErrorMarkingBehavior());
        }

    }
}
