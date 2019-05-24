package dev.drugowick.taskaggregatorpoc.controllers.page_controllers;

import dev.drugowick.taskaggregatorpoc.domain.QueueItem;
import dev.drugowick.taskaggregatorpoc.services.QueueItemService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class QueuePageController {

    private final QueueItemService queueItemService;

    public QueuePageController(QueueItemService queueItemService) {
        this.queueItemService = queueItemService;
    }

    @Data
    private class QueueItemPostRequest {
        private String name;
        private String description;
    }

    @GetMapping({"/queue-page", "queue-page.html"})
    public String indexPage(Model model) {
        model.addAttribute("queueItemPostRequest", new QueueItemPostRequest());
        return "queuepage";
    }

    @PostMapping(name = "/queue-page/queue")
    public String saveQueueItem(@ModelAttribute QueueItemPostRequest queueItemPostRequest) {
        QueueItem queueItem = new QueueItem();
        queueItem.setName(queueItemPostRequest.getName());
        queueItem.setDescription((queueItemPostRequest.getDescription()));
        queueItem.setCreatedAt(LocalDateTime.now());

        queueItemService.saveQueueItem(queueItem);

        return "redirect:/queue-page";
    }
}
