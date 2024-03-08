package com.app.vetcare.model.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Entity
@Table(name = "agent_details")
@Getter
@Setter
public class UserDao {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "user_id")
    private int id;

    private String name;

    private String password;


    private String address;


    @Column(name = "phone_number")
    private String phoneNumber;


    private String email;


    private String adharId;

   private String role;

    @Column(name = "create_dt")
    private String createDt;

    @JsonIgnore
    @OneToMany(mappedBy="agentDao",fetch=FetchType.EAGER)
    private Set<PetDetailsDao> petDetailsDaos;

    @JsonIgnore
    @OneToMany(mappedBy="userDao",fetch=FetchType.EAGER)
    private Set<AuthorityDao> authorities;
}
