package com.vedatdemirdev.repository;

import com.vedatdemirdev.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
