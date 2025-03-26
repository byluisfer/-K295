package ch.scbe.productstore.resources.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product create(Product product) {
        return this.productRepository.save(product);
    }

    public Product getById(Long id) {
        return this.productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product with the id " + id + " not found"));
    }

    public List<Product> getAll() {
        return (List<Product>) this.productRepository.findAll();
    }

    public Product update(Long id, Product product) {
        Product existingProduct = this.productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product with the id " + id + " not found"));
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setImage(product.getImage());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStock(product.getStock());
        existingProduct.setSku(product.getSku());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setActive(product.getActive());

        return productRepository.save(existingProduct);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
