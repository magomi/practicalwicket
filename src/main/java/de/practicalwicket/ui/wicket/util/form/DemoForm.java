package de.practicalwicket.ui.wicket.util.form;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.internal.HtmlHeaderContainer;
import org.apache.wicket.model.IModel;

/**
 * @author bert
 */
public class DemoForm<T> extends Form<T> {

    private final DemoFormVisitor visitor;

    public DemoForm(String id, IModel<T> model) {
        super(id, model);

        visitor = new DemoFormVisitor();

    }

    @Override
    protected void onBeforeRender() {
        super.onBeforeRender();

        visitFormComponents(visitor);

    }

    @Override
    public void renderHead(HtmlHeaderContainer container) {
        super.renderHead(container);

        container.getHeaderResponse().render(CssHeaderItem.forReference(new DemoFormCssReference()));

    }
}
