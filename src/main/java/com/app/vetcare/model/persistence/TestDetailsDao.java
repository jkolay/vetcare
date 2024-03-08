package com.app.vetcare.model.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "test_details")
@Getter
@Setter
public class TestDetailsDao {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long id;

    @Column(name = "test_name")
    private String testName;

    @Column(name = "test_type")
    private Double testCost;

    @Column(name = "last_updated")
    private Timestamp lastUpdatedDate;

    @JsonIgnore
    @OneToMany(mappedBy="testDetailsDao",fetch=FetchType.EAGER)
    private Set<PetTestDetailsDao> petTestDetailsDaos;
}
