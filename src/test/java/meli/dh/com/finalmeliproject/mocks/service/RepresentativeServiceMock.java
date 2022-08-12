package meli.dh.com.finalmeliproject.mocks.service;

import meli.dh.com.finalmeliproject.mocks.GenerateRepresentative;
import meli.dh.com.finalmeliproject.model.Representative;

public class RepresentativeServiceMock {
    public static Representative findRepresentativeById(){
        return GenerateRepresentative.newRepresentative();
    }

    public static Representative findRepresentativeByIdEx(){
        Representative r = GenerateRepresentative.newRepresentative();
        r.getWareHouse().setId("UNAUTHORIZED");
        return r;
    }

}
