package meli.dh.com.finalmeliproject.service.inbound;

import meli.dh.com.finalmeliproject.dto.ResponseDTO;
import meli.dh.com.finalmeliproject.exception.NotFoundExceptionImp;
import meli.dh.com.finalmeliproject.exception.RepresentativeUnauthorizedException;
import meli.dh.com.finalmeliproject.mocks.GenerateInboundOrderDTO;
import meli.dh.com.finalmeliproject.mocks.repo.InboundOrderRepoMock;
import meli.dh.com.finalmeliproject.mocks.service.BatchServiceMock;
import meli.dh.com.finalmeliproject.mocks.service.RepresentativeServiceMock;
import meli.dh.com.finalmeliproject.mocks.service.WareHouseServiceMock;
import meli.dh.com.finalmeliproject.repository.IInboundOrderRepo;
import meli.dh.com.finalmeliproject.service.batch.IBatchService;
import meli.dh.com.finalmeliproject.service.representative.IRepresentativeService;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class InboundServiceTest {

    @InjectMocks
    private InboundService inboundService;

    @Mock
    private IInboundOrderRepo inboundOrderRepo;

    @Mock
    private IWareHouseService wareHouseService;

    @Mock
    private IRepresentativeService representativeService;

    @Mock
    private IBatchService batchService;

    @BeforeEach
    void setUp(){
        BDDMockito.when(
                wareHouseService.findWareHouseCategoryByWareHouseId(ArgumentMatchers.any())
        ).thenReturn(WareHouseServiceMock.findWareHouseCategoryByWareHouseId());

        BDDMockito.when(
                batchService.save(ArgumentMatchers.any(), ArgumentMatchers.any())
        ).thenReturn(BatchServiceMock.save());

        BDDMockito.when(
                inboundOrderRepo.save(ArgumentMatchers.any())
        ).thenReturn(InboundOrderRepoMock.save());

        BDDMockito.when(
                wareHouseService.wareHouseExist(ArgumentMatchers.anyString())
        ).thenReturn(WareHouseServiceMock.wareHouseExist("EXIST"));

        BDDMockito.when(
                representativeService.findRepresentativeById(ArgumentMatchers.anyLong())
        ).thenReturn(RepresentativeServiceMock.findRepresentativeById());
    }

    @Test
    void save() {

        ResponseDTO r = inboundService.save(GenerateInboundOrderDTO.newInboundOrderDTO(), 1);

        assertThat(r).isNotNull();
        verify(wareHouseService, atLeastOnce())
                .findWareHouseCategoryByWareHouseId(
                        ArgumentMatchers.any()
                );
        verify(batchService, atLeastOnce())
                .save(
                        ArgumentMatchers.any(),
                        ArgumentMatchers.any()
                );
        verify(inboundOrderRepo, atLeastOnce()).save(ArgumentMatchers.any());
    }

    @Test
    void update() {

        ResponseDTO r = inboundService.update(GenerateInboundOrderDTO.newInboundOrderDTO(), 1);

        assertThat(r).isNotNull();
        verify(batchService, atLeastOnce())
                .save(
                        ArgumentMatchers.any(),
                        ArgumentMatchers.any()
                );
        verify(wareHouseService, atLeastOnce())
                .findWareHouseCategoryByWareHouseId(
                        ArgumentMatchers.any()
                );
    }

    @Test
    void excpetion() {

        BDDMockito.when(
                wareHouseService.wareHouseExist(ArgumentMatchers.anyString())
        ).thenReturn(WareHouseServiceMock.wareHouseExist("NOT_EXIST"));

        NotFoundExceptionImp exceptionImp = assertThrows(
                NotFoundExceptionImp.class,
                () -> {
                    ResponseDTO r = inboundService.update(GenerateInboundOrderDTO.newInboundOrderDTO(), 1);
                }
        );
    }

    @Test
    void excpetionUnau() {

        BDDMockito.when(
                wareHouseService.findWareHouseCategoryByWareHouseId(ArgumentMatchers.any())
        ).thenReturn(WareHouseServiceMock.findWareHouseCategoryByWareHouseId());

        BDDMockito.when(
                batchService.save(ArgumentMatchers.any(), ArgumentMatchers.any())
        ).thenReturn(BatchServiceMock.save());

        BDDMockito.when(
                inboundOrderRepo.save(ArgumentMatchers.any())
        ).thenReturn(InboundOrderRepoMock.save());

        BDDMockito.when(
                wareHouseService.wareHouseExist(ArgumentMatchers.anyString())
        ).thenReturn(WareHouseServiceMock.wareHouseExist("EXIST"));

        BDDMockito.when(
                representativeService.findRepresentativeById(ArgumentMatchers.anyLong())
        ).thenReturn(RepresentativeServiceMock.findRepresentativeByIdEx());

        RepresentativeUnauthorizedException exceptionImp = assertThrows(
                RepresentativeUnauthorizedException.class,
                () -> {
                    ResponseDTO r = inboundService.update(GenerateInboundOrderDTO.newInboundOrderDTO(), 1);
                }
        );
    }
}
