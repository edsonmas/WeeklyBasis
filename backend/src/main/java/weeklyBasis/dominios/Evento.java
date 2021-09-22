package weeklyBasis.dominios;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import weeklyBasis.dominios.enums.SituacaoFila;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Evento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dt_evento")
    private LocalDate dtEvento;

    @Column(name = "justificativa")
    private String justificativaAdiamento;

    private Double valor;

    private SituacaoFila codigoSituacao;

    @ManyToMany(mappedBy = "eventos")
    private List<Usuario> usuarios = new ArrayList<>();

}
