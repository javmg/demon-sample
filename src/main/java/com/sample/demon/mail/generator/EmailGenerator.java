package com.sample.demon.mail.generator;

import com.sample.demon.mail.view.Email;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface EmailGenerator<T> {

    Email generate(T criteria);

    default List<Email> generateMany(Collection<T> collection){

        return collection.stream()
                .map(this::generate)
                .collect(Collectors.toList());
    }
}
