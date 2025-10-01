package br.ufpb.dcx.apiVeiculos.service;

import br.ufpb.dcx.apiVeiculos.exception.VeiculoAlreadyExistsException;
import br.ufpb.dcx.apiVeiculos.exception.VeiculoNotFoundException;
import br.ufpb.dcx.apiVeiculos.model.Veiculo;
import br.ufpb.dcx.apiVeiculos.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class VeiculoService {

    private VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public Veiculo adicionarVeiculo(Veiculo veiculo) {
        if(veiculoRepository.existsByChassi(veiculo.getChassi())) {
            throw new VeiculoAlreadyExistsException("Veiculo já existente!");
        }
        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> getVeiculos() {
        return veiculoRepository.findAll();
    }

    public Veiculo getVeiculoById(Long veiculoID) {
        return veiculoRepository.findById(veiculoID).orElseThrow(() -> new VeiculoNotFoundException("Veiculo não encontrado!"));
    }

    public Veiculo atualizarVeiculo(Long veiculoID, Veiculo veiculo) {
        Veiculo toUpdate = veiculoRepository.findById(veiculoID).orElseThrow(() -> new VeiculoNotFoundException("Veiculo não encontrado!"));
        toUpdate.setPlaca(veiculo.getPlaca());
        toUpdate.setMarca(veiculo.getMarca());
        toUpdate.setModelo(veiculo.getModelo());
        toUpdate.setAno(veiculo.getAno());
        toUpdate.setPreco(veiculo.getPreco());
        return veiculoRepository.save(toUpdate);
    }

    public void removerVeiculo(Long veiculoID) {
        Veiculo toRemove = veiculoRepository.findById(veiculoID).orElseThrow(() -> new VeiculoNotFoundException("Veiculo não encontrado!"));
        veiculoRepository.delete(toRemove);
    }
}
