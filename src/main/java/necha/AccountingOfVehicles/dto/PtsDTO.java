package necha.AccountingOfVehicles.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PtsDTO {
    @NotNull(message = "Учетный номер ТС не может быть пустым")
    private int unts;

    @NotNull(message = "Тип ТС не может быть пустым")
    private TipTrDTO tId;

    @NotNull(message = "ТС должно пренадлежать какому-нибудь предприятию")
    private VFirmDTO firmId;

    @NotNull(message = "У ТС должна быть грузоподъемность")
    private int grp;

    @NotNull(message = "У ТС должен быть норматив расхода топлива")
    private int normT;

    @Column(name = "DATASP")
    private Date dataSp;
}
