package SmartCommerce.eCommerce.eventIcon.repository;

import SmartCommerce.eCommerce.eventIcon.EventIcon;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EventIconRepository {

    private final EntityManager entityManager;

    public void save(EventIcon eventIcon) { entityManager.persist(eventIcon); }

    public List<EventIcon> findAll() {
        return entityManager.createQuery("select e from EventIcon e", EventIcon.class)
                .getResultList();
    }
}
