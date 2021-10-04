package weeklyBasis.servicos.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import weeklyBasis.dominios.MotivoEvento;
import weeklyBasis.servicos.dto.MotivoDTO;
import weeklyBasis.servicos.dto.SelectDTO;

@Mapper(componentModel = "spring")
public interface SelectMotivoMapper extends EntityMapper<SelectDTO, MotivoEvento>{

    @Mapping(source = "id", target = "value")
    @Mapping(source = "descricao", target = "label")
    SelectDTO toDto(MotivoEvento motivo);

    @InheritInverseConfiguration
    MotivoEvento toEntity(SelectDTO selectDTO);
}
