package dev.drugowick.taskaggregatorpoc.controllers.rest_controllers;

import dev.drugowick.taskaggregatorpoc.domain.QueueItem;
import dev.drugowick.taskaggregatorpoc.services.QueueItemService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@RestController
public class RestApiController {

    @Data
    @AllArgsConstructor
    private class TasksResponseClass {
        private String name;
        private String link;
    }

    @Data
    @AllArgsConstructor
    private class QueueItemResponseClass {
        private String name;
        private String description;
        private String date;
        private String time;
    }

    @RequestMapping(value = "/rest/hello", method = RequestMethod.GET)
    public String hello() {
        String responseToBeParsedToJson = "Hello, rest requester. Thanks for hitting on me! =)";
        return responseToBeParsedToJson;
    }

    @RequestMapping(value = "/rest/tasks", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Set<TasksResponseClass> listOfItems() {
        Set<TasksResponseClass> listOfTasks = new HashSet<>();
        listOfTasks.add(
                new TasksResponseClass("Queue Anything", "/queue-page")
        );
        return listOfTasks;
    }

    private final QueueItemService queueItemService;

    public RestApiController(QueueItemService queueItemService) {
        this.queueItemService = queueItemService;
    }

    @RequestMapping(value = "/rest/queue", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Set<QueueItemResponseClass> getQueueItems() {
        Iterable<QueueItem> queueItems = queueItemService.getQueueItems();
        Set<QueueItemResponseClass> queueItemsResponseSet = new HashSet<>();
        queueItems.forEach(queueItem -> queueItemsResponseSet.add(
                new QueueItemResponseClass(
                        queueItem.getName(),
                        queueItem.getDescription(),
                        queueItem.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                        queueItem.getCreatedAt().format(DateTimeFormatter.ofPattern("HH:mm:ss"))
                )
        ));
        return queueItemsResponseSet;
    }

}
