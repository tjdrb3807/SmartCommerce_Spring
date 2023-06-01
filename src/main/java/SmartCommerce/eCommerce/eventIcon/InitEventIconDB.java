package SmartCommerce.eCommerce.eventIcon;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class InitEventIconDB {
    private final InitEventIconService initEventIconService;

    @PostConstruct
    private void init() { initEventIconService.dbInit01(); }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitEventIconService {
        private final EntityManager entityManager;

        public void dbInit01() {
            EventIcon[] eventIconList = {
                    createEventIcon("럭셔리",
                            "https://image.msscdn.net/mfile_s01/_lookbook/list63f2d10b7f7ec",
                            "https://image.msscdn.net/images/event_banner/2022091316493400000037242.png"),
                    createEventIcon("뷰티",
                            "https://image.msscdn.net/images/goods_img/20230102/3002829/3002829_16726343803772_500.jpg",
                            "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTFr438zqpO3qp7jKQM3lsui_JLXzmAhQr36oaESzH4BtIhVHfr"),
                    createEventIcon("스포츠",
                            "https://image.msscdn.net/mfile_s01/_lookbook/list63f2fe3edbdb2",
                            "https://lh3.googleusercontent.com/IMqAmHFBD03_soZg3kBEDzrw3a-pCsWWix7XGVf5hz4HtyXHQgZuphZAPBkp4e3FNr1dDnl2j45XS4fviqGYuSSsnEINkMstDSejmyI"),
                    createEventIcon("아울렛",
                            "https://image.msscdn.net/mfile_s01/2023/02/16/thumb.163edc4dbcb3f6.jpg.0",
                            "https://lh3.googleusercontent.com/K6ffp1YB9BFJx-bLynn79BkeSV5WOOlGat-UtKbAjJeAJJpFdPwWS1SxStLHyruj93yJGARAz4sPrHtTvJFlJUbfBS53CQWOkbmBxrqGBQ"),
                    createEventIcon("키즈",
                            "https://image.msscdn.net/images/brand_event/2023021715431800000074564.jpg",
                            "https://lh3.googleusercontent.com/K3LY1Jwlb5wODOCfzhiV6RM5AhkGebCecjrNmycbXyF6Zk4w2lPovCgTZxPxiVME4sKGMWinuZXSqcZ6so-U3qRlcPjU5l8J3Ul5V9g"),
                    createEventIcon("골프",
                            "https://image.msscdn.net/images/brand_event/2023021515283300000016310.jpg",
                            "https://lh3.googleusercontent.com/5H5wGNvV_rISCPV9QNOKG1tJwBRwuLfIXK3MpkgJ9jc9fSYHdlgvjM2K8RYefa-QG14fYssJMk1uKAwnxTBqpn3MnAQhNzD7tJOHTfns"),
                    createEventIcon("어스",
                            "https://image.msscdn.net/images/goods_img/20220921/2806759/2806759_2_220.jpg",
                            "https://lh3.googleusercontent.com/sgI_T93zo3o69RZciwhgYg0Xk3z2LlhOjxN9MZ3FuEN6CQOAVzNuMluSAjphw5W0w7xnIXzmufPHGdnuv45ihWQ_Df443YokOoYBgjwJ"),
                    createEventIcon("봄 아우터",
                            "https://image.msscdn.net/images/brand_event/2023021715431800000074564.jpg",
                            "https://lh3.googleusercontent.com/1j_pn1HlDE_zJPo_n04J_kvUHkAttdQPGApyL2JC96TzLqSDz34fEsPdau2IrAD-j-TBHnBctTxH31VwrHfLtazQlXblBrmGeGcvw0-HPw"),
                    createEventIcon("뉴진스",
                            "https://image.msscdn.net/images/brand_event/2023021715431800000074564.jpg",
                            "https://lh3.googleusercontent.com/rsLfdJOXDxqrDoJIb-jCUm8OhKSaGLyyrviaJ_8z893kbmDlz8Ox5G3Wo3gxArbdKxv0zwMmioYtZ__WWVIAqXih8t0nf1vBRr1yk1tX1Q"),
                    createEventIcon("봄 신상",
                            "https://image.msscdn.net/images/brand_event/2023021715431800000074564.jpg",
                            "https://lh3.googleusercontent.com/95Xe9DCHIaoNymZ-sLnaZYMTO1p20jJgm7oWpcuYFOu5EbdrO2XbzchrMQBcZQKg5hNp8m1i8wL6FicdSlWinU1YOL1rqOVfihxjs6EZ_A")
            };

            for (EventIcon eventIcon : eventIconList) { entityManager.persist(eventIcon); }
        }

        private EventIcon createEventIcon(String title, String thumbnailImageURL, String thumbnailTextImageURL) {
            EventIcon eventIcon = new EventIcon();
            eventIcon.setEvent_title(title);
            eventIcon.setThumbnail_image_url(thumbnailImageURL);
            eventIcon.setThumbnail_text_image_url(thumbnailTextImageURL);

            return eventIcon;
        }
    }
}
