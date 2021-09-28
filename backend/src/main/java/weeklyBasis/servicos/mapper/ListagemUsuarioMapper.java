package weeklyBasis.servicos.mapper;

import org.mapstruct.Mapper;
import weeklyBasis.dominios.Usuario;
import weeklyBasis.servicos.dto.ListagemUsuarioDTO;

@Mapper(componentModel = "spring", uses = CargoMapper.class)
public interface ListagemUsuarioMapper extends EntityMapper<ListagemUsuarioDTO, Usuario> {

}
