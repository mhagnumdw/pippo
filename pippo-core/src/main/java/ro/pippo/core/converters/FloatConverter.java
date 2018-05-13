package ro.pippo.core.converters;

import java.text.ParseException;

import ro.pippo.core.PippoRuntimeException;
import ro.pippo.core.util.StringUtils;

public class FloatConverter extends AbstractConverter<Float> {

    public FloatConverter(Float defaultValue) {
        super(defaultValue);
    }

    @Override
    public Float convert(String value) {
        if (StringUtils.isNullOrEmpty(value)) {
            // TODO: isso é um comportamento da classe ParameterValue
            // o ideal seria retorna null e deixar para retornar o
            // defaultValue em caso de exceção
            return getDefaultValue();
        }

        try {
            Number number = getDecimalFormat().parse(value);
            return number.floatValue();
        } catch (ParseException e) {
            throw new PippoRuntimeException(e, "Failed to parse '{}'", value);
        }
    }

}
