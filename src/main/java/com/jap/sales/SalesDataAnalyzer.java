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
           String data = bufferedReader.readLine();

           while ((data = bufferedReader.readLine()) != null){
               String[] sp = data.split(",");
               String date = sp[0];
               int customer_id = Integer.parseInt(sp[1]);
               int productCategory = Integer.parseInt(sp[2]);
               String paymentMethod = sp[3];
               double amount = Double.parseDouble(sp[4]);
               double timeOnSIte = Double.parseDouble(sp[5]);
               int clicksInSite = Integer.parseInt(sp[6]);
               salesRecords.add(new SalesRecord(date,customer_id,productCategory,paymentMethod,amount,timeOnSIte,clicksInSite));

           }

       }catch (IOException e){
           e.printStackTrace();
       }


        return salesRecords;
    }

    // Sort the customers based on purchase amount
    public List<SalesRecord> getAllCustomersSortedByPurchaseAmount(List<SalesRecord> salesData, AmountComparator amountComparator){

        Collections.sort(salesData,amountComparator);

        return salesData;

    }

    // Find the top customer who spent the maximum time on the site
    public SalesRecord getTopCustomerWhoSpentMaxTimeOnSite(List<SalesRecord> salesData,TimeOnSiteComparator timeOnSiteComparator){

        Collections.sort(salesData,timeOnSiteComparator);

        return salesData.get(0); // return the 0th index value
    }



}
