package com.kenai.br.hades.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractService {

    @Autowired
    ModelMapper modelMapper;

    /**
     * Convert a List<>T</> to theirs Destination Class
     * @param sources
     * @param destinationClass
     * @param <T>
     * @return
     */
    protected <T> List<T> map(List<?> sources, Class<T> destinationClass) {
        return sources.stream()
                      .map(source -> this.modelMapper
                                         .map(source, destinationClass))
                      .collect(Collectors.toList());
    }

    /**
     * Convert the given Object into the given Destination Class
     * @param source
     * @param destinationClass
     * @param <T>
     * @return
     */
    protected <T> T map(Object source, Class<T> destinationClass){
        return this.modelMapper
                   .map(source, destinationClass);
    }
}
