package ro.pippo.core.converters;

public interface Converter<T> {

    // public T convert(T type, Object value);
    // public T convert(Object value);
    public T convert(String value);

}
