package SmartCommerce.eCommerce.eventBanner.repository;

import SmartCommerce.eCommerce.eventBanner.EventBanner;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EventBannerRepository {

    private final EntityManager entityManager;

    public List<EventBanner> findAll() {
        return entityManager.createQuery("select e from EventBanner e", EventBanner.class)
                .getResultList();
    }
}
