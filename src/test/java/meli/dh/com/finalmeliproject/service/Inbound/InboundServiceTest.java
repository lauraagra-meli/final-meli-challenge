package meli.dh.com.finalmeliproject.service.Inbound;

import meli.dh.com.finalmeliproject.dto.ResponseDTO;
import meli.dh.com.finalmeliproject.repository.IWareHouseRepo;
import meli.dh.com.finalmeliproject.service.Representative.IRepresentativeService;
import meli.dh.com.finalmeliproject.util.GenerateInboundOrderDTO;
import meli.dh.com.finalmeliproject.util.GenerateRepresentative;
import meli.dh.com.finalmeliproject.util.GenerateResponseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class InboundServiceTest {

 @InjectMocks
 private InboundService service;

 @Mock
 private IRepresentativeService representativeService;

 @Mock
 private IWareHouseRepo wareHouseRepo;



 @Test
 void save_saveProduct() {

  GenerateInboundOrderDTO inboundOrderDTO = new GenerateInboundOrderDTO();
  ResponseDTO inboundService = service.save(GenerateInboundOrderDTO.newInboundOrderDTO(),GenerateRepresentative.newRepresentative().getId());
  GenerateResponseDTO responseDTO = new GenerateResponseDTO();





 }





}
