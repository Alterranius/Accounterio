package ru.accounterio.cost_management.domains;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "item")
@Getter
@Setter
@EqualsAndHashCode(exclude = {"id"})
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private Set<Position> positions;
}
