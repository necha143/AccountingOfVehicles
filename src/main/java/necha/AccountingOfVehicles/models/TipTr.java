package necha.AccountingOfVehicles.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "TIPTR")
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "vidT")
public class TipTr {
    @Id
    @Column(name = "TID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tId;

    @Column(name = "TNAME")
    @NotEmpty(message = "Имя типа не может быть пустым")
    private String tName;

    @ManyToOne
    @JoinColumn(name = "VIDT", referencedColumnName = "VIDT")
    @NotNull(message = "Вид не может быть пустым")
    private VidTc vidT;

    @Column(name = "PRIZNGR")
    private String priznGr;

    @OneToMany(mappedBy = "tId")
    @JsonManagedReference
    private List<Pts> trasports;

    public TipTr() {
    }
}
