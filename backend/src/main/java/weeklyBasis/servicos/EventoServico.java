package weeklyBasis.servicos;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import weeklyBasis.dominios.Evento;
import weeklyBasis.repositorios.EventoRepositorio;
import weeklyBasis.servicos.dto.EventoDTO;
import weeklyBasis.servicos.excecao.EntityNotFoundException;
import weeklyBasis.servicos.mapper.EventoMapper;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EventoServico {

    private final EventoRepositorio eventoRepositorio;

    private final EventoMapper eventoMapper;

    public List<EventoDTO> listarEventos(){
        return eventoMapper.toDto(eventoRepositorio.findAll());
    }

    public EventoDTO eventoPorId(long id){
        return eventoMapper.toDto(eventoRepositorio.findById(id).orElseThrow(()-> new EntityNotFoundException("user_id não encontrado")));
    }

    public EventoDTO cadastrarEvento(EventoDTO eventoDTO){
        eventoRepositorio.existsByDtEvento(eventoDTO.getDtEvento());
        Evento eventoCadastrado = eventoMapper.toEntity(eventoDTO);
        if (!eventoRepositorio.existsByDtEvento(eventoDTO.getDtEvento())){
            Evento eventoRetornado = eventoRepositorio.save(eventoCadastrado);
            return eventoMapper.toDto(eventoRetornado);
        } throw new EntityExistsException("Já existe um evento neste dia");
    }


}
