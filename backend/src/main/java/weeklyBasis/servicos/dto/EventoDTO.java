package weeklyBasis.servicos.dto;


import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class EventoDTO {
     private long id;

     private String justificativa;

     private Double valor;

     private LocalDate dt_evento;


}
