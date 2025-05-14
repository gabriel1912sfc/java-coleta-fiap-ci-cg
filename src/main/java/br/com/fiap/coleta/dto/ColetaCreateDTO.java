package br.com.fiap.coleta.dto;

import jakarta.validation.constraints.NotBlank;

public record ColetaCreateDTO(
        Long id,

        @NotBlank(message = "A data é obrigatória!")
        String dateColeta,

        @NotBlank(message = "O endereço é obrigatório!")
        String address,

        @NotBlank(message = "O tipo de resíduo é obrigatório!")
        String typeOfResidue

) {
}
