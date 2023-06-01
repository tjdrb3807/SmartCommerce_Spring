package SmartCommerce.eCommerce.itemType.controller;

import SmartCommerce.eCommerce.category.Category;
import SmartCommerce.eCommerce.category.controller.CategoryController;
import SmartCommerce.eCommerce.eventIcon.EventIcon;
import SmartCommerce.eCommerce.itemType.ItemType;
import SmartCommerce.eCommerce.itemType.repository.ItemTypeRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
//import java.util.HashMap;@PostMapping("/commerce/api/v1/category/itemType")
//    public HashMap<Long, List<ItemType>> itemType() {
//        List<ItemType> allWithCategory = itemTypeRepository.findAllWithCategory();
//
//        HashMap<Long, List<ItemType>> hash = new HashMap<>();
//
//        List<ItemType> itemTypes1 = new ArrayList<>();
//        List<ItemType> itemTypes2 = new ArrayList<>();
//        List<ItemType> itemTypes3 = new ArrayList<>();
//
//        for(ItemType it : allWithCategory) {
//            if(it.getCategory().getId() == 1){
//                itemTypes1.add(it);
//            }
//            else if(it.getCategory().getId() == 2) {
//                itemTypes2.add(it);
//            }
//            else {
//                itemTypes3.add(it);
//            }
//        }
//
//        hash.put((long)1, itemTypes1);
//        hash.put((long)2, itemTypes2);
//        hash.put((long)3, itemTypes3);
//
//        return hash;
//    }
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ItemTypeController {

    private final ItemTypeRepository itemTypeRepository;

    @PostMapping("/commerce/api/v1/itemType")
    public HashMap<String, List<ItemType>> itemType() {
        List<ItemType> allWithCategory = itemTypeRepository.findAllWithCategory();
        HashMap<String, List<ItemType>> hash = new HashMap<>();
        hash.put("documents", allWithCategory);

        return hash;
    }

    @PostMapping("/commerce/api/v2/itemType")
    public List<ItemTypeResponseDTO> itemTypes() {
        return itemTypeRepository.findAllWithCategory().stream()
                .map(i -> new ItemTypeResponseDTO(i))
                .collect(Collectors.toList());
    }
//

//    @PostMapping("/commerce/api/v1/category/event")
//    public HashMap<String, List<EventIcon>> eventIcons() {
//        List<EventIcon> eventIcons = eventIconRepository.findAll();
//        HashMap<String, List<EventIcon>> hash = new HashMap<>();
//        hash.put("documents", eventIcons);
//
//        return hash;
//    }

    @Data
    public static class ItemTypeResponseDTO {
        private Long item_type_id;
        private Integer category_id;
        private String item_type_title;
        private String item_type_thumbnail_image_URL;

        public ItemTypeResponseDTO(ItemType itemType) {
            this.item_type_id = itemType.getId();
            this.category_id = itemType.getCategory_id();
            this.item_type_title = itemType.getItem_type_title();
            this.item_type_thumbnail_image_URL = itemType.getItem_type_thumbnail_image_URL();
        }
    }
}
