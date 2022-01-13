package com.szendroi.job.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;


@Entity
@Getter @Setter
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
    private UUID id;
    @Column(length = 100, unique = true, nullable = false)
    private String userName;
    @Column(length = 100, unique = true, nullable = false)
    private String email;

    public Client(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }
}
