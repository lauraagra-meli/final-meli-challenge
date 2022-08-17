package meli.dh.com.finalmeliproject.service.batch;

import meli.dh.com.finalmeliproject.dto.InboundOrderDTO;
import meli.dh.com.finalmeliproject.exception.BadRequestExceptionImp;
import meli.dh.com.finalmeliproject.mocks.GenerateBatch;
import meli.dh.com.finalmeliproject.mocks.GenerateInboundOrderDTO;
import meli.dh.com.finalmeliproject.mocks.GenerateWareHouseCategory;
import meli.dh.com.finalmeliproject.mocks.repo.BatchRepoMock;
import meli.dh.com.finalmeliproject.mocks.service.WareHouseServiceMock;
import meli.dh.com.finalmeliproject.model.Batch;
import meli.dh.com.finalmeliproject.model.WareHouseCategory;
import meli.dh.com.finalmeliproject.repository.IBatchRepo;
import meli.dh.com.finalmeliproject.service.product.IProductService;
import meli.dh.com.finalmeliproject.service.wareHouse.IWareHouseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class BatchServiceTest {

    @InjectMocks
    private BatchService batchService;

    @Mock
    private IProductService productService;

    @Mock
    private IWareHouseService wareHouseService;

    @Mock
    private IBatchRepo batchRepo;

    @BeforeEach
    void setUp() {
        BDDMockito.when(
                batchRepo.save(ArgumentMatchers.any(Batch.class))
        ).thenReturn(BatchRepoMock.save());

        BDDMockito.when(
                batchRepo.findById(ArgumentMatchers.anyLong())
        ).thenReturn(BatchRepoMock.findById());

        BDDMockito.when(
                productService.saveAll(ArgumentMatchers.any(List.class))
        ).thenReturn(WareHouseServiceMock.saveAll());

        BDDMockito.when(
                wareHouseService.saveAll(ArgumentMatchers.any(List.class))
        ).thenReturn(WareHouseServiceMock.saveAll());

        BDDMockito.when(
                wareHouseService.update(ArgumentMatchers.any(WareHouseCategory.class))
        ).thenReturn(WareHouseServiceMock.update());
    }

    @Test
    void saveBatch() {

        InboundOrderDTO toSave = GenerateInboundOrderDTO.newInboundOrderDTO();
        WareHouseCategory wareHouseCategoryToSave = GenerateWareHouseCategory.newWareHouseCategory();

        Batch b = batchService.save(
                toSave,
                wareHouseCategoryToSave
        );

        assertThat(b.getId()).isEqualTo(1);
    }

    @Test
    void saveWhenBadRequestExceptionImpMaxTemp() {

        InboundOrderDTO toSave = GenerateInboundOrderDTO.newInboundOrderDTO();
        WareHouseCategory wareHouseCategoryToSave = GenerateWareHouseCategory.newWareHouseCategory();

        toSave.getBatchStock().get(1).setMaxTemperature(1);

        BadRequestExceptionImp exceptionImp = assertThrows(
                BadRequestExceptionImp.class,
                () -> {
                    Batch b = batchService.save(
                            toSave,
                            wareHouseCategoryToSave
                    );
                }
        );

        assertThat(exceptionImp.getMessage()).isEqualTo("Product not allowed in this category, not a proper max temperature.");

    }

    @Test
    void saveWhenBadRequestExceptionImpMinTemp() {
        InboundOrderDTO toSave = GenerateInboundOrderDTO.newInboundOrderDTO();
        WareHouseCategory wareHouseCategoryToSave = GenerateWareHouseCategory.newWareHouseCategory();

        toSave.getBatchStock().get(1).setMinimumTemperature(-91);

        BadRequestExceptionImp exceptionImp = assertThrows(
                BadRequestExceptionImp.class,
                () -> {
                    Batch b = batchService.save(
                            toSave,
                            wareHouseCategoryToSave
                    );
                }
        );

        assertThat(exceptionImp.getMessage()).isEqualTo("Product not allowed in this category, min temperature not compatible.");

    }

    @Test
    void saveWhenBadRequestExceptionImpDoesItFitStorageMax() {
        InboundOrderDTO toSave = GenerateInboundOrderDTO.newInboundOrderDTO();
        WareHouseCategory wareHouseCategoryToSave = GenerateWareHouseCategory.newWareHouseCategory();

        wareHouseCategoryToSave.setStorage(100);

        BadRequestExceptionImp exceptionImp = assertThrows(
                BadRequestExceptionImp.class,
                () -> {
                    Batch b = batchService.save(
                            toSave,
                            wareHouseCategoryToSave
                    );
                }
        );
        assertThat(exceptionImp.getMessage()).isEqualTo("The size of the category batch exceeds the limit of the warehouse.");
    }

    @Test
    void saveWhenBadRequestExceptionImpDoesItFit() {
        InboundOrderDTO toSave = GenerateInboundOrderDTO.newInboundOrderDTO();
        WareHouseCategory wareHouseCategoryToSave = GenerateWareHouseCategory.newWareHouseCategory();

        wareHouseCategoryToSave.setCapacity(1);

        BadRequestExceptionImp exceptionImp = assertThrows(
                BadRequestExceptionImp.class,
                () -> {
                    Batch b = batchService.save(
                            toSave,
                            wareHouseCategoryToSave
                    );
                }
        );
        assertThat(exceptionImp.getMessage()).isEqualTo("The size of the category batch exceeds the limit of the warehouse.");
    }

    @Test
    void findById() {
        batchService.findById(1);
        verify(batchRepo, atLeastOnce()).findById(GenerateBatch.newBatchToSave().getId());
    }
}
