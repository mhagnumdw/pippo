package ro.pippo.core.converters;

import java.util.UUID;

import ro.pippo.core.util.StringUtils;

public class UUIDConverter extends AbstractConverter<UUID> {

    public UUIDConverter(UUID defaultValue) {
        super(defaultValue);
    }

    @Override
    public UUID convert(String value) {
        if (StringUtils.isNullOrEmpty(value)) {
            // TODO: isso é um comportamento da classe ParameterValue
            // o ideal seria retorna null e deixar para retornar o
            // defaultValue em caso de exceção
            return getDefaultValue();
        }

        return UUID.fromString(value);
    }

}
