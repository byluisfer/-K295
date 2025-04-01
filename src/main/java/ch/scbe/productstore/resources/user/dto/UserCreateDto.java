package ch.scbe.productstore.resources.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO used to create a new user")
public class UserCreateDto {

    @Schema(description = "Username for the user", example = "Luisfer")
    private String username;

    @Schema(description = "Password for the user", example = "123")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
