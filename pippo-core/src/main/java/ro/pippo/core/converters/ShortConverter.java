package ro.pippo.core.converters;

import ro.pippo.core.util.StringUtils;

public class ShortConverter extends AbstractConverter<Short> {

    public ShortConverter(Short defaultValue) {
        super(defaultValue);
    }

    @Override
    public Short convert(String value) {
        if (StringUtils.isNullOrEmpty(value)) {
            // TODO: isso é um comportamento da classe ParameterValue
            // o ideal seria retorna null e deixar para retornar o
            // defaultValue em caso de exceção
            return getDefaultValue();
        }

        return Short.parseShort(value);
    }

}
