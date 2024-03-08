package com.app.vetcare.model.persistence;


import com.app.vetcare.config.APIValidationConfig;
import com.app.vetcare.model.constant.PetType;
import com.app.vetcare.validator.EnumValidator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

/**
 * User request model
 */
@Entity
@Table(name = "pet_details")
@Getter
@Setter
public class PetDetailsDao {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
  @GenericGenerator(name = "native",strategy = "native")
  private Long id;

  @Column(name = "pet_type")
  private String petType;


  private String breed;

  private Integer age;

  private String gender;

  private String UHID;

  @Column(name = "owner_name",nullable = false)
  private String ownerName;

  @Column(name = "owner_id_type")
  private String ownerIDType;

  @Column(name = "owner_id_number")
  private String ownerIdNumber;

  @Column(name = "owner_phone_number",nullable = false)
  private String ownerPhoneNumber;

  @Column(name = "farm_name")
  private String farmName ;

  @Column(name = "insurance_id")
  private String insuranceId;

  @Column(name = "insurance_company_name")
  private String insuranceCompanyName;

  @Column(name = "insurance_type")
  private String insuranceType;

  @Column(name = "farm_animal_code")
  private String farmAnimalCode;

  @ManyToOne
  @JoinColumn(name = "agent_id")
  private UserDao agentDao;

  @JsonIgnore
  @OneToMany(mappedBy="petDetailsDao",fetch=FetchType.EAGER)
  private Set<PetTestDetailsDao> petTestDetailsDaos;

}
