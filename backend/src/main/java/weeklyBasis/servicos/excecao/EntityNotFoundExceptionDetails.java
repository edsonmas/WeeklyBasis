package weeklyBasis.servicos.excecao;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
public class EntityNotFoundExceptionDetails {
    private String title;
    private int status;
    private String details;
    private String developerMessage;
    private LocalDate timestamp;
}
