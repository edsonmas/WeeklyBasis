package weeklyBasis.servicos;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import weeklyBasis.dominios.Evento;
import weeklyBasis.repositorio.EventoRepositorio;
import weeklyBasis.servicos.dto.EventoDTO;
import weeklyBasis.servicos.mapper.EventoMapper;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class EventoServico {

        private final EventoRepositorio repositorio;

        private final EventoMapper mapper;

        public EventoDTO buscarPorId(Long id){
            Evento eve = repositorio.findById(id).orElseThrow(() -> new EntityNotFoundException("Evento de id: "+id+" não existe"));
            return mapper.toDto(eve);
        }

        public List<EventoDTO> buscarTodos(){
            return mapper.toDto(repositorio.findAll());
        }

        public EventoDTO inserir(EventoDTO dto){
            Evento entity = mapper.toEntity(dto);
            entity = repositorio.save(entity);
            return mapper.toDto(entity);
        }

        public EventoDTO editar(EventoDTO dto, Long id){
            dto.setId(id);
            Evento entity = mapper.toEntity(dto);
            entity = repositorio.save(entity);
            return mapper.toDto(entity);
        }

        public void adiarEvento(Long id){
        }

    }

