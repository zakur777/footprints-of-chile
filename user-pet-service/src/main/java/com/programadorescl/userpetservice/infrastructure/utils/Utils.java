package com.programadorescl.userpetservice.infrastructure.utils;

import lombok.*;

import java.util.stream.Collector;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
public class Utils {

    public static <T> Collector<T, ?, T> toSingleton() {
        return Collectors.collectingAndThen(
                Collectors.toList(),
                list -> {
                    if (list.size() != 1) {
                        throw new IllegalStateException();
                    }
                    return list.get(0);
                }
        );
    }
}
