package ru.accounterio.cost_management.domains;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "supplier")
@Getter
@Setter
@EqualsAndHashCode(exclude = {"id"})
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    private Set<Transaction> transactions;
}
