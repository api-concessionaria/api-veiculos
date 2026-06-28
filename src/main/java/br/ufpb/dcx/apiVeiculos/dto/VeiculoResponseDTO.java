package br.ufpb.dcx.apiVeiculos.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoResponseDTO {

    private Long veiculoID;

    private String marca;

    private String modelo;

    private String ano;

    private Double preco;

    private String placa;

    private String chassi;
}
