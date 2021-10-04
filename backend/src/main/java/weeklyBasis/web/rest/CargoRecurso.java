package weeklyBasis.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import weeklyBasis.servicos.CargoServico;
import weeklyBasis.servicos.dto.SelectDTO;

import java.util.List;

@RestController
@RequestMapping(path = "/api/cargos")
@RequiredArgsConstructor
public class CargoRecurso {

        private final CargoServico cargoServico;

    @GetMapping
    public ResponseEntity<List<SelectDTO>> usuarioList(){
        return ResponseEntity.ok(cargoServico.listaCargos());
    }
}
