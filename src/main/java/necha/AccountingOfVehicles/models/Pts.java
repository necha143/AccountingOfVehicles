package necha.AccountingOfVehicles.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "PTS")
@Getter
@Setter
public class Pts {
    @Id
    @Column(name = "UIN")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uin;

    @Column(name = "UNTS")
    @NotNull(message = "Учетный номер ТС не может быть пустым")
    private int unts;

    @ManyToOne
    @JoinColumn(name = "TID", referencedColumnName = "TID")
    @NotNull(message = "Тип ТС не может быть пустым")
    @JsonBackReference
    private TipTr tId;

    @ManyToOne
    @JoinColumn(name = "FIRMID", referencedColumnName = "FIRMID")
    @NotNull(message = "ТС должно пренадлежать какому-нибудь предприятию")
    @JsonIgnore
    private VFirm firmId;

    @Column(name = "GRP")
    @NotNull(message = "У ТС должна быть грузоподъемность")
    private int grp;

    @Column(name = "NORMT")
    @NotNull(message = "У ТС должен быть норматив расхода топлива")
    private int normT;

    @Column(name = "DATASP")
    private Date dataSp;
}
