package talkwith.semogong.domain;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import talkwith.semogong.common.enums.Rank;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int id;
    private String email;
    private String name;
    private String password;

    @Enumerated(value = EnumType.STRING)
    private Rank rank;
    private String role;

}
