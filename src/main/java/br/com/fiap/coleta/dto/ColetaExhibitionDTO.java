package br.com.fiap.coleta.dto;

import br.com.fiap.coleta.model.Coleta;

public record ColetaExhibitionDTO(
        Long id,
        String dateColeta,
        String address,
        String typeOfResidue) {

    public ColetaExhibitionDTO (Coleta coleta) {
        this(
                coleta.getId(),
                coleta.getDateColeta(),
                coleta.getAddress(),
                coleta.getTypeOfResidue()
        );

    }

}
