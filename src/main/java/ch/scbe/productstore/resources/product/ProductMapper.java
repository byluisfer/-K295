package ch.scbe.productstore.resources.product;

import ch.scbe.productstore.resources.product.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "sping")
public abstract class ProductMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "image", target = "image")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "stock", target = "stock")
    @Mapping(source = "sku", target = "sku")
    public abstract Product toEntity(ProductCreateDto productCreateDto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "price", target = "price")
    public abstract ProductShowDto toShowDto(Product product);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "image", target = "image")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "stock", target = "stock")
    @Mapping(source = "sku", target = "sku")
    @Mapping(source = "category.name", target = "categoryName")
    public abstract ProductDetailDto toDetailDto(Product product);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "image", target = "image")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "stock", target = "stock")
    @Mapping(source = "sku", target = "sku")
    public abstract void update(ProductUpdateDto productUpdateDto, @MappingTarget Product productToUpdate);
}
