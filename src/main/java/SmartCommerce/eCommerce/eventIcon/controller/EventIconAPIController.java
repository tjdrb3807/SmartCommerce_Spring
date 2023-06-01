package SmartCommerce.eCommerce.eventIcon.controller;

import SmartCommerce.eCommerce.eventIcon.EventIcon;
import SmartCommerce.eCommerce.eventIcon.repository.EventIconRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventIconAPIController {

    private final EventIconRepository eventIconRepository;

    @PostMapping("/commerce/api/v1/category/event")
    public HashMap<String, List<EventIcon>> eventIcons() {
        List<EventIcon> eventIcons = eventIconRepository.findAll();
        HashMap<String, List<EventIcon>> hash = new HashMap<>();
        hash.put("documents", eventIcons);

        return hash;
    }
}
