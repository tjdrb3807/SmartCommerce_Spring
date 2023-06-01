package SmartCommerce.eCommerce.eventIcon;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class EventIcon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventIcon_id")
    private Long id;
    private String event_title;
    private String thumbnail_image_url;
    private String thumbnail_text_image_url;
}
