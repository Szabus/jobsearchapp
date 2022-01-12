package com.szendroi.job.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String positionName;
    @Column(length = 50, nullable = false)
    private String location;

    public Position(String positionName, String location) {
        this.positionName = positionName;
        this.location = location;
    }
}
