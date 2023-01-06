package com.erdipeker.springdependencyinjection.repositories;

public class SpanishGreetingRepositoryImpl implements SpanishGreetingRepository {
    @Override
    public String getGreeting() {
        return "Hola Mundo -ES";
    }
}
