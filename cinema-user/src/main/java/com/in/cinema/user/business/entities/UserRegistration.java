package com.in.cinema.user.business.entities;

import com.in.cinema.user.model.City;
import com.in.cinema.user.model.Country;
import com.in.cinema.user.model.State;
import java.time.ZonedDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER_REGISTRATION")
public class UserRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userRegistration_seq")
    @SequenceGenerator(name = "userRegistration_seq", sequenceName = "userRegistration_seq")
    private Long id;

    @Column(name = "mobilenumber")
    private String mobileNumber;
    @Column(name = "emailid")
    private String emailId;
    @Enumerated(EnumType.STRING)
    private Country country;
    @Enumerated(EnumType.STRING)
    private State state;
    @Enumerated(EnumType.STRING)
    private City city;
    @Column(name = "userregistrationid")
    private UUID userRegistrationId;
    @CreationTimestamp
    @Column(name = "creationtime")
    private ZonedDateTime creationTime;
}
