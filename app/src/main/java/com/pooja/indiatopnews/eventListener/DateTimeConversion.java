package com.pooja.indiatopnews.eventListener;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeConversion {

    public String DateFormat_ddMMyyyy(String dateTime){
        String formatedDate="";
        try {
            String dDate = "1900-01-01T00:00:00";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            SimpleDateFormat simpleDateFormatOut = new SimpleDateFormat("dd/MM/yyyy");
            Date mDateTime = null;
            Date comareTo = simpleDateFormat.parse(dDate);
            try {
                mDateTime = simpleDateFormat.parse(dateTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (comareTo.compareTo(mDateTime)<0){
                formatedDate = simpleDateFormatOut.format(mDateTime);
            }else {
                formatedDate = "--/--/----";
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return formatedDate;
    }
    public String DateFormat_ddMMyyyyHHmm(String dateTime){
        String formatedDate="";
        try {
            String dDate = "2018-06-06T17:45:00";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            SimpleDateFormat simpleDateFormatOut = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Date mDateTime = null;
            try {
                mDateTime = simpleDateFormat.parse(dateTime);
            } catch (ParseException e) {
              //  Crashlytics.logException(e);
                e.printStackTrace();
            }
            formatedDate = simpleDateFormatOut.format(mDateTime);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return formatedDate;
    }

    public String DateFormat_yyyyMMdd(String dateTime){
        String formatedDate="";
        try {
            String dDate = "2018-06-06T17:45:00";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            SimpleDateFormat simpleDateFormatOut = new SimpleDateFormat("yyyy-MM-dd");
            Date mDateTime = null;
            try {
                mDateTime = simpleDateFormat.parse(dateTime);
            } catch (ParseException e) {

                e.printStackTrace();
            }
            formatedDate = simpleDateFormatOut.format(mDateTime);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return formatedDate;
    }

    public String DateFormat_ddMMyyyyHHmmAM_PM(String dateTime){
        String formatedDate="";
        try {
            String dDate = "2018-06-06T17:45:00";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            SimpleDateFormat simpleDateFormatOut = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");
            Date mDateTime = null;
            try {
                mDateTime = simpleDateFormat.parse(dateTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            formatedDate = simpleDateFormatOut.format(mDateTime);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return formatedDate;
    }
    public String DateFormat_ddMMyyyyHHmmssAM_PM(String dateTime){
        String formatedDate="";
        try {
            String dDate = "2018-06-06T17:45:00";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            SimpleDateFormat simpleDateFormatOut = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa");
            Date mDateTime = null;
            try {
                mDateTime = simpleDateFormat.parse(dateTime);
            } catch (ParseException e) {

                e.printStackTrace();
            }
            formatedDate = simpleDateFormatOut.format(mDateTime);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return formatedDate;
    }
    public String DateFormat_HHmm(String dateTime){
        String formatedDate="";
        try {
            String dDate = "2018-06-06T17:45:00";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            SimpleDateFormat simpleDateFormatOut = new SimpleDateFormat("HH:mm");
            Date mDateTime = null;
            try {
                mDateTime = simpleDateFormat.parse(dateTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            formatedDate = simpleDateFormatOut.format(mDateTime);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return formatedDate;
    }
    public String DateFormat_HHmmAM(String dateTime){
        String formatedDate="";
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            SimpleDateFormat simpleDateFormatOut = new SimpleDateFormat("hh:mm aa");
            Date mDateTime = null;
            try {
                mDateTime = simpleDateFormat.parse(dateTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            formatedDate = simpleDateFormatOut.format(mDateTime);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return formatedDate;
    }

    public String DateFormatString_HHmm(String dateTime){
        String formatedDate="";
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
            SimpleDateFormat simpleDateFormatOut = new SimpleDateFormat("HH:mm");
            Date mDateTime = null;
            try {
                mDateTime = simpleDateFormat.parse(dateTime);
            } catch (Exception ex){
                ex.printStackTrace();
            }
            formatedDate = simpleDateFormatOut.format(mDateTime);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return formatedDate;
    }

    public String DateFormatString_ddMMyyyHHmm(String dateTime){
        String formatedDate="";
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
            SimpleDateFormat simpleDateFormatOut = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Date mDateTime = null;
            try {
                mDateTime = simpleDateFormat.parse(dateTime);
            } catch (ParseException e) {

                e.printStackTrace();
            }
            formatedDate = simpleDateFormatOut.format(mDateTime);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return formatedDate;
    }

    public String DateFormatString_ddMMyyy(String dateTime){
        String formatedDate="";
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat simpleDateFormatOut = new SimpleDateFormat("dd/MM/yyyy");
            Date mDateTime = null;
            try {
                mDateTime = simpleDateFormat.parse(dateTime);
            } catch (ParseException e) {

                e.printStackTrace();
                return "";
            }
            formatedDate = simpleDateFormatOut.format(mDateTime);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return formatedDate;
    }
    public String DateFormatString_yyyyMMdd(String dateTime){
        String formatedDate="";
        try {
            SimpleDateFormat simpleDateFormatOut = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date mDateTime = null;
            try {
                mDateTime = simpleDateFormat.parse(dateTime);
            } catch (ParseException e) {

                e.printStackTrace();
                return "";
            }
            formatedDate = simpleDateFormatOut.format(mDateTime);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return formatedDate;
    }
    public String DateFormatString_yyyyMMddToddMMyyyy(String dateTime){
        String formatedDate= "";
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            SimpleDateFormat simpleDateFormatOut = new SimpleDateFormat("dd/MM/yyyy");
            Date mDateTime = null;
            try {
                mDateTime = simpleDateFormat.parse(dateTime);
            } catch (ParseException e) {
                e.printStackTrace();
                return "";
            }
            formatedDate = simpleDateFormatOut.format(mDateTime);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return formatedDate;
    }

    public String DateFormatString_ddMMyyyyToyyyyMMdd(String dateTime){
        String formatedDate="";
        try {
            SimpleDateFormat simpleDateFormatOut = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date mDateTime = null;
            try {
                mDateTime = simpleDateFormat.parse(dateTime);
            } catch (ParseException e) {

                e.printStackTrace();
                return "";
            }
            formatedDate = simpleDateFormatOut.format(mDateTime);
        }catch (Exception ex){

        }
        return formatedDate;
    }

    public String DateFormatString_ddMMyyyyToMMyyyy(String dateTime){
        String formatedDate="";
        try {
            SimpleDateFormat simpleDateFormatOut = new SimpleDateFormat("MMyyyy");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yyyy");
            Date mDateTime = null;
            try {
                mDateTime = simpleDateFormat.parse(dateTime);
            } catch (ParseException e) {
                e.printStackTrace();
                return "";
            }
            formatedDate = simpleDateFormatOut.format(mDateTime);
        }catch (Exception ex){
        }
        return formatedDate;
    }

    public String DateFormat_ddMMyyyHHmm(String dateTime){
        String formatedDate="";
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            SimpleDateFormat simpleDateFormatOut = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Date mDateTime = null;
            try {
                mDateTime = simpleDateFormat.parse(dateTime);
            } catch (ParseException e) {
                e.printStackTrace();
                return "";
            }
            formatedDate = simpleDateFormatOut.format(mDateTime);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return formatedDate;
    }

    public String getDayFromDate_ddMMyyy(String date){
        String finalDay="";
        try {
            SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
            Date dt1 = null;
            try {
                dt1 = format1.parse(date);
            } catch (ParseException e) {

                e.printStackTrace();
            }
            DateFormat format2 = new SimpleDateFormat("EEEE");
            finalDay = format2.format(dt1);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return finalDay;
    }
    public String getDateyyyyMMdd() {
        String Datetime="";
        try {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat dates = new SimpleDateFormat("yyyy-MM-dd");
            Datetime = dates.format(c.getTime());
        }catch (Exception ex){

        }
        return Datetime;
    }
    public String getDateddMMyyHHmmss() {
        String Datetime="";
        try {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat dates = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Datetime = dates.format(c.getTime());
        }catch (Exception ex){
            ex.printStackTrace();

        }
        return Datetime;
    }

    public String getDateyyyyMMddHHmmss() {
        String Datetime="";
        try {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat dates = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Datetime = dates.format(c.getTime());
        }catch (Exception ex){
            ex.printStackTrace();

        }
        return Datetime;
    }

    public String getDateyyyyMM() {
        String Datetime="";
        try {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat dates = new SimpleDateFormat("yyyyMM");
            Datetime = dates.format(c.getTime());
        }catch (Exception ex){
            ex.printStackTrace();

        }
        return Datetime;
    }

    public long minuteDifference(Date startDate, Date endDate)
    {
        long elapsedMinutes=0;
        try {
            long different = endDate.getTime() - startDate.getTime();
            long secondsInMilli = 1000;
            long minutesInMilli = secondsInMilli * 60;

            elapsedMinutes = different / minutesInMilli;
        }catch (Exception ex){
            ex.printStackTrace();

        }
        return elapsedMinutes;
    }

    public int dateDifference(Date lastDateTime){
        long dayCount=0;
        try {
            Calendar calendar = Calendar.getInstance();
            Date currentDate = null;
            SimpleDateFormat dates = new SimpleDateFormat("yyyy-MM-dd");
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

                currentDate = dates.parse(simpleDateFormat.format(calendar.getTime()));
            } catch (ParseException e) {

                e.printStackTrace();
            }
            long different = currentDate.getTime() - lastDateTime.getTime();
            dayCount = (long) different / (24 * 60 * 60 * 1000);
        }catch (Exception ex){
            ex.printStackTrace();

        }
        return  (int)dayCount;
    }
}
