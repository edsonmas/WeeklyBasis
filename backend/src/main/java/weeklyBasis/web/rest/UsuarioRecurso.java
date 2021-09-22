package weeklyBasis.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import weeklyBasis.dominios.Usuario;
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
    public ResponseEntity<UsuarioDTO> cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        usuarioServico.cadastrarUsuario(usuarioDTO);
        return ResponseEntity.created(URI.create("api/usuarios"+usuarioDTO.getId())).build();
    }

}
