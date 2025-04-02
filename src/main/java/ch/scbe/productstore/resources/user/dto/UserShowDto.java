package ch.scbe.productstore.resources.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO used to show a user")
public class UserShowDto {

    @Schema(description = "ID of the user", example = "1")
    private Long id;

    @Schema(description = "Username of the user", example = "Luisfer")
    private String username;

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
