package com.app.vetcare.model.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "pet_test_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetTestDetailsDao {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "pet_id")
    private PetDetailsDao petDetailsDao;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private TestDetailsDao testDetailsDao;


    @Column(name="test_on")
    private LocalDateTime testOn;

}
