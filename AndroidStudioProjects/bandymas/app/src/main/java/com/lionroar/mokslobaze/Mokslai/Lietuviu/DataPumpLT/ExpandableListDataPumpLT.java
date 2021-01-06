package com.lionroar.mokslobaze.Mokslai.Lietuviu.DataPumpLT;

import com.lionroar.mokslobaze.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPumpLT {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> JS = new ArrayList<String>();
        JS.add("");
        List<String> VMP = new ArrayList<String>();
        VMP.add("");
        List<String> JB = new ArrayList<String>();
        JB.add("");
        List<String> AM = new ArrayList<String>();
        AM.add("");
        List<String> JTV = new ArrayList<String>();
        JTV.add("");
        List<String> SR = new ArrayList<String>();
        SR.add("");
        /*List<String> AM = new ArrayList<String>();
        VMP.add("");
        List<String> AM = new ArrayList<String>();
        VMP.add("");
        List<String> AM = new ArrayList<String>();
        VMP.add("");*/
        expandableListDetail.put("Jurgis Savickis", JS);
        expandableListDetail.put("Vincas Mykolaitis-Putinas", VMP);
        expandableListDetail.put("Jonas Biliūnas", JB);
        expandableListDetail.put("A. Mickevičius", AM);
        expandableListDetail.put("Šatrijos Ragana", SR);
        expandableListDetail.put("Juozas Tumas-Vaižgantas", JTV);
        //expandableListDetail.put("Vincas Mykolaitis-Putinas", VMP);
        //expandableListDetail.put("Vincas Mykolaitis-Putinas", VMP);
        return expandableListDetail;
    }
}
