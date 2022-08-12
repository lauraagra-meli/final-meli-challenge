package meli.dh.com.finalmeliproject.mocks;

import com.sun.xml.bind.v2.runtime.reflect.Lister;
import meli.dh.com.finalmeliproject.model.*;
import meli.dh.com.finalmeliproject.model.Package;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GenerateCategory {

    public static Category newCategoryToSave() {

        return Category.builder()
                .id(1)
                .categoryName("CONGELADO")
                .minTemperature(-90)
                .maxTemperature(0)
                .build();
    }
}
