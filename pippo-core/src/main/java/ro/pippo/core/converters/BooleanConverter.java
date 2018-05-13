package ro.pippo.core.converters;

import ro.pippo.core.util.StringUtils;

//public class BooleanConverter implements Converter<Boolean> {
public class BooleanConverter extends AbstractConverter<Boolean> {

    public BooleanConverter(Boolean defaultValue) {
        super(defaultValue);
    }

    @Override
    public Boolean convert(String value) {
        if (StringUtils.isNullOrEmpty(value)) {
            // TODO: isso é um comportamento da classe ParameterValue
            // o ideal seria retorna null e deixar para retornar o
            // defaultValue em caso de exceção
            return getDefaultValue();
        }

        switch (value) {
        case "yes":
        case "on":
            return true;
        default:
            try {
                return Integer.parseInt(value) > 0;
            } catch (NumberFormatException e) {
                // NaN
            }

            return Boolean.parseBoolean(value);
        }
    }

}
