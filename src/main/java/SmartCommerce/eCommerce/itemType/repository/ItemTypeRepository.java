package SmartCommerce.eCommerce.itemType.repository;

import SmartCommerce.eCommerce.itemType.ItemType;
import SmartCommerce.eCommerce.itemType.controller.ItemTypeController;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemTypeRepository {

    private final EntityManager entityManager;

    public void save(ItemType itemType) {
        entityManager.persist(itemType);
    }

    public ItemType findOne(Long id) {
        return entityManager.find(ItemType.class, id);
    }

    public List<ItemType> findAllWithCategory() {
        return entityManager.createQuery(
                        "select it from ItemType it", ItemType.class)
                .getResultList();
    }
}
