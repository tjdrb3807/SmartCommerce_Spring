package SmartCommerce.eCommerce.category.service;

import SmartCommerce.eCommerce.category.Category;
import SmartCommerce.eCommerce.category.repositroy.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional
    public Long save(Category category) {
        categoryRepository.save(category);

        return category.getId();
    }

    public List<Category> findCategoryList() {
        return categoryRepository.findAll();
    }

    public Category findOne(Long categoryId) {
        return categoryRepository.findOne(categoryId);
    }
}
