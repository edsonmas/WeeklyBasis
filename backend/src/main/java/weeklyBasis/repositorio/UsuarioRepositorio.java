package weeklyBasis.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    String existsByCp(String cpf);
}
