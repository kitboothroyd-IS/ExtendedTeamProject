package com.informed.ExtProject.server.reference;

import com.informed.ExtProject.reference.*;

import java.util.HashMap;
import java.util.Map;

public class ForeignExchangeRateService {

    private static HashMap<Currency, HashMap> exchangeRateMap = new HashMap<>();
    private static int foreignExchangeMaxIterations = 2;

    /*
    * Take an instance of ForeignExchangeRate and save it to a map of maps.
    * If the key already exists, 'get' that map item and update it using 'put'; else 'put' the map of map.
    * Map structure: {originCurrency={destinationCurrency=exchangeRate}}
    * Use recursion to call the function a second time with the inverse of the exchange rate...
    * i.e. {destinationCurrency={originCurrency=1/exchangeRate}}
    * */
    public static void AddExchangeRate (ForeignExchangeRate foreignExchangeRate) {
        // Create an empty hashmap and put: Key=Destination currency, Value=exchange rate
        HashMap<Currency, Double> subMap = new HashMap<>();
        subMap.put(foreignExchangeRate.destinationCurrency, foreignExchangeRate.exchangeRate);

        // If the origin currency already exists as a key in the exchangeRateMap, get that item and put in the subMap
        if (exchangeRateMap.containsKey(foreignExchangeRate.originCurrency)) {
            exchangeRateMap.get(foreignExchangeRate.originCurrency).put(foreignExchangeRate.destinationCurrency,
                    foreignExchangeRate.exchangeRate);
        // If the origin currency doesn't exist as a key, add it as a new item to the hashmap alongside the subMap
        } else {
            exchangeRateMap.put(foreignExchangeRate.originCurrency, subMap);
        }
        System.out.println("Added/updated exchange rate: " + foreignExchangeRate.originCurrency.getSymbol() + ">" +
                foreignExchangeRate.destinationCurrency.getSymbol() + ": " + foreignExchangeRate.exchangeRate);

        // Calculate the inverse exchange rate and re-run the function (switching the origin and destination currencies)
        if (foreignExchangeMaxIterations == 2) {
            foreignExchangeMaxIterations--;
            double reverseExchangeRate = 1 / foreignExchangeRate.exchangeRate;
            ForeignExchangeRate reverseExchangeRateObj = new ForeignExchangeRate(foreignExchangeRate.destinationCurrency,
                    foreignExchangeRate.originCurrency,
                    reverseExchangeRate);
            AddExchangeRate(reverseExchangeRateObj);
        }
    }

    public static double getExchangeRateFor (Currency originCurrency, Currency destinationCurrency) {
        double exchangeRate = (double) exchangeRateMap.get(originCurrency).get(destinationCurrency);
        System.out.println("The exchange rate for " +
                            originCurrency.getSymbol() +
                            " to " +
                            destinationCurrency.getSymbol() +
                            " is: " +
                            exchangeRate);
        return exchangeRate;
    }

    public static void getAllForeignExchangeRates() {
        for (Map.Entry<Currency, HashMap> item : exchangeRateMap.entrySet()) {
            System.out.println(item);
        }
    }
}
