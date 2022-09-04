package com.jap.sales;


import java.util.Comparator;

public class TimeOnSiteComparator implements Comparator<SalesRecord> {
    @Override
    public int compare(SalesRecord o1, SalesRecord o2) {
        if(o1.getTime_on_site() == o2.getTime_on_site()){
            return 0;
        }else if(o1.getTime_on_site() > o2.getTime_on_site()){
            return -1;
        }
        return 1;
    }
}
