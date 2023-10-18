package ru.accounterio.cost_management.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserData {
    @Id
    @Column(name = "id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @Pattern(regexp = "\\d{11}", message = "Неверный формат телефона")
    @Column(name = "phone")
    private String phone;
}