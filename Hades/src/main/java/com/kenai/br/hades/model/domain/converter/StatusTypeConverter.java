package com.kenai.br.hades.model.domain.converter;

import com.kenai.br.hades.model.domain.StatusType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class StatusTypeConverter implements AttributeConverter<StatusType, String> {

    @Override
    public String convertToDatabaseColumn(StatusType attribute) {
        return attribute.getValue();
    }

    @Override
    public StatusType convertToEntityAttribute(String dbData) {
        return StatusType.getEnumValue(dbData);
    }
}
