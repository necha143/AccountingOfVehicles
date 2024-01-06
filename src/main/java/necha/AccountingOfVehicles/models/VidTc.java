package necha.AccountingOfVehicles.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "VIDTC")
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "vidT")
public class VidTc {
    @Id
    @Column(name = "VIDT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vidT;

    @Column(name = "SHNAME")
    @NotEmpty(message = "Краткое имя вида не может быть пустым")
    private String shName;

    @Column(name = "FULLNAME")
    private String fullName;

    @OneToMany(mappedBy = "vidT")
    private List<TipTr> tipesTr;

    @ManyToMany
    @JoinTable(
            name = "VFIRM_VIDTC",
            joinColumns = @JoinColumn(name = "VIDT"),
            inverseJoinColumns = @JoinColumn(name = "FIRMID")
    )
    @JsonBackReference
    private List<VFirm> vFirms;

    public VidTc() {
    }
}
