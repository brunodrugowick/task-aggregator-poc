package dev.drugowick.taskaggregatorpoc.services;

import dev.drugowick.taskaggregatorpoc.domain.QueueItem;

import java.util.Optional;

public interface QueueItemService {

    Optional<QueueItem> findQueueItemById(Long queueItemId);

    QueueItem saveQueueItem(QueueItem queueItem);

    void deleteQueueItemById(Long queueItemId);

    Iterable<QueueItem> getQueueItems();
}
