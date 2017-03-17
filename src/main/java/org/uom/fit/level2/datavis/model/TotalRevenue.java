package org.uom.fit.level2.datavis.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.BasicQuery;

import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by niwantha on 3/12/17.
 */
@Document(collection = "rawdata")
public class TotalRevenue {

    // SimpleDateFormat datef = new SimpleDateFormat("MM/dd/yyyy");
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private BigInteger id;
    private Date BOOKING_CREATED_DATE;
    private BigInteger TOTAL_PRICE;



    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getTOTAL_PRICE() {
        return TOTAL_PRICE;
    }

    public void setTOTAL_PRICE(BigInteger TOTAL_PRICE) {
        this.TOTAL_PRICE = TOTAL_PRICE;
    }

    public Date getBOOKING_CREATED_DATE() {
        return BOOKING_CREATED_DATE;
    }

    public void setBOOKING_CREATED_DATE(Date BOOKING_CREATED_DATE) {
        this.BOOKING_CREATED_DATE = BOOKING_CREATED_DATE;
    }







}


