package ch.scbe.productstore.resources.product;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ch.scbe.productstore.resources.product.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Tag(name = "Product Controller", description = "Controller for manage the products")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductShowDto> getAllProducts() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ProductDetailDto getProductById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @PostMapping
    public ProductShowDto createProduct(@RequestBody ProductCreateDto dto) {
        return productService.create(dto);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody ProductUpdateDto dto) {
        productService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.delete(id);
    }
}
