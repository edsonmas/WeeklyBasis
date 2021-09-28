package weeklyBasis.servicos.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import weeklyBasis.dominios.Usuario;
import weeklyBasis.dominios.enums.SituacaoFila;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EventoDTO implements Serializable {

    private Long id;

    private LocalDate dtEvento;

    private String justificativaAdiamento;

    private Double valor;

    private SituacaoFila estadoFila;

    private SelectDTO motivo;

    private List<PatrocinadorDTO> patrocinadores = new ArrayList<>();

}
