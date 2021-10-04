package weeklyBasis.servicos.mapper;

import org.mapstruct.Mapper;
import weeklyBasis.dominios.Evento;
import weeklyBasis.dominios.Usuario;
import weeklyBasis.servicos.dto.EventoDTO;
import weeklyBasis.servicos.dto.UsuarioDTO;

@Mapper(componentModel = "spring", uses = {MotivoMapper.class,PatrocinadorMapper.class})
public interface EventoMapper extends EntityMapper<EventoDTO, Evento>{
}
