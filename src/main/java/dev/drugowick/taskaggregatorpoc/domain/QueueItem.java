package dev.drugowick.taskaggregatorpoc.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name", "description"})
})
public class QueueItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private LocalDateTime createdAt;

}
