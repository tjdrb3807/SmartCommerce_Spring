package SmartCommerce.eCommerce.itemType;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.net.URL;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class ItemType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemType_id")
    private Long id;
    private Integer category_id;
    private String item_type_title;
    private String item_type_thumbnail_image_URL;
}
