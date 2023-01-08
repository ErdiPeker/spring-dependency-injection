package com.erdipeker.springdependencyinjection.config;


import com.erdipeker.pets.PetService;
import com.erdipeker.pets.PetServiceFactory;
import com.erdipeker.springdependencyinjection.datasource.FakeDataSource;
import com.erdipeker.springdependencyinjection.repositories.EnglishGreetingRepository;
import com.erdipeker.springdependencyinjection.repositories.EnglishGreetingRepositoryImpl;
import com.erdipeker.springdependencyinjection.repositories.SpanishGreetingRepository;
import com.erdipeker.springdependencyinjection.repositories.SpanishGreetingRepositoryImpl;
import com.erdipeker.springdependencyinjection.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;


@PropertySource("classpath:datasource.properties")
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(@Value("${com.username}")String username,@Value("${com.password}")String password,@Value("${com.jdbcurl}") String jdbcurl){
        FakeDataSource fakeDataSource=new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setJdbcurl(jdbcurl);
        fakeDataSource.setPassword(password);

        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }

    @Bean
    @Profile({"dog","default"})
    PetService dogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }

    @Bean
    @Profile({"cat"})
    PetService catPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat");
    }

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
