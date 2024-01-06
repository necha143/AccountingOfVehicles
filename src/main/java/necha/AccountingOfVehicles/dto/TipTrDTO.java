package necha.AccountingOfVehicles.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TipTrDTO {
    private int tId;

    @NotEmpty(message = "Имя типа не может быть пустым")
    private String tName;
}
