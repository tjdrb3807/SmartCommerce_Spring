package SmartCommerce.eCommerce.eventIcon.dto;

import SmartCommerce.eCommerce.eventIcon.EventIcon;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Struct;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventIconResponseDTO {
    private Long event_icon_id;
    private String event_icon_title;
    private String event_icon_thumbnail_image_url;

    public EventIconResponseDTO(EventIcon eventIcon) {
        this.event_icon_id = eventIcon.getId();
        this.event_icon_title = eventIcon.getEvent_title();
        this.event_icon_thumbnail_image_url = eventIcon.getThumbnail_image_url();
    }
}
