package br.ufpb.dcx.apiVeiculos.controller;

import br.ufpb.dcx.apiVeiculos.dto.VeiculoDTO;
import br.ufpb.dcx.apiVeiculos.mapper.VeiculoMapper;
import br.ufpb.dcx.apiVeiculos.model.Veiculo;
import br.ufpb.dcx.apiVeiculos.service.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api")
public class VeiculoController {
    private VeiculoMapper veiculoMapper;
    private VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService, VeiculoMapper veiculoMapper) {
        this.veiculoService = veiculoService;
        this.veiculoMapper = veiculoMapper;
    }

    @GetMapping(path = "/veiculos")
    public List<VeiculoDTO> listaTodosVeiculos() {
        return veiculoService.getVeiculos()
                .stream()
                .map(veiculo -> veiculoMapper.mapToDTO(veiculo))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/veiculos/{veiculoID}")
    public VeiculoDTO listaVeiculo(@PathVariable Long veiculoID) {
        Veiculo veiculo = veiculoService.getVeiculoById(veiculoID);
        return veiculoMapper.mapToDTO(veiculo);

    }

    @DeleteMapping(path = "/veiculos/{veiculoID}")
    @ResponseStatus(HttpStatus.OK)
    public void removeVeiculo(@PathVariable Long veiculoID) {
        veiculoService.removerVeiculo(veiculoID);
    }

    @PostMapping(path = "/veiculos")
    @ResponseStatus(HttpStatus.CREATED)
    public VeiculoDTO adicionarVeiculo(@Valid @RequestBody VeiculoDTO veiculoDTO) {
        Veiculo veiculo = veiculoMapper.mapToEntity(veiculoDTO);
        veiculoService.adicionarVeiculo(veiculo);
        return veiculoMapper.mapToDTO(veiculo);
    }

    @PutMapping(path = "/veiculos/{veiculoID}")
    public VeiculoDTO atualizaVeiculo(@Valid @PathVariable Long veiculoID, @RequestBody VeiculoDTO veiculoDTO) {
        Veiculo veiculo = veiculoMapper.mapToEntity(veiculoDTO);
        veiculoService.atualizarVeiculo(veiculoID, veiculo);
        return veiculoMapper.mapToDTO(veiculo);
    }

}
