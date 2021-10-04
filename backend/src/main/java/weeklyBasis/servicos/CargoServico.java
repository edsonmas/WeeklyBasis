package weeklyBasis.servicos;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import weeklyBasis.dominios.Cargo;
import weeklyBasis.repositorios.CargoRepositorio;
import weeklyBasis.servicos.dto.CargoDTO;
import weeklyBasis.servicos.dto.SelectDTO;
import weeklyBasis.servicos.mapper.CargoMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CargoServico {

    private final CargoRepositorio cargoRepositorio;

    private final CargoMapper cargoMapper;



    public List<SelectDTO> listaCargos(){
        List<Cargo> cargos = cargoRepositorio.findAll();
        return cargoMapper.toDto(cargos);
    }

}
