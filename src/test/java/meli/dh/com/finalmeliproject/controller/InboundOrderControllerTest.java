package meli.dh.com.finalmeliproject.controller;

import meli.dh.com.finalmeliproject.dto.InboundOrderDTO;
import meli.dh.com.finalmeliproject.dto.RequestInboundOrderDTO;
import meli.dh.com.finalmeliproject.dto.ResponseDTO;
import meli.dh.com.finalmeliproject.mocks.GenerateRequestInboundOrderDTO;
import meli.dh.com.finalmeliproject.mocks.GenerateResponseDTO;
import meli.dh.com.finalmeliproject.service.inbound.IInboundService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class InboundOrderControllerTest {

    @InjectMocks
    private InboundOrderController inboundOrderController;

    @Mock
    private IInboundService service;

    @Test
    void save_saveInboundOrder_whenNewInboundOrder() throws Exception {
        BDDMockito.when(service.save(ArgumentMatchers.any(InboundOrderDTO.class), ArgumentMatchers.anyLong()))
                .thenReturn(GenerateResponseDTO.newResponseDTO());

        InboundOrderDTO inboundOrderDTO = new InboundOrderDTO();
        RequestInboundOrderDTO newInboundOrder = GenerateRequestInboundOrderDTO.newRequestInboundOrderToSave();
        ResponseEntity<ResponseDTO> response = inboundOrderController.saveInboundOrder(newInboundOrder, 1);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();

        //verify(service, atLeastOnce()).save(inboundOrderDTO, 1);
    }

    @Test
    void update_updateInboundOrder_whenInboundOrderExist() {
        BDDMockito.when(service.update(ArgumentMatchers.any(InboundOrderDTO.class), ArgumentMatchers.anyLong()))
                .thenReturn(GenerateResponseDTO.newResponseDTO());

        InboundOrderDTO inboundOrderDTO = new InboundOrderDTO();
        RequestInboundOrderDTO newInboundOrder = GenerateRequestInboundOrderDTO.newRequestInboundOrderToSave();
        ResponseEntity<ResponseDTO> response = inboundOrderController.updateInboundOrder(newInboundOrder, 1);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();

        //verify(service, atLeastOnce()).update(any(), 1);
    }
}