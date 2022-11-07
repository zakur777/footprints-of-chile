package com.programadorescl.userpetservice.commons;

public interface UseCase<Input, Output> {
    Output execute(Input input) throws Exception;
}
