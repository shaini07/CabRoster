package com.blujay.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blujay.backend.DriverRepository;
import com.blujay.backend.data.entity.Driver;

@Service
public class DriverService extends CrudService<Driver> {

    private static final String DRIVER_NOT_FOUND = "Driver not found";
    private final DriverRepository driverRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver findByEmail(String email) {
        return getRepository().findByEmail(email);
    }

    @Override
    public Page<Driver> findAnyMatching(Optional<String> filter, Pageable pageable) {
        if (filter.isPresent()) {
            String repositoryFilter = "%" + filter.get() + "%";
            return getRepository().findByEmailLikeIgnoreCaseOrNameLikeIgnoreCase(repositoryFilter, repositoryFilter, pageable);
        } else {
            return getRepository().findAll(pageable);
        }
    }

    @Override
    public long countAnyMatching(Optional<String> filter) {
        if (filter.isPresent()) {
            String repositoryFilter = "%" + filter.get() + "%";
            return getRepository().countByEmailLikeIgnoreCaseOrNameLikeIgnoreCase(repositoryFilter, repositoryFilter);
        } else {
            return getRepository().count();
        }
    }

    @Override
    protected DriverRepository getRepository() {
        return driverRepository;
    }

    @Override
    @Transactional
    public Driver save(Driver entity) {
        throwIfDriverLocked(entity.getId());
        return super.save(entity);
    }

    @Override
    @Transactional
    public void delete(long driverId) {
        throwIfDriverLocked(driverId);
        super.delete(driverId);
    }

    private void throwIfDriverLocked(Long driverId) {
        if (driverId == null) {
            return;
        }

        Optional<Driver> dbDriver = getRepository().findById(driverId);
        if (!dbDriver.isPresent()) {
            throw new UserFriendlyDataException(DRIVER_NOT_FOUND);
        }
    }

}
