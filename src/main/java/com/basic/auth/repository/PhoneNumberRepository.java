package com.basic.auth.repository;

import com.basic.auth.model.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {

    public PhoneNumber findByNumber(String to);
}
