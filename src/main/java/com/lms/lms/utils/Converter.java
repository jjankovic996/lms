package com.lms.lms.utils;

public interface Converter<E, T> {

    /**
     * Converts entity to type.
     * @param entity - to be converted
     * @return - type that was created
     */
    T entityToType(E entity);

    /**
     * Converts type to entity.
     * @param type - type to be converted
     * @return - entity that was created
     */
    E typeToEntity(T type);

}
