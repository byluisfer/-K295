package ch.scbe.productstore.resources.product;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {
    @GetMapping("/products/{id}")
    public String getProduct(@PathVariable String id) {
        return "Produkt mit ID: " + id;
    }

    @GetMapping("/products")
    public String getAllProducts() {
        return "Liste aller Produkte";
    }

    @PostMapping("/products")
    public String createProduct() {
        return "Neues Produkt erstellt";
    }

    @PutMapping("/products/{id}")
    public String updateProduct(@PathVariable String id) {
        return "Produkt mit ID " + id + " aktualisiert";
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable String id) {
        return "Produkt mit ID " + id + " gelöscht";
    }
}
