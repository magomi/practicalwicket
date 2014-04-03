package de.practicalwicket.ui.wicket.utils;

import org.apache.wicket.util.lang.Bytes;
import org.apache.wicket.util.resource.IResourceStream;
import org.apache.wicket.util.resource.ResourceStreamNotFoundException;
import org.apache.wicket.util.time.Time;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

/**
 * ResourceStream that delivers a simple pdf.
 */
public class PdfResourceStream implements IResourceStream {


    @Override
    public String getContentType() {
        return "application/pdf";
    }

    @Override
    public InputStream getInputStream() throws ResourceStreamNotFoundException {
        return PdfResourceStream.class.getResourceAsStream("/JSD2014-Programm.pdf");
    }

    @Override
    public Bytes length() {
        return null;
    }

    @Override
    public void close() throws IOException {
    }

    @Override
    public Locale getLocale() {
        return null;
    }

    @Override
    public void setLocale(Locale locale) {

    }

    @Override
    public String getStyle() {
        return null;
    }

    @Override
    public void setStyle(String s) {

    }

    @Override
    public String getVariation() {
        return null;
    }

    @Override
    public void setVariation(String s) {

    }

    @Override
    public Time lastModifiedTime() {
        return null;
    }
}
