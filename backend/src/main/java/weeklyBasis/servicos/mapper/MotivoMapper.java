package weeklyBasis.servicos.mapper;

import org.mapstruct.Mapper;
import weeklyBasis.dominios.MotivoEvento;
import weeklyBasis.dominios.Usuario;
import weeklyBasis.servicos.dto.MotivoDTO;
import weeklyBasis.servicos.dto.UsuarioDTO;

@Mapper(componentModel = "spring")
public interface MotivoMapper extends EntityMapper<MotivoDTO, MotivoEvento>{
}
