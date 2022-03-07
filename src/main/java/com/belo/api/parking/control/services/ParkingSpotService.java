package com.belo.api.parking.control.services;

import com.belo.api.parking.control.models.ParkingSpotModel;
import com.belo.api.parking.control.repositories.CarRepository;
import com.belo.api.parking.control.repositories.ParkingSpotRepository;
import com.belo.api.parking.control.services.interfaces.IParkingSpotService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingSpotService implements IParkingSpotService {

    final ParkingSpotRepository parkingSpotRepository;
    final  CarRepository carRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository, CarRepository carRepository){
        this.parkingSpotRepository = parkingSpotRepository;
        this.carRepository = carRepository;
    }

    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        carRepository.save(parkingSpotModel.getCar());
        return parkingSpotRepository.save(parkingSpotModel);
    }

    public Page<ParkingSpotModel> findAll(Pageable pageable) {
        return parkingSpotRepository.findAll(pageable);
    }

    public Optional<ParkingSpotModel> findById(UUID id) {
        return parkingSpotRepository.findById(id);
    }

    @Transactional
    public void delete(ParkingSpotModel parkingSpotModel){
        carRepository.delete(parkingSpotModel.getCar());
        parkingSpotRepository.delete(parkingSpotModel);
    }

    public boolean existsByLicensePlateCar(String licensePlateCar) {
        return carRepository.existsByLicensePlate(licensePlateCar);
    }

    public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
        return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
    }

    public boolean existsByApartmentAndBlock(String apartment, String block) {
        return parkingSpotRepository.existsByApartmentAndBlock(apartment,block);
    }

}
