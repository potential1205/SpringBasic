package talkwith.semogong.domain;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import talkwith.semogong.common.enums.Rank;

@Entity
@Getter
@Builder
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String password;

    @Enumerated(value = EnumType.STRING)
    private Rank rank;
    private int age;
    private String role;

    public UserEntity() {
    }
}
