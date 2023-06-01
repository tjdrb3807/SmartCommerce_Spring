package SmartCommerce.eCommerce.eventBanner;

import SmartCommerce.eCommerce.eventBanner.repository.EventBannerRepository;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class InitEventBannerDB {

    private final InitEventBannerService initEventBannerService;

    @PostConstruct
    private void init() { initEventBannerService.dbInit01(); }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitEventBannerService {
        private final EntityManager entityManager;
        public void dbInit01() {
            EventBanner[] eventBannerList = {
                    createEventBanner("쿠어 23S/S 리뷰 특별전", "https://image.msscdn.net/images/plan_w_mobile_img/2023030213534100000045627.jpg"),
                    createEventBanner("ON & OFF", "https://image.msscdn.net/images/img/2023022810090300000026210.jpg"),
                    createEventBanner("SW19 : White Day Gift", "https://image.msscdn.net/images/plan_w_mobile_img/2023030209151200000094708.jpg"),
                    createEventBanner("그란데라인 인기 아이템 단독 할인전", "https://image.msscdn.net/images/plan_w_mobile_img/2023021013325800000081529.jpg"),
                    createEventBanner("잇터 23SS 컬렉션 발매", "https://image.msscdn.net/images/plan_w_mobile_img/2023022110520900000093804.jpg"),
                    createEventBanner("세인제임스 봄 아우터 큐레이팅", "https://image.msscdn.net/images/plan_w_mobile_img/2023022717020500000046691.jpg"),
                    createEventBanner("쿠어 23S/S 리뷰 특별전", "https://image.msscdn.net/images/plan_w_mobile_img/2023030213534100000045627.jpg"),
                    createEventBanner("ON & OFF", "https://image.msscdn.net/images/img/2023022810090300000026210.jpg"),
            };

            for (EventBanner eventBanner : eventBannerList) { entityManager.persist(eventBanner); }
        }

        private EventBanner createEventBanner(String content, String thumbnailImageURL) {
            EventBanner eventBanner = new EventBanner();
            eventBanner.setContent(content);
            eventBanner.setThumbnailImageURL(thumbnailImageURL);

            return eventBanner;
        }
    }
}
