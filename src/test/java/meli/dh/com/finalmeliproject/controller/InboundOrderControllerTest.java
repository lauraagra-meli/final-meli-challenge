package meli.dh.com.finalmeliproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import meli.dh.com.finalmeliproject.dto.InboundOrderDTO;
import meli.dh.com.finalmeliproject.dto.ResponseDTO;
import meli.dh.com.finalmeliproject.mocks.GenerateInboundOrderDTO;
import meli.dh.com.finalmeliproject.mocks.GenerateResponseDTO;
import meli.dh.com.finalmeliproject.service.inbound.InboundService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(InboundOrderController.class)
class InboundOrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private InboundService service;

    @Test
    void save_saveInboundOrder_whenNewInboundOrder() throws Exception {
        // testando comportamento do controller independente do retorno
        BDDMockito.given(service.save(ArgumentMatchers.any(InboundOrderDTO.class), ArgumentMatchers.anyLong()))
                .willAnswer((invocation) -> invocation.getArgument(0));

        ResponseDTO responseDTO = GenerateResponseDTO.newResponseDTO();

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/fresh-products/inboundorder")
                .content(objectMapper.writeValueAsString(responseDTO))
                .contentType(MediaType.APPLICATION_JSON)
        );

        response.andExpect(status().isCreated())
                .andExpect(jsonPath("$.batchStock", CoreMatchers.is(responseDTO.getBatchStock())));
    }
}