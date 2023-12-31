package ru.accounterio.cost_management.domains;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@Table(name = "user_data")
@Getter
@Setter
@EqualsAndHashCode(exclude = {"id"})
@NoArgsConstructor
@AllArgsConstructor
public class UserData {
    @Id
    @Column(name = "id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    @Pattern(regexp = "\\d{11}", message = "Неверный формат телефона")
    @Column(name = "phone")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String phone;
}
