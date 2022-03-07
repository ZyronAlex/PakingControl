package com.belo.api.parking.control.repositories;

import com.belo.api.parking.control.models.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<CarModel, UUID> {

    boolean existsByLicensePlate(String licensePlate);
}
