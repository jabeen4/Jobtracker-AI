package com.aiJobApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "jobs")
@NoArgsConstructor
@AllArgsConstructor
public class Applications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    private LocalDate applied_on = LocalDate.now();

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status{
        APPLIED, INTERVIEW, REJECTED, OFFER
    }
}
