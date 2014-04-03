package de.practicalwicket.ui.wicket.components;


import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.behavior.AbstractAjaxBehavior;
import org.apache.wicket.request.handler.resource.ResourceStreamRequestHandler;
import org.apache.wicket.util.resource.IResourceStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AjaxDownload extends AbstractAjaxBehavior {
    private final static Logger log = LoggerFactory.getLogger(AjaxDownload.class);

    public void initiate(AjaxRequestTarget target) {
        CharSequence url = getCallbackUrl();
        target.appendJavaScript("window.location.href='" + url + "'");
    }

    public void onRequest() {
        IResourceStream resourceStream = getResourceStream();
        if (null != resourceStream) {
            ResourceStreamRequestHandler requestHandler = new ResourceStreamRequestHandler(
                    getResourceStream(), getFileName());
            getComponent().getRequestCycle().scheduleRequestHandlerAfterCurrent(requestHandler);
        } else if (log.isDebugEnabled()) {
            log.debug("Got IResourceStream = null from getResourceStream(). Did not schedule download request handler.");
        }
    }

    protected String getFileName() {
        return null;
    }

    protected abstract IResourceStream getResourceStream();
}