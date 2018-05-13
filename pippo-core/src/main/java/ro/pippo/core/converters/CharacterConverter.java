package ro.pippo.core.converters;

import ro.pippo.core.util.StringUtils;

public class CharacterConverter extends AbstractConverter<Character> {

    public CharacterConverter(Character defaultValue) {
        super(defaultValue);
    }

    @Override
    public Character convert(String value) {
        if (StringUtils.isNullOrEmpty(value)) {
            // TODO: isso é um comportamento da classe ParameterValue
            // o ideal seria retorna null e deixar para retornar o
            // defaultValue em caso de exceção
            return getDefaultValue();
        }

        return value.charAt(0);
    }

}
