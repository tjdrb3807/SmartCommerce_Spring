package SmartCommerce.eCommerce.category.repositroy;

import SmartCommerce.eCommerce.category.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CategoryRepository {
    private final EntityManager entityManager;

    public void save(Category category) {
        entityManager.persist(category);
    }

    public Category findOne(Long id) {
        return entityManager.find(Category.class, id);
    }

    public List<Category> findAll() {
        return entityManager.createQuery("select c from Category c", Category.class)
                .getResultList();
    }

    public List<Category> findByTitle(String title) {
        return entityManager.createQuery("select c from Category c where c.title = :title", Category.class)
                .setParameter("title", title)
                .getResultList();
    }
}
