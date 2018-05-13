package ro.pippo.core.converters;

import ro.pippo.core.util.StringUtils;

public class IntegerConverter extends AbstractConverter<Integer> {

    public IntegerConverter(Integer defaultValue) {
        super(defaultValue);
    }

    @Override
    public Integer convert(String value) {
        if (StringUtils.isNullOrEmpty(value)) {
            // TODO: isso é um comportamento da classe ParameterValue
            // o ideal seria retorna null e deixar para retornar o
            // defaultValue em caso de exceção
            return getDefaultValue();
        }

        return Integer.parseInt(value);
    }

}
