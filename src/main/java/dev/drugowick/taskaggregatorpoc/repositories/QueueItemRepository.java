package dev.drugowick.taskaggregatorpoc.repositories;

import dev.drugowick.taskaggregatorpoc.domain.QueueItem;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface QueueItemRepository extends PagingAndSortingRepository<QueueItem, Long> {


}
