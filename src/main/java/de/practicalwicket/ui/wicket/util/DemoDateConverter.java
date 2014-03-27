package de.practicalwicket.ui.wicket.util;

import org.apache.wicket.util.convert.ConversionException;
import org.apache.wicket.util.convert.converter.AbstractConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by bert
 */
public class DemoDateConverter extends AbstractConverter<Date> {

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    @Override
    protected Class<Date> getTargetType() {
        return Date.class;
    }

    @Override
    public Date convertToObject(String value, Locale locale) throws ConversionException {
        try {
            return sdf.parse(value);
        } catch (ParseException e) {
            throw new ConversionException(e);
        }
    }

    @Override
    public String convertToString(Date value, Locale locale) {
        return sdf.format(value);
    }

}
