package meli.dh.com.finalmeliproject.service.wareHouse;

import meli.dh.com.finalmeliproject.dto.ResponseDTO;
import meli.dh.com.finalmeliproject.exception.NotFoundExceptionImp;
import meli.dh.com.finalmeliproject.mocks.*;
import meli.dh.com.finalmeliproject.mocks.repo.WareHouseRepoMock;
import meli.dh.com.finalmeliproject.model.WareHouseCategory;
import meli.dh.com.finalmeliproject.repository.IWareHouseCategoryRepo;
import meli.dh.com.finalmeliproject.repository.IWareHouseProductRepo;
import meli.dh.com.finalmeliproject.repository.IWareHouseRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class WareHouseServiceTest {

    @InjectMocks
    private WareHouseService wareHouseService;

    @Mock
    private IWareHouseRepo wareHouseRepo;

    @Mock
    private IWareHouseProductRepo wareHouseProductRepo;

    @Mock
    private IWareHouseCategoryRepo wareHouseCategoryRepo;

    @Test
    void findWareHouseCategoryByWareHouseIdNotExist() {
        BDDMockito.when(
                wareHouseRepo.findById(ArgumentMatchers.anyString())
        ).thenReturn(WareHouseRepoMock.findByIdException());

        NotFoundExceptionImp exceptionImp = assertThrows(
                NotFoundExceptionImp.class,
                () -> {
                    WareHouseCategory wc = wareHouseService.findWareHouseCategoryByWareHouseId(GenerateWareHouseCategoryDTO.newWareHouseCategoryDTO());
                }
        );
    }

    @Test
    void findWareHouseCategoryByWareHouseId() {
        BDDMockito.when(
                wareHouseRepo.findById(ArgumentMatchers.anyString())
        ).thenReturn(WareHouseRepoMock.findById());

        WareHouseCategory wc = wareHouseService.findWareHouseCategoryByWareHouseId(GenerateWareHouseCategoryDTO.newWareHouseCategoryDTO());

        verify(wareHouseRepo, atLeastOnce()).findById(ArgumentMatchers.anyString());

    }

    @Test
    void saveAll() {
        BDDMockito.when(
                wareHouseProductRepo.saveAll(ArgumentMatchers.any())
        ).thenReturn(WareHouseRepoMock.saveAll());

        wareHouseService.saveAll(GenerateWareHouseProduct.newWareHouseProductList());

        verify(wareHouseProductRepo, atLeastOnce()).saveAll(ArgumentMatchers.any());

    }

    @Test
    void update() {
        BDDMockito.when(
                wareHouseCategoryRepo.save(ArgumentMatchers.any())
        ).thenReturn(WareHouseRepoMock.update());

        wareHouseService.update(GenerateWareHouseCategory.newWareHouseCategory());

        verify(wareHouseCategoryRepo, atLeastOnce()).save(ArgumentMatchers.any());

    }

    @Test
    void wareHouseExist() {
        BDDMockito.when(
                wareHouseRepo.findById(ArgumentMatchers.anyString())
        ).thenReturn(WareHouseRepoMock.exist());

        boolean exist = wareHouseService.wareHouseExist("WH-0001");

        verify(wareHouseRepo, atLeastOnce()).findById(GenerateWareHouse.newWareHouse().getId());
        assertThat(exist).isTrue();
    }

    @Test
    void wareHouseNotExist() {
        BDDMockito.when(
                wareHouseRepo.findById(ArgumentMatchers.anyString())
        ).thenReturn(WareHouseRepoMock.notExist());

        boolean exist = wareHouseService.wareHouseExist("WH-0001");

        verify(wareHouseRepo, atLeastOnce()).findById(GenerateWareHouse.newWareHouse().getId());
        assertThat(exist).isFalse();
    }
}
