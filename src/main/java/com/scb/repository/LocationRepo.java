package com.scb.repository;

import com.scb.model.Location;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.InMemoryResourceRepository;
import io.crnk.core.resource.list.ResourceList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
public class LocationRepo extends InMemoryResourceRepository<Location,Long>{

    public static ConcurrentHashMap<Long,Location> locationMap = new ConcurrentHashMap<>();

    public LocationRepo()
    {
        super(Location.class);
    }

    @Override
    public <S extends Location> S create(S resource) {
        locationMap.put(resource.getId(),resource);
        return resource;
    }

    @Override
    public <S extends Location> S save(S entity) {
        if (entity.getId() == null) {
            Long test = Collections.max(Collections.list(locationMap.keys()));
            log.info("the largest "+ test);
            log.info("the new largest "+ test+1 );
        }
        locationMap.put(entity.getId(), entity);
        log.info("the save");
        return entity;
    }

    @Override
    public ResourceList<Location> findAll(QuerySpec querySpec) {
        return querySpec.apply(locationMap.values());
    }

    public void delete(Long id) {
       locationMap.remove(id);
       log.info(String.format("%d the id been deleted",id));
    }


}
