package weeklyBasis.servicos;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import weeklyBasis.dominios.Usuario;
import weeklyBasis.repositorios.UsuarioRepositorio;
import weeklyBasis.servicos.dto.ListagemUsuarioDTO;
import weeklyBasis.servicos.dto.UsuarioDTO;
import weeklyBasis.servicos.excecao.EntityDisabledException;
import weeklyBasis.servicos.excecao.EntityNotFoundException;
import weeklyBasis.servicos.mapper.ListagemUsuarioMapper;
import weeklyBasis.servicos.mapper.UsuarioMapper;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class UsuarioServico {

    private final UsuarioMapper usuarioMapper;

    private final ListagemUsuarioMapper listagemUsuarioMapper;

    private final UsuarioRepositorio usuarioRepositorio;

    public List<ListagemUsuarioDTO> listaUsuarios(){
        List<Usuario> usuarioSalvo = usuarioRepositorio.findAll();
        return listagemUsuarioMapper.toDto(usuarioSalvo);
    }

    public UsuarioDTO usuarioById(long id){
        return usuarioMapper.toDto(usuarioRepositorio.findById(id).orElseThrow(()-> new EntityNotFoundException("user_id não encontrado")));
    }

    public UsuarioDTO cadastrarUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        usuario.setStatusAtivo(true);
        if(!usuarioRepositorio.existsByCpf(usuario.getCpf())){
            Usuario usuarioSalvo = usuarioRepositorio.save(usuario);
            return usuarioMapper.toDto(usuarioSalvo);
        }else {
            throw new EntityExistsException("Entidade ja Existe");
        }
    }

    public UsuarioDTO atualizarUsuario(UsuarioDTO usuarioDTO){
        UsuarioDTO usuarioParaAtualizar = usuarioById(usuarioDTO.getId());
        Usuario usuario = usuarioMapper.toEntity(usuarioParaAtualizar);
        return usuarioMapper.toDto(usuarioRepositorio.save(usuario));
    }


    public UsuarioDTO inativarPorId(long id){
        UsuarioDTO usuarioParaInativar = usuarioById(id);
        Usuario usuario = usuarioMapper.toEntity(usuarioParaInativar);
        if (!usuario.getStatusAtivo()){
            throw new EntityDisabledException("Este usuario ja esta desabilitado");
        }
        usuario.setStatusAtivo(false);
        usuarioRepositorio.save(usuario);
        return usuarioMapper.toDto(usuario);
    }



}
