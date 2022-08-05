package meli.dh.com.finalmeliproject.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ResponseDTO {
    private List<BatchDTO> batchStock;
}
