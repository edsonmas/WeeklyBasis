package weeklyBasis.servicos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class UsuarioDTO {
        private Long id;

        private String nome;

        private String cpf;

        private String email;

        private SelectCargoDTO cargo;

        private LocalDate dataNascimento;


    }



