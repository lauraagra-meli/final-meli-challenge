package meli.dh.com.finalmeliproject.service.representative;

import meli.dh.com.finalmeliproject.exception.NotFoundExceptionImp;
import meli.dh.com.finalmeliproject.mocks.GenerateRepresentative;
import meli.dh.com.finalmeliproject.model.Representative;
import meli.dh.com.finalmeliproject.repository.IRepresentativeRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RepresentativeServiceTest {

    @Mock
    private IRepresentativeRepo representativeRepo;

    @InjectMocks
    private RepresentativeService representativeService;

    @Test
    void saveNewRepresentative() {
        BDDMockito.when(representativeRepo.save(ArgumentMatchers.any()))
                .thenReturn(GenerateRepresentative.newRepresentative());

        Representative representative = GenerateRepresentative.newRepresentative();
        Representative savedRep = representativeService.save(representative);

        assertThat(savedRep.getId()).isEqualTo(representative.getId());
        assertThat(savedRep.getName()).isEqualTo(representative.getName());
        assertThat(savedRep.getWareHouse()).isNotNull();
        verify(representativeRepo, atLeastOnce()).save(representative);
    }

    @Test
    void findRepresentativeById() {
        BDDMockito.when(representativeRepo.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(GenerateRepresentative.getRepresentativeById()));

        Representative representative = GenerateRepresentative.newRepresentative();
        Representative savedRep = representativeService.findRepresentativeById(representative.getId());

        assertThat(savedRep.getId()).isNotNull();
        assertThat(savedRep.getId()).isPositive();
        verify(representativeRepo, atLeastOnce()).findById(ArgumentMatchers.anyLong());
    }

    @Test
    void throwRepresentativeException_whenCantFindRepresentativeByIdException() {
        BDDMockito.when(representativeRepo.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new RuntimeException());

        Assertions.assertThrows(NotFoundExceptionImp.class, () -> {
            representativeService.findRepresentativeById(anyLong());
        });
    }
}
