package br.ufpb.dcx.apiVeiculos.dto;

import br.ufpb.dcx.apiVeiculos.validation.MarcaValida;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoDTO {

    @NotBlank(message = "A marca do veículo não pode estar vazia!")
    @NotNull(message = "A marca do veículo não pode ser nulo!")
    @Size(max = 25, message = "A marca do veículo não pode ter mais de 25 caracteres!")
    private String marca;

    @NotBlank(message = "O modelo do veículo não pode estar vazio!")
    @NotNull(message = "O modelo do veículo não pode ser nulo!")
    @Size(max = 25, message = "O modelo do veículo não pode ter mais de 25 caracteres!")
    private String modelo;

    @NotBlank(message = "O ano do veículo não pode estar vazio!")
    @NotNull(message = "O ano do veículo não pode ser nulo!")
    @Size(min = 4, max = 4, message = "O ano do veículo precisa ser no formato(AAAA)")
    private String ano;

    @Positive(message = "O preço do veículo não pode ser negativo ou zero!")
    @NotNull(message = "O preço não pode ser nulo!")
    private Double preco;

    @NotBlank(message = "A placa do veiculo não pode estar vázia!")
    private String placa;

    @NotBlank
    private String chassi;
}
