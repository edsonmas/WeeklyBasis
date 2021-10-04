package weeklyBasis.servicos.mapper;

import org.mapstruct.Mapper;
import weeklyBasis.dominios.Usuario;
import weeklyBasis.servicos.dto.PatrocinadorDTO;
import weeklyBasis.servicos.dto.UsuarioDTO;

@Mapper(componentModel = "spring", uses = {CargoMapper.class})
public interface PatrocinadorMapper extends EntityMapper<PatrocinadorDTO, Usuario>{
}
