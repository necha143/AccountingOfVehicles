package necha.AccountingOfVehicles.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VFirmDTO {
    private int firmId;

    @NotEmpty(message = "Имя предприятия не может быть пустым")
    private String tlGr;
}
