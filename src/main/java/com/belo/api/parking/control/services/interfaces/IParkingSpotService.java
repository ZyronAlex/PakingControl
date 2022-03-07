package com.belo.api.parking.control.services.interfaces;

import com.belo.api.parking.control.models.ParkingSpotModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IParkingSpotService {
    ParkingSpotModel save(ParkingSpotModel parkingSpotModel);

    Page<ParkingSpotModel> findAll(Pageable pageable);

    Optional<ParkingSpotModel> findById(UUID id);

    void delete(ParkingSpotModel parkingSpotModel);

    boolean existsByLicensePlateCar(String licensePlateCar);

    boolean existsByParkingSpotNumber(String parkingSpotNumber);

    boolean existsByApartmentAndBlock(String apartment, String block);

}
