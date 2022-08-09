package meli.dh.com.finalmeliproject.service.Representative;

import meli.dh.com.finalmeliproject.repository.IRepresentativeRepo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

class RepresentativeServiceTest {

    @InjectMocks
    private RepresentativeService representativeService;

    @Mock
    private IRepresentativeRepo representativeRepo;

//    @Test
//    void findRepresentativeById() {
//        BDDMockito.when(representativeRepo.findById());
//    }
}
