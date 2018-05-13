package ro.pippo.core.converters;

import java.text.DecimalFormat;
import java.util.Locale;

public abstract class AbstractConverter<T> implements Converter<T> {

    private T defaultValue;
    private Locale locale;

    public AbstractConverter(T defaultValue) {
        this.defaultValue = defaultValue;
        this.locale = Locale.getDefault();
    }

    protected T getDefaultValue() {
        return defaultValue;
    }

    protected DecimalFormat getDecimalFormat() {
        return (DecimalFormat) DecimalFormat.getInstance(locale);
    }

}
