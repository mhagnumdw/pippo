package ro.pippo.core.converters;

import ro.pippo.core.util.StringUtils;

public class ByteConverter extends AbstractConverter<Byte> {

    public ByteConverter(Byte defaultValue) {
        super(defaultValue);
    }

    @Override
    public Byte convert(String value) {
        if (StringUtils.isNullOrEmpty(value)) {
            // TODO: isso é um comportamento da classe ParameterValue
            // o ideal seria retorna null e deixar para retornar o
            // defaultValue em caso de exceção
            return getDefaultValue();
        }

        return Byte.parseByte(value);
    }

}
