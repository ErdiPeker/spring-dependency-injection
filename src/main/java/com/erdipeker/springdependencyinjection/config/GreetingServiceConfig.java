package com.erdipeker.springdependencyinjection.config;

import com.erdipeker.springdependencyinjection.repositories.EnglishGreetingRepository;
import com.erdipeker.springdependencyinjection.repositories.EnglishGreetingRepositoryImpl;
import com.erdipeker.springdependencyinjection.repositories.SpanishGreetingRepository;
import com.erdipeker.springdependencyinjection.repositories.SpanishGreetingRepositoryImpl;
import com.erdipeker.springdependencyinjection.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {



    @Bean
    ConstructorGreetingService constructorGreetingService(){
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }

    @Bean
    @Primary
    PrimaryGreetingService primaryGreetingService(){ return new PrimaryGreetingService();}

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }
    @Profile("EN")
    @Bean("i18nService")
    I18nEnglishGreetingService i18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository){ return new I18nEnglishGreetingService(englishGreetingRepository);}

    @Bean
    SpanishGreetingRepository spanishGreetingRepository(){
        return new SpanishGreetingRepositoryImpl();
    }

    @Profile({"ES","default"})
    @Bean("i18nService")
    I18nSpanishGreetingService i18nSpanishGreetingService(SpanishGreetingRepository spanishGreetingRepository){ return new I18nSpanishGreetingService(spanishGreetingRepository);}
}
