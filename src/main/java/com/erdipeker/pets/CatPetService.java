package com.erdipeker.pets;

import org.springframework.stereotype.Service;

@Service
public class CatPetService implements PetService {
    @Override
    public String getPetType() {
        return "Cats are the Best!";
    }
}