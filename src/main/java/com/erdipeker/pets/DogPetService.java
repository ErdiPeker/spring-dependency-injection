package com.erdipeker.pets;

import org.springframework.stereotype.Service;

@Service
public class DogPetService implements PetService {
    @Override
    public String getPetType() {
        return "Dogs are the Best!";
    }
}
