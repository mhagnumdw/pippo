package ro.pippo.core.converters;

import ro.pippo.core.PippoRuntimeException;
import ro.pippo.core.util.StringUtils;

public class EnumConverter<T extends Enum<?>> extends AbstractConverter<T> {

    private Class<T> enumType;
    private boolean caseSensitive;

    private EnumConverter(T defaultValue) {
        super(defaultValue);
        throw new PippoRuntimeException("Cannot be instantiated");
    }

    public EnumConverter(Class<T> enumType, T defaultValue, boolean caseSensitive) {
        super(defaultValue);
        this.enumType = enumType;
        this.caseSensitive = caseSensitive;
    }

    @Override
    public T convert(String value) {
        if (StringUtils.isNullOrEmpty(value)) {
            // TODO: isso é um comportamento da classe ParameterValue
            // o ideal seria retorna null e deixar para retornar o
            // defaultValue em caso de exceção
            return getDefaultValue();
        }

        int ordinal = Integer.MIN_VALUE;
        try {
            // attempt to interpret value as an ordinal
            ordinal = Integer.parseInt(value);
        } catch (Exception e) {
            // do nothing
        }

        T[] constants = enumType.getEnumConstants();
        for (T constant : constants) {
            if (constant.ordinal() == ordinal) {
                return constant;
            }
            if (caseSensitive) {
                if (constant.name().equals(value)) {
                    return constant;
                }
            } else {
                if (constant.name().equalsIgnoreCase(value)) {
                    return constant;
                }
            }
        }

        return getDefaultValue();
    }

}
