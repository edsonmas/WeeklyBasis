package weeklyBasis.servicos.mapper;

import weeklyBasis.dominios.Evento;
import weeklyBasis.servicos.dto.EventoDTO;

import java.util.List;

public interface EventoMapper {

    EventoDTO toDto(Evento eve);

    Evento toEntity(EventoDTO dto);

    List<EventoDTO> toDto(List<Evento> all);
}
