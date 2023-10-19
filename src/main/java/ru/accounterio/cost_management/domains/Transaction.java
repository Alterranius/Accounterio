package ru.accounterio.cost_management.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@EqualsAndHashCode(exclude = {"id"})
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction implements Comparable<Transaction> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "value")
    private double value;

    @Column(name = "stamp")
    @Temporal(value = TemporalType.TIMESTAMP)
    private LocalDateTime stamp;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public boolean isExpense() {
        return value < 0d;
    }

    public boolean isIncome() {
        return !isExpense();
    }

    @Override
    public int compareTo(@NotNull Transaction o) {
        return this.getStamp().compareTo(o.getStamp());
    }
}
