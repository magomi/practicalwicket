package de.practicalwicket.ui.wicket.pages.general;

import de.practicalwicket.ui.wicket.components.AjaxDownload;
import de.practicalwicket.ui.wicket.utils.PdfResourceStream;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.util.resource.IResourceStream;

/**
 * Created by bert
 */
public class BasePage extends WebPage {

    private final String title;

    public BasePage() {
        this.title = "no title";
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new Label("title", title));

        Form form = new Form("form");
        add(form);

        final AjaxDownload pdfDownload = new AjaxDownload() {
            @Override
            protected IResourceStream getResourceStream() {
                return new PdfResourceStream();
            }

            @Override
            protected String getFileName() {
                return "someFile.pdf";
            }
        };

        AjaxButton pdfButton = new AjaxButton("program") {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                pdfDownload.initiate(target);
            }
        };
        pdfButton.add(pdfDownload);
        form.add(pdfButton);
    }
}
