package weeklyBasis.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import weeklyBasis.dominios.MotivoEvento;

@Repository
public interface MotivoEventoRepositorio extends JpaRepository<MotivoEvento, Long> {
}
