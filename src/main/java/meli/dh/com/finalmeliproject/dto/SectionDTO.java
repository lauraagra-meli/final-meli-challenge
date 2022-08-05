package meli.dh.com.finalmeliproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/***
 *
 */
@Getter @Setter
@NoArgsConstructor
public class SectionDTO {
    private String categoryName; //qual a categoria dos produtos desse lote
    private String wareHouseCode; //qual armazem que esse lote irá
}
