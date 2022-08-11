package meli.dh.com.finalmeliproject.mocks;

import meli.dh.com.finalmeliproject.model.Buyer;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;

public class GenerateBuyer {
    public static Buyer newBuyer(){
        return new Buyer(
                1,
                "Emerson"
        );
    }
}
