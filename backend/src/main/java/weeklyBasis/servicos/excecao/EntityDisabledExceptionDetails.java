package weeklyBasis.servicos.excecao;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class EntityDisabledExceptionDetails {
    private String title;
    private int status;
    private String details;
    private String developerMessage;
    private LocalDate timestamp;
}
