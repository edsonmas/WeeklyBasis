package weeklyBasis.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import weeklyBasis.servicos.EventoServico;
import weeklyBasis.servicos.dto.EventoDTO;
import weeklyBasis.servicos.dto.ListagemUsuarioDTO;
import weeklyBasis.servicos.dto.UsuarioDTO;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/evento")
@RequiredArgsConstructor
public class EventoRecurso {
    @Autowired
    private final EventoServico eventoServico;

    @GetMapping
    public ResponseEntity<List<EventoDTO>> eventoList(){
        return new ResponseEntity<>(eventoServico.buscarTodos(),HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<EventoDTO> eventoById(@PathVariable long id){
        return ResponseEntity.ok(eventoServico.usuarioById(id));
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        eventoServico.cadastrarUsuario(usuarioDTO);
        return ResponseEntity.created(URI.create("api/eventos"+usuarioDTO.getId())).build();
    }
}
