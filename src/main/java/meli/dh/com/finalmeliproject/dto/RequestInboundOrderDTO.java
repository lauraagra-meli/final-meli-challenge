package meli.dh.com.finalmeliproject.dto;

import lombok.*;

import javax.validation.Valid;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestInboundOrderDTO {
    private InboundOrderDTO inboundOrder;
}
