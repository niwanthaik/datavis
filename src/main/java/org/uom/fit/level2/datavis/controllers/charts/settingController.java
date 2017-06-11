package org.uom.fit.level2.datavis.controllers.charts;

/**
 * Created by niwantha on 3/19/17.
 */

import com.google.gson.JsonArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.uom.fit.level2.datavis.model.dataModel;

@Controller
@RequestMapping("/api")
public class settingController {
    @RequestMapping(value = "/setting", method = RequestMethod.POST)
    @ResponseBody
    public String checkUser(@RequestBody dataModel dataModel) {
        JsonArray value = null;
        if (dataModel.getParameter1().contains("Depature airport")|| dataModel.getParameter1().contains("Flight number")) {
            if (dataModel.getParameter2().contains("Flight number")||dataModel.getParameter2().contains("Depature airport")||dataModel.getParameter2().contains("Flight number")
                    ) {
                value = Flight.getFliteDe(dataModel);
            }

        } else if (dataModel.getParameter1().contains("cabin class")||dataModel.getParameter1().contains("no of bookings")||
                dataModel.getParameter1().contains("Passengers")) {
            if (dataModel.getParameter2().contains("no of bookings")||dataModel.getParameter2().contains("cabin class")||
                    dataModel.getParameter2().contains("Passengers")) {
                value = CabinClassVsBooking.cabinVsBooking(dataModel);
            }

        } else if (dataModel.getParameter1().contains("Agent Name")||dataModel.getParameter1().contains("Passengers")||
                dataModel.getParameter1().contains("no of bookings")) {
            if (dataModel.getParameter2().contains("Passengers") ||dataModel.getParameter2().contains("Agent Name")||
                    dataModel.getParameter2().contains("no of bookings")){
                value = PassengersPerAgents.passengersPerAgent(dataModel);
            }


        }else if (dataModel.getParameter1().contains("Nationality")||dataModel.getParameter1().contains("Passengers")||
                dataModel.getParameter1().contains("no of bookings")) {
            if (dataModel.getParameter2().contains("Passengers") || dataModel.getParameter2().contains("Nationality")||
                    dataModel.getParameter2().contains("no of bookings")) {
                value = PassengersVNationality.passengersVNationalty(dataModel);
            }

        }else if (dataModel.getParameter1().contains("Payment Type")||dataModel.getParameter1().contains("Passengers")
                ||dataModel.getParameter1().contains("no of bookings")) {
            if (dataModel.getParameter2().contains("Passengers") || dataModel.getParameter2().contains("Payment Type")
                    ||dataModel.getParameter2().contains("no of bookings")) {
                value = PassengersVPayType.passengersVPayType(dataModel);
            }
        }else if (dataModel.getParameter1().contains("Currency Code")||dataModel.getParameter1().contains("Total Price")) {
            if (dataModel.getParameter2().contains("Total Price") || dataModel.getParameter2().contains("Currency Code")) {
                value = RevenueVCurrencyCode.revenueVCurrencyCode(dataModel);
            }
        }else if (dataModel.getParameter1().contains("Booking Created Date")||dataModel.getParameter1().contains("Passengers")||
                dataModel.getParameter1().contains("no of bookings")) {
            if (dataModel.getParameter2().contains("Passengers") || dataModel.getParameter2().contains("Booking Created Date")||
                    dataModel.getParameter2().contains("no of bookings")) {
                value = TotalPassengersVDay.totalPassengersDay(dataModel);
            }
        } else if (dataModel.getParameter1().contains("Depature airport")||dataModel.getParameter1().contains("Total Price")) {
                if (dataModel.getParameter2().contains("Total Price") || dataModel.getParameter2().contains("Booking Created Date")) {
                    value = RevenueVDay.revenueVDay(dataModel);
                }

        }else if (dataModel.getParameter1().contains("Gender")||dataModel.getParameter1().contains("Passengers")||
                dataModel.getParameter1().contains("no of bookings")) {
            if (dataModel.getParameter2().contains("Passengers") || dataModel.getParameter2().contains("Gender")||
                    dataModel.getParameter2().contains("no of bookings")) {
                value = GenderVPassengers.genderVPassengers(dataModel);
            }
        }else if (dataModel.getParameter1().contains("Nationality")||dataModel.getParameter1().contains("Total Price")) {
            if (dataModel.getParameter2().contains("Total Price") || dataModel.getParameter2().contains("Nationality")) {
                value = NationalityVTotal.nationalityVTotal(dataModel);
            }
        }

            return value.toString();
        }


    }
