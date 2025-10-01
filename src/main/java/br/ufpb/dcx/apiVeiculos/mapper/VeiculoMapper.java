package br.ufpb.dcx.apiVeiculos.mapper;

import br.ufpb.dcx.apiVeiculos.dto.VeiculoDTO;
import br.ufpb.dcx.apiVeiculos.model.Veiculo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VeiculoMapper {
    private final ModelMapper modelMapper;

    public VeiculoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public VeiculoDTO mapToDTO(Veiculo veiculo) {
        return modelMapper.map(veiculo, VeiculoDTO.class);
    }

    public Veiculo mapToEntity(VeiculoDTO dto) {
        return modelMapper.map(dto, Veiculo.class);
    }
}
