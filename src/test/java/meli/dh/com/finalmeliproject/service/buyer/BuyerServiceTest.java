package meli.dh.com.finalmeliproject.service.buyer;

import meli.dh.com.finalmeliproject.mocks.GenerateBuyer;
import meli.dh.com.finalmeliproject.mocks.repo.BuyerRepoMock;
import meli.dh.com.finalmeliproject.repository.IBuyerRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class BuyerServiceTest {

    @InjectMocks
    private BuyerService buyerService;

    @Mock
    private IBuyerRepo buyerRepo;

    @Test
    void findById() {
        BDDMockito.when(
                buyerRepo.findById(ArgumentMatchers.anyLong())
        ).thenReturn(BuyerRepoMock.findById());

        buyerService.findById(1);

        verify(buyerRepo, atLeastOnce()).findById(GenerateBuyer.newBuyer().getId());
    }

    @Test
    void buyerExist() {
        BDDMockito.when(
                buyerRepo.findById(ArgumentMatchers.anyLong())
        ).thenReturn(BuyerRepoMock.exist());

        boolean exist = buyerService.buyerExist(1);

        verify(buyerRepo, atLeastOnce()).findById(GenerateBuyer.newBuyer().getId());
        assertThat(exist).isTrue();
    }

    @Test
    void buyerNotExist() {
        BDDMockito.when(
                buyerRepo.findById(ArgumentMatchers.anyLong())
        ).thenReturn(BuyerRepoMock.notExist());

        boolean exist = buyerService.buyerExist(1);

        verify(buyerRepo, atLeastOnce()).findById(GenerateBuyer.newBuyer().getId());
        assertThat(exist).isFalse();
    }
}
