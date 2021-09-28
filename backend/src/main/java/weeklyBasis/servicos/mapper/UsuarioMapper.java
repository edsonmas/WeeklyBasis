package weeklyBasis.servicos.mapper;

import org.mapstruct.Mapper;
import weeklyBasis.dominios.Usuario;
import weeklyBasis.servicos.dto.UsuarioDTO;

@Mapper(componentModel = "spring", uses = {CargoMapper.class})
public interface UsuarioMapper extends EntityMapper<UsuarioDTO, Usuario>{
}
