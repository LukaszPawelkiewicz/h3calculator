package com.mycompany.h3calculator.repository.impl;

import com.mycompany.h3calculator.model.Unit;
import com.mycompany.h3calculator.repository.UnitRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UnitRepositoryImpl implements UnitRepository {

    private final List<Unit> units = new ArrayList<>();

    public UnitRepositoryImpl() {
        units.add(new Unit("Trolodyta", 4, 3, 1, 3, 5, 4));
        units.add(new Unit("Harpia", 6, 5, 1, 4, 14, 6));
    }

    @Override
    public List<Unit> getAllUnits() {
        return units;
    }
}
