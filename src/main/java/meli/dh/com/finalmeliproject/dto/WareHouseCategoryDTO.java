package meli.dh.com.finalmeliproject.dto;

import lombok.*;

/***
 * Diz a categoria e armazem o lote vai
 */
@Getter @Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class WareHouseCategoryDTO {
    private String categoryName; //qual a categoria dos produtos desse lote
    private String wareHouseCode; //qual armazem que esse lote irá
}
