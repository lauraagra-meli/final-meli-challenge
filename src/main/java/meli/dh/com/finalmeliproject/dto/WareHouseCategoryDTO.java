package meli.dh.com.finalmeliproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/***
 * Diz a categoria e armazem o lote vai
 */
@Getter @Setter
@NoArgsConstructor
public class WareHouseCategoryDTO {
    private String categoryName; //qual a categoria dos produtos desse lote
    private String wareHouseCode; //qual armazem que esse lote irá
}
