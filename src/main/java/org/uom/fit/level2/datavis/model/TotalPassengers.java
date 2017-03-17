package org.uom.fit.level2.datavis.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.math.BigInteger;

/**
 * Created by niwantha on 3/13/17.
 */
@Document(collection = "rawdata")
public class TotalPassengers {

    @Id
    private BigInteger id;

}
