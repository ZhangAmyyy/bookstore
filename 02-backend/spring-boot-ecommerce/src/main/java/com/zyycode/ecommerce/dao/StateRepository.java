package com.zyycode.ecommerce.dao;

import com.zyycode.ecommerce.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

//@CrossOrigin("http://localhost:4200")
@RepositoryRestResource
public interface StateRepository extends JpaRepository<State,Integer> {
    List<State> findByCountryCode(@Param("code") String code);
    //to retrieve states for a given country code
    //http://localhost:8080/api/states/search/findByCountryCode?Code=IN

}
