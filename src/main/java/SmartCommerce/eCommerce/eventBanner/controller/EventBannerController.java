package SmartCommerce.eCommerce.eventBanner.controller;

import SmartCommerce.eCommerce.eventBanner.EventBanner;
import SmartCommerce.eCommerce.eventBanner.repository.EventBannerRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class EventBannerController {

    private final EventBannerRepository eventBannerRepository;

    @PostMapping("/commerce/api/v1/home/eventBanner")
    public HashMap<String, List<EventBannerDTO>> eventBanners() {
        List<EventBanner> all = eventBannerRepository.findAll();
        List<EventBannerDTO> collect = all.stream()
                .map(e -> new EventBannerDTO(e))
                .collect(Collectors.toList());

        HashMap<String, List<EventBannerDTO>> hash = new HashMap<>();
        hash.put("bannerList", collect);

        return hash;
    }

    @Data
    static class EventBannerDTO {
        private Long event_banner_id;
        private String event_content;
        private String thumbnail_image_url;

        public EventBannerDTO(EventBanner eventBanner) {
            this.event_banner_id = eventBanner.getId();
            this.event_content = eventBanner.getContent();
            this.thumbnail_image_url = eventBanner.getThumbnailImageURL();
        }
    }
}
