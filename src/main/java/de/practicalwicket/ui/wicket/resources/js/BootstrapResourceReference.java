package de.practicalwicket.ui.wicket.resources.js;

import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.resource.JQueryResourceReference;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bert
 */
public class BootstrapResourceReference extends JavaScriptResourceReference {


    public BootstrapResourceReference() {
        super(BootstrapResourceReference.class, "bootstrap.js");
    }

    @Override
    public Iterable<? extends HeaderItem> getDependencies() {

        List<HeaderItem> dependencies = new ArrayList<HeaderItem>();

        dependencies.add(JavaScriptHeaderItem.forReference(JQueryResourceReference.get()));

        return dependencies;
    }
}
