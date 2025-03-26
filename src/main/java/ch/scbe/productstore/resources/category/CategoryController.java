package ch.scbe.productstore.resources.category;

import org.springframework.web.bind.annotation.*;
import ch.scbe.productstore.resources.category.dto.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryMapper categoryMapper;

    @GetMapping
    public List<CategoryShowDto> getAllCategories() {
        return categoryService.getAll().stream().map(categoryMapper::toShowDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CategoryShowDto getCategoryById(@PathVariable Long id) {
        return categoryMapper.toShowDto(categoryService.getById(id));
    }

    @PostMapping
    public CategoryShowDto createCategory(@RequestBody CategoryCreateDto dto) {
        Category category = categoryMapper.toEntity(dto);

        if (dto.getParentCategoryId() != null) {
            Category parent = categoryService.getById(dto.getParentCategoryId());
            category.setParentCategory(parent);
        }

        return categoryMapper.toShowDto(categoryService.create(category));
    }

    @PutMapping("{id}")
    public void updateCategory(@PathVariable Long id, @RequestBody CategoryCreateDto dto) {
        Category category = categoryService.getById(id);
        categoryMapper.update(dto, category);

        if (dto.getParentCategoryId() != null) {
            Category parent = categoryService.getById(dto.getParentCategoryId());
            category.setParentCategory(parent);
        }

        categoryService.update(id, category);
    }

    @DeleteMapping("{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
    }
}
