package weeklyBasis.dominios;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
public class Evento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dt_evento")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dtEvento;

    @Column(name = "justificativa")
    private String justificativaAdiamento;

    private Double valor;

    @ManyToOne
    @JoinColumn(name = "motivo_evento_id")
    private MotivoEvento motivoEvento;

    @Column(name = "estado_fila")
    private SituacaoFila estado_fila;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "usuario_evento", joinColumns =
            {@JoinColumn(name = "evento_id")},
            inverseJoinColumns={@JoinColumn(name = "usuario_id")}
    )
    private List<Usuario> patrocinadores = new ArrayList<>();

}
