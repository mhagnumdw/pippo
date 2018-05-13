package ro.pippo.core.converters;

import ro.pippo.core.util.StringUtils;

public class LongConverter extends AbstractConverter<Long> {

    public LongConverter(Long defaultValue) {
        super(defaultValue);
    }

    @Override
    public Long convert(String value) {
        if (StringUtils.isNullOrEmpty(value)) {
            // TODO: isso é um comportamento da classe ParameterValue
            // o ideal seria retorna null e deixar para retornar o
            // defaultValue em caso de exceção
            return getDefaultValue();
        }

        return Long.parseLong(value);
    }

}
