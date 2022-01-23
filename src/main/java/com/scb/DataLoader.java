package com.scb;

import com.scb.model.Location;
import com.scb.repository.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Configuration
public class DataLoader {

    @Autowired
    private LocationRepo locationRepo;

    @PostConstruct
    public void setup()
    {
        LongStream.range(1,3).forEach(i-> {
            Location location = new Location();
            location.setId(i);
            location.setName("kalai");
            locationRepo.save(location);
        });

    }

}
