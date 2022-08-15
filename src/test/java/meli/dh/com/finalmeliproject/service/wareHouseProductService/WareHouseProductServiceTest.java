package meli.dh.com.finalmeliproject.service.wareHouseProductService;

import meli.dh.com.finalmeliproject.mocks.repo.BatchRepoMock;
import meli.dh.com.finalmeliproject.repository.IBatchRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class WareHouseProductServiceTest {

    @InjectMocks
    private WareHouseProductService wareHouseProductService;

    @Mock
    private IBatchRepo batchRepo;

    @Test
    void allProducts() {
        BDDMockito.when(
                batchRepo.findById(anyString())
        ).thenReturn(
                BatchRepoMock.findByIdAllProducts()
        );

        wareHouseProductService.allProducts("TEST");

        verify(batchRepo).findById(anyString());
    }
}
