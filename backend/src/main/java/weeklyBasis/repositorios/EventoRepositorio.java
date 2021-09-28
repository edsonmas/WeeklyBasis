package weeklyBasis.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import weeklyBasis.dominios.Evento;

import java.time.LocalDate;

@Repository
public interface EventoRepositorio extends JpaRepository<Evento, Long> {

    boolean existsById(Long id);

    boolean existsByDtEvento(LocalDate dtEvento);

}
