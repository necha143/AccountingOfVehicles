package necha.AccountingOfVehicles.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "V_FIRM")
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "firmId")
public class VFirm {
    @Id
    @Column(name = "FIRMID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int firmId;

    @Column(name = "TLGR")
    @NotEmpty(message = "Имя предприятия не может быть пустым")
    private String tlGr;

    @Column(name = "DISLOC")
    @NotEmpty(message = "У предриятия должно быть местоположение")
    private String disLoc;

    @OneToMany(mappedBy = "firmId")
    @JsonIgnore
    private List<Pts> transports;

    @ManyToMany(mappedBy = "vFirms")
    @JsonManagedReference
    private List<VidTc> vidTcs;

    public VFirm() {
    }
}
