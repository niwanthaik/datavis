package org.uom.fit.level2.datavis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uom.fit.level2.datavis.model.TotalRevenue;
import org.uom.fit.level2.datavis.repository.TotalRevenueRepositery;

import java.util.List;

/**
 * Created by niwantha on 3/12/17.
 */
@Service
public class MongoDBData implements DataService {

    private final TotalRevenueRepositery repositery;

    @Autowired
    MongoDBData(TotalRevenueRepositery repositery) {
        this.repositery = repositery;

    }

    @Override
    public List<TotalRevenue> findAll() {

        List<TotalRevenue> datantity = repositery.findAll();
        for (TotalRevenue d : datantity) {
            // System.out.println(d.getAgentname());
        }
        return datantity;
    }


}




