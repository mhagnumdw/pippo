package ro.pippo.core.converters;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;

import ro.pippo.core.PippoRuntimeException;
import ro.pippo.core.util.StringUtils;

public class BigDecimalConverter extends AbstractConverter<BigDecimal> {

    public BigDecimalConverter(BigDecimal defaultValue) {
        super(defaultValue);
    }

    @Override
    public BigDecimal convert(String value) {
        if (StringUtils.isNullOrEmpty(value)) {
            // TODO: isso é um comportamento da classe ParameterValue
            // o ideal seria retorna null e deixar para retornar o
            // defaultValue em caso de exceção
            return getDefaultValue();
        }

        DecimalFormat formatter = getDecimalFormat();
        formatter.setParseBigDecimal(true);
        try {
            return (BigDecimal) formatter.parse(value);
        } catch (ParseException e) {
            throw new PippoRuntimeException(e, "Failed to parse '{}'", value);
        }
    }

}
