package ch.scbe.productstore.resources.category;

import ch.scbe.productstore.resources.category.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "active", target = "active")
    public abstract Category toEntity(CategoryCreateDto categoryCreateDto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    public abstract CategoryShowDto toShowDto(Category category);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "active", target = "active")
    public abstract void update(CategoryCreateDto categoryCreateDto, @MappingTarget Category categoryToUpdate);
}
