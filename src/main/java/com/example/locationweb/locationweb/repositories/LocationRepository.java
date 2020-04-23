package com.example.locationweb.locationweb.repositories;

import com.example.locationweb.locationweb.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    Location findLocationsByName(String name);  //any query that we need to implement can be found here just use "find____By__" jpa has a lot of implementation already in it so we just need to see if it has it by filling the blanks in the method with the type of result extraction we want to to as in here i use findLOCATIONbyNAME

}
