package meli.dh.com.finalmeliproject.service.representative;

import meli.dh.com.finalmeliproject.model.Representative;

public interface IRepresentativeService {

    Representative save(Representative representative);
    Representative findRepresentativeById(long id);
}
