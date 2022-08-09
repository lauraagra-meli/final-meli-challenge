package meli.dh.com.finalmeliproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import meli.dh.com.finalmeliproject.dto.InboundOrderDTO;
import meli.dh.com.finalmeliproject.mocks.GenerateInboundOrderDTO;
import meli.dh.com.finalmeliproject.model.InboundOrder;
import meli.dh.com.finalmeliproject.model.Representative;
import meli.dh.com.finalmeliproject.service.inbound.InboundService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;

@WebMvcTest(InboundOrderController.class)
class InboundOrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private InboundService service;

    @Test
    void saveInboundOrder() throws Exception {
        // testando comportamento do controller independente do retorno
        BDDMockito.given(service.save(ArgumentMatchers.any(InboundOrderDTO.class), ArgumentMatchers.anyLong()))
                .willAnswer((invocation) -> invocation.getArgument(0));

        InboundOrderDTO inboundOrder = GenerateInboundOrderDTO.newInboundOrderDTO();

        ResultActions response = mockMvc.perform(post("/api/v1/fresh-products/inboundorder")
                .content()
                .contentType(MediaType.APPLICATION_JSON)
        );
    }
}