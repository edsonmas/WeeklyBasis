package weeklyBasis.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import weeklyBasis.servicos.EventoServico;
import weeklyBasis.servicos.dto.EventoDTO;
import weeklyBasis.servicos.dto.ListagemUsuarioDTO;
import weeklyBasis.servicos.dto.UsuarioDTO;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/eventos")
@RequiredArgsConstructor
public class EventoRecurso {

    @Autowired
    private final EventoServico eventoServico;

    @GetMapping
    public ResponseEntity<List<EventoDTO>> eventoList(){
        return new ResponseEntity<>(eventoServico.listarEventos(), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<EventoDTO> eventoById(@PathVariable long id){
        return ResponseEntity.ok(eventoServico.eventoPorId(id));
    }

    @PostMapping
    public ResponseEntity<EventoDTO> cadastrarEvento(@RequestBody EventoDTO eventoCadastrado){
        eventoCadastrado = eventoServico.cadastrarEvento(eventoCadastrado);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(eventoCadastrado.getId()).toUri();
        return ResponseEntity.created(uri).body(eventoCadastrado);
    }
//
//    @PutMapping(path = "{id}")
//    public ResponseEntity<UsuarioDTO> atualizarUsuario(@PathVariable long id,@RequestBody UsuarioDTO usuarioDTO){
//        usuarioDTO.setId(id);
//        usuarioServico.atualizarUsuario(usuarioDTO);
//        return ResponseEntity.ok(usuarioDTO);
//    }
//
//
//    @PutMapping(value = "/inativar/{id}")
//    public ResponseEntity<Void> inativarPorId(@PathVariable long id){
//        usuarioServico.inativarPorId(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

}
