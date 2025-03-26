package ch.scbe.productstore.resources.user;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @PostMapping("/login")
    public String login() {
        return "JWT-Token zurückgegeben";
    }

    @PostMapping("/register")
    public String register() {
        return "Neuer Benutzer registriert";
    }

    @PutMapping("/role/{id}")
    public String promoteUser(@PathVariable String id) {
        return "Benutzer mit ID " + id + " wurde zum Admin befördert";
    }
}
