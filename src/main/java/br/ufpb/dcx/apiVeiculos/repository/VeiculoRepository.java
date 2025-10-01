package br.ufpb.dcx.apiVeiculos.repository;

import br.ufpb.dcx.apiVeiculos.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    boolean existsByChassi(String chassi);
}
