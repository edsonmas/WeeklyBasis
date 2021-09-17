package weeklyBasis.dominio;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "data_evento")
    private LocalDate data_evento;

    @Column(name = "justificativa_adiantamento")
    private LocalDate justificativa_adiantamento;

    @Column(name = "valor")
    private Double valor;

}
