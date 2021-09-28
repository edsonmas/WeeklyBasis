package weeklyBasis.servicos.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListagemUsuarioDTO {

    private Long id;
    private String nome;
    private Boolean statusAtivo;
    private String email;
    private SelectDTO cargo;


}
