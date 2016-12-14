package com.example;


import org.apache.commons.lang3.StringUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.TimeZone;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {

        System.out.println("====Object Assignment====");
        Foo1 foo1 = new  Foo1();
        foo1.setName("Jane");
        foo1.setBool(true);
        foo1.setNum(2);
        Foo1 foo11 = new Foo1();
        foo11.setName("Jane");
        foo11.setBool(true);
        foo11.setNum(2);

        Foo2 foo2 = new Foo2();
        foo2.setName("Jane");
        foo2.setBool(true);
        foo2.setNum(2);
        Foo2 foo22 = new Foo2();
        foo22.setName("Jane");
        foo22.setBool(true);
        foo22.setNum(2);


        Foo3 foo3 = new Foo3();
        foo3.setName("Jane");
        foo3.setBool(true);
        foo3.setNum(2);
        Foo3 foo33 = new Foo3();
        foo33.setName("Jane");
        foo33.setBool(true);
        foo33.setNum(2);


        if (foo1.hashCode() == foo11.hashCode()){
            System.out.println("SUCCESS: foo1 and foo11 hashcode are the same");
        } else {
            System.out.println("ERROR: foo1 and foo11 hashcode are the same");
        }
        if (foo2.hashCode() == foo22.hashCode()){
            System.out.println("SUCCESS: foo2 and foo22 hashcode are the same");
        } else {
            System.out.println("ERROR: foo2 and foo22 hashcode are the same");
        }
        if (foo3.hashCode() == foo33.hashCode()){
            System.out.println("SUCCESS: foo3 and foo33 hashcode are the same");
        } else {
            System.out.println("ERROR: foo3 and foo3 hashcode are the same");
        }


        if (foo1.equals(foo11)){
            System.out.println("SUCCESS: foo1 and foo11 are equal");
        } else {
            System.out.println("ERROR: foo1 and foo11 are equal");
        }

        if (foo2.equals(foo22)){
            System.out.println("SUCCESS: foo2 and foo22 are equal");
        } else {
            System.out.println("ERROR: foo2 and foo22 are equal");
        }
        if (foo3.equals(foo33)){
            System.out.println("SUCCESS: foo3 and foo33 are equal");
        } else {
            System.out.println("ERROR: foo3 and foo33 are equal");
        }


        System.out.println("====Clock Assignment====");

//        String[] ids = TimeZone.getAvailableIDs();
//        for (String id : ids) {
//            System.out.println(id);
//        }


        while (true) {
           // LocalTime timeNow = LocalTime.now();
            //System.out.println(timeNow);


            ZoneId pacificTZ = ZoneId.of("US/Pacific");
            LocalTime pacificTimeNow = LocalTime.now(pacificTZ);
            String  pacificNow = "" + pacificTimeNow;
            //System.out.println(pacificNow);

            String pacificHtml = getHtml(pacificTimeNow);

            ZoneId montainTZ = ZoneId.of("US/Mountain");
            LocalTime mountainTimeNow = LocalTime.now(montainTZ);
            String mountainNow = "" + mountainTimeNow;
           // System.out.println(mountainNow);

            String montainHtml = getHtml(mountainTimeNow);

            ZoneId centralTZ = ZoneId.of("US/Central");
            LocalTime centralTimeNow = LocalTime.now(centralTZ);
            String centralNow = "" + centralTimeNow;
            //System.out.println(centralNow);

            String centralHtml = getHtml(centralTimeNow);

            ZoneId easternTZ = ZoneId.of("US/Eastern");
            LocalTime easternTimeNow = LocalTime.now(easternTZ);
            String easternNow = "" + easternTimeNow;
            //System.out.println(easternNow);

            String easternHtml = getHtml(easternTimeNow);

            String tmp = pacificHtml + montainHtml + centralHtml + easternHtml;

            try (PrintWriter out = new PrintWriter(new FileWriter("clock.html"))) {
                out.println(tmp);
                out.flush();
                //System.out.println("clock" + tmp);
            }

            Thread.sleep(900l);
        }
    }

    private static String getHtml (LocalTime localTime)  {
        String hours = "" + localTime.getHour();
        //System.out.println(hours);

        String minutes = "" + localTime.getMinute();
        minutes = StringUtils.leftPad(minutes, 2, "0");
        //System.out.println(minutes);

        String seconds = "" + localTime.getSecond();
        seconds = StringUtils.leftPad(seconds, 2,"0");
        //System.out.println(seconds);

        String tmp = HTML.replace("%hh%", hours);
        tmp = tmp.replace("%mm%", minutes);
        tmp = tmp.replace("%ss%", seconds);
        //System.out.println(tmp);

        return tmp;
    }

    private static final String HTML = "<html>\n" +
            "<head>\n" +
            "    <title>Clock</title>\n" +
            "    <meta http-equiv=\"refresh\" content=\"0.9\">\n" +
            "</head>\n" +
            "<body>\n" +
            "    <br><br><br>\n" +
            "    <div align=\"center\"><span style=\"font-size:48\">%hh%:%mm%:%ss%</span></div>\n" +
            "</body>\n" +
            "</html>\n" +
            "</html>\n";
}
