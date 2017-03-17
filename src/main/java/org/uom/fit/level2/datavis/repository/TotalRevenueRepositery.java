package org.uom.fit.level2.datavis.repository;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.uom.fit.level2.datavis.model.TotalRevenue;

import java.util.List;

/**
 * Created by niwantha on 3/12/17.
 */
@Repository
public interface TotalRevenueRepositery extends MongoRepository<TotalRevenue, String> {
    // List<TotalRevenue> findAll();




}
