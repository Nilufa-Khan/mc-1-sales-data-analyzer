package com.jap.sales;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SalesDataAnalyzer {
    // Read the data from the file and store in a List
   public List<SalesRecord> readFile(String fileName) {
       List<SalesRecord> salesRecords = new ArrayList<>();
       FileReader fileReader = null;
       try {
           fileReader = new FileReader(fileName);
           BufferedReader bufferedReader = new BufferedReader(fileReader);
           String data = "" ;
           String response = "";
           while ((data = bufferedReader.readLine()) != null){
                response = response + data;
               salesRecords.add(new SalesRecord());

           }
       } catch (IOException e) {
           e.printStackTrace();
       }


        return salesRecords;
    }

    // Sort the customers based on purchase amount
    public List<SalesRecord> getAllCustomersSortedByPurchaseAmount(List<SalesRecord> salesData, AmountComparator amountComparator){
        List<SalesRecord> recordList = new ArrayList<>();
        Collections.sort(salesData,new AmountComparator());
        for(SalesRecord sr : salesData){
            recordList.add(sr);
        }

       return recordList;
    }

    // Find the top customer who spent the maximum time on the site
    public SalesRecord getTopCustomerWhoSpentMaxTimeOnSite(List<SalesRecord> salesData,TimeOnSiteComparator timeOnSiteComparator){

        return null;
    }



}
