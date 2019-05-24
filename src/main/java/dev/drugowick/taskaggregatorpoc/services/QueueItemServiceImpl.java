package dev.drugowick.taskaggregatorpoc.services;

import dev.drugowick.taskaggregatorpoc.domain.QueueItem;
import dev.drugowick.taskaggregatorpoc.repositories.QueueItemRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QueueItemServiceImpl implements QueueItemService {

    private final QueueItemRepository queueItemRepository;

    public QueueItemServiceImpl(QueueItemRepository queueItemRepository) {
        this.queueItemRepository = queueItemRepository;
    }


    @Override
    public Optional<QueueItem> findQueueItemById(Long queueItemId) {
        return queueItemRepository.findById(queueItemId);
    }

    @Override
    public QueueItem saveQueueItem(QueueItem queueItem) {
        return queueItemRepository.save(queueItem);
    }

    @Override
    public void deleteQueueItemById(Long queueItemId) {
        queueItemRepository.deleteById(queueItemId);
    }

    @Override
    public Iterable<QueueItem> getQueueItems() {
        return queueItemRepository.findAll();
    }
}
