package com.szendroi.job.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Client {

    @Id
    private Long id;
    @Column(length = 100, unique = true, nullable = false)
    private String userName;
    @Column(length = 100, unique = true, nullable = false)
    private String email;
}
