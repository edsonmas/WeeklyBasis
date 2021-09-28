package weeklyBasis.servicos.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatrocinadorDTO {

    private String nome;
    private String email;
    private SelectDTO cargo;

}
