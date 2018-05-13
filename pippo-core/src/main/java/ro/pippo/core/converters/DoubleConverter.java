package ro.pippo.core.converters;

import java.text.ParseException;

import ro.pippo.core.PippoRuntimeException;
import ro.pippo.core.util.StringUtils;

public class DoubleConverter extends AbstractConverter<Double> {

    public DoubleConverter(Double defaultValue) {
        super(defaultValue);
    }

    @Override
    public Double convert(String value) {
        if (StringUtils.isNullOrEmpty(value)) {
            // TODO: isso é um comportamento da classe ParameterValue
            // o ideal seria retorna null e deixar para retornar o
            // defaultValue em caso de exceção
            return getDefaultValue();
        }

        try {
            Number number = getDecimalFormat().parse(value);
            return number.doubleValue();
        } catch (ParseException e) {
            throw new PippoRuntimeException(e, "Failed to parse '{}'", value);
        }
    }

}
