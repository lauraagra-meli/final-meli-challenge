package meli.dh.com.finalmeliproject.dto;

import lombok.*;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestInboundOrderDTO {
    private InboundOrderDTO inboundOrder;
}
