package br.com.fiap.coleta.dto;

import br.com.fiap.coleta.model.User;

public record UserExhibitionDTO(
        Long userID,
        String name,
        String email) {

    public UserExhibitionDTO(User user) {
        this(
                user.getUserId(),
                user.getName(),
                user.getEmail());
    }
}
