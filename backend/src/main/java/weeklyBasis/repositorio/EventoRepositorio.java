package weeklyBasis.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import weeklyBasis.dominios.Evento;

@Repository
public interface EventoRepositorio extends JpaRepository<Evento, Long> {

}
