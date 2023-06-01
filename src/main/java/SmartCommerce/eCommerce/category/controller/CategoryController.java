package SmartCommerce.eCommerce.category.controller;

import SmartCommerce.eCommerce.category.Category;
import SmartCommerce.eCommerce.category.repositroy.CategoryRepository;
import SmartCommerce.eCommerce.eventIcon.EventIcon;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @PostMapping("/commerce/api/v1/category")
    public HashMap<String, List<CategoryDTO>> categories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDTO> result = categories.stream()
                .map(c -> new CategoryDTO(c))
                .collect(Collectors.toList());

        HashMap<String, List<CategoryDTO>> hashMap = new HashMap<>();
        hashMap.put("documents", result);

        return hashMap;
    }
    @Data
    static class CategoryDTO {
        private Long category_id;
        private String category_title;


        public CategoryDTO(Category category) {
            this.category_id = category.getId();
            this.category_title = category.getTitle();
        }
    }
}
