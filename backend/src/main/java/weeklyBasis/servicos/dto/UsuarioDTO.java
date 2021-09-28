package weeklyBasis.servicos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UsuarioDTO {

    private Long id;

    private String nome;

    private String cpf;

    private String email;

    private SelectDTO cargo;

    private LocalDate dataNascimento;

    private Boolean statusAtivo;
}


