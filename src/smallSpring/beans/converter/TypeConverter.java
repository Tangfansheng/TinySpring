package smallSpring.beans.converter;

public interface TypeConverter {
    <T> T convertIfNecessary(Object value, Class<T> requiredType);
}
