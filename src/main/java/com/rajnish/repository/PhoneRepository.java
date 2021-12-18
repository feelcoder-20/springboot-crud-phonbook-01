package com.rajnish.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rajnish.model.*;
@Repository
public interface PhoneRepository extends JpaRepository<Phone,Integer> {

}
