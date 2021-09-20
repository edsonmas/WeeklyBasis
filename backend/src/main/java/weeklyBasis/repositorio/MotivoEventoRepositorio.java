package weeklyBasis.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotivoEventoRepositorio extends JpaRepository<MotivoEvento, Long> {

}
