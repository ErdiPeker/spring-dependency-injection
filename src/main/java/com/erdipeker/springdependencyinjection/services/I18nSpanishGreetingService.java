package com.erdipeker.springdependencyinjection.services;

import com.erdipeker.springdependencyinjection.repositories.SpanishGreetingRepository;

public class I18nSpanishGreetingService implements GreetingService{

    private final SpanishGreetingRepository spanishGreetingRepository;

    public I18nSpanishGreetingService(SpanishGreetingRepository spanishGreetingRepository) {
        this.spanishGreetingRepository = spanishGreetingRepository;
    }

    @Override
    public String sayGreeting() {
        return spanishGreetingRepository.getGreeting();
    }
}
