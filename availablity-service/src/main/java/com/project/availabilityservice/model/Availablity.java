package com.project.availabilityservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="t_availablity")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Availablity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseCode;
    private Integer slots;
}
