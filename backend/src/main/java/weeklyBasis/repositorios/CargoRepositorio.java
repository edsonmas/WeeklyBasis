package weeklyBasis.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import weeklyBasis.dominios.Cargo;

@Repository
public interface CargoRepositorio extends JpaRepository<Cargo, Long> {
}
