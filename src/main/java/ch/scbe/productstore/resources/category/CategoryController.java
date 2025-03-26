package ch.scbe.productstore.resources.category;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @GetMapping("/categories/{id}")
    public String getCategory(@PathVariable String id) {
        return "Kategorie mit ID: " + id;
    }

    @GetMapping("/categories")
    public String getAllCategories() {
        return "Liste aller Kategorien";
    }

    @PostMapping("/categories")
    public String createCategory() {
        return "Neue Kategorie erstellt";
    }

    @PutMapping("/categories/{id}")
    public String updateCategory(@PathVariable String id) {
        return "Kategorie mit ID " + id + " aktualisiert";
    }

    @DeleteMapping("/categories/{id}")
    public String deleteCategory(@PathVariable String id) {
        return "Kategorie mit ID " + id + " gelöscht";
    }
}
