package weeklyBasis.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import weeklyBasis.servicos.UsuarioServico;
import weeklyBasis.servicos.dto.ListagemUsuarioDTO;
import weeklyBasis.servicos.dto.UsuarioDTO;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioRecurso {

    @Autowired
    private final UsuarioServico usuarioServico;

    @GetMapping
    public ResponseEntity<List<ListagemUsuarioDTO>> usuarioList(){
        return new ResponseEntity<>(usuarioServico.listaUsuarios(), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<UsuarioDTO> usuarioById(@PathVariable long id){
        return ResponseEntity.ok(usuarioServico.usuarioById(id));
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastrarUsuario(@RequestBody UsuarioDTO usuarioSalvo){
        usuarioSalvo = usuarioServico.cadastrarUsuario(usuarioSalvo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuarioSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(usuarioSalvo);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@PathVariable long id,@RequestBody UsuarioDTO usuarioDTO){
        usuarioDTO.setId(id);
        usuarioServico.atualizarUsuario(usuarioDTO);
        return ResponseEntity.ok(usuarioDTO);
    }


    @PutMapping(value = "/inativar/{id}")
    public ResponseEntity<Void> inativarPorId(@PathVariable long id){
        usuarioServico.inativarPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
