package com.in.cinema.user.business.repositories;

import com.in.cinema.user.business.entities.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegistrationRepository extends JpaRepository<UserRegistration, Long> {

}
