package weeklyBasis.servicos;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import weeklyBasis.dominios.Cargo;
import weeklyBasis.repositorio.CargoRepositorio;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CargoServico{
@Autowired
private final CargoRepositorio cargoRepositorio;

    public List<Cargo> listaCargos(){
        return cargoRepositorio.findAll();
    }

}


