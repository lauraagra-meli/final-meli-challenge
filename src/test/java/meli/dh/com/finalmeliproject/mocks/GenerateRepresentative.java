package meli.dh.com.finalmeliproject.util;

import meli.dh.com.finalmeliproject.model.Representative;

public class GenerateRepresentative {

    public static Representative newRepresentative(){
        return Representative.builder()
                .id(2)
                .name("Pedro")
                .wareHouse(GenerateWareHouse.newWareHouse())
                .build();
    }
}
