package com.stephen.springboot.util;

import java.time.Duration;

public class TimeUtil {

    // Utility Class (have static methods) - non-instantiable
    private TimeUtil() {}

    public static String format(Duration duration, boolean includeSeconds, boolean includeColon) {
        Duration dur = duration;
        StringBuilder builder = new StringBuilder(dur.toHours()+":"+dur.toMinutesPart());

        if (includeSeconds) {
            if(includeColon){
                builder.append(':');
            }

            builder.append(dur.toSecondsPart());
        }

        if (!includeColon) {
           return builder.toString().replace(":", "");
        }

        return builder.toString();
    }

//        Map<String, Object> filterMap = new HashMap<>();
//        filterMap.put("startDate", Instant.now());
//
//        ZonedDateTime startDate = ZonedDateTime.ofInstant((Instant)filterMap.get("startDate"), ZoneOffset.UTC);
//
//        System.out.println("startDate = " + startDate);
//        Duration dur = Duration.ofHours(1);
//
//        System.out.println("JODA DATE(-1) = " + new DateTime(-1));
//        System.out.println("JODA DATE(normal) = " + new DateTime());
//        System.out.println("JODA DATE(0) = " + new DateTime(0));
//
//        System.out.println("ZONED DATE(-1) = " + Instant.EPOCH.atZone(ZoneId.systemDefault()).minus(1, ChronoUnit.MILLIS));
//        System.out.println("ZONED DATE(normal)= " + ZonedDateTime.now());
//        System.out.println("ZONED DATE(0)= " + Instant.EPOCH.atZone(ZoneId.systemDefault()));
//        System.out.println("ZONED DATE(getlastday)= " + ZonedDateTime.now().getDayOfMonth());
//        System.out.println("ZONED DATE(last day of month)= " + ZonedDateTime.now().toLocalDate().with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth());
//
//        System.out.println("Duration(1 Hour) " + dur);
//        System.out.println("Duration(getSeconds) " + dur.getSeconds());

//        DateTime da = new DateTime(Calendar.getInstance().getTimeInMillis());
//        ZonedDateTime za = ZonedDateTime.now();
//
//        System.out.println("JODA DateTime " + da);
//        System.out.println("ZonedDateTime " + za);
//        DateTimeZone dz = DateTimeZone.forID("Africa/Abidjan");
//        ZoneId zz = ZoneId.of("Africa/Abidjan");
//
//        int rawOffset = zz.getRules().getOffset(ZonedDateTime.now().toInstant()).get(ChronoField.OFFSET_SECONDS);
//        int offset = dz.getOffset(new Date().getTime());
//
//        System.out.println("OFFSET(java time) = " + rawOffset);
//        System.out.println("OFFSET(joda time) = " + offset);

//        org.joda.time.Duration dur = new org.joda.time.Duration(1000000000000L);
//        java.time.Duration duration = java.time.Duration.ofMillis(1000000000000L);
////
//        System.out.println("Duration JODA(no-format) = " + dur.getMillis());
//        System.out.println("Duration Java(no-format) = " + duration.toMillis());
//
//        PeriodFormatter time = new PeriodFormatterBuilder()
//                .minimumPrintedDigits(2).appendHours().appendSuffix("h ")
//                .printZeroAlways().minimumPrintedDigits(2).appendMinutes().appendSuffix("m")
//                .toFormatter();
//
//        String jodaDurationFormat = time.print(dur.toPeriod());
//        String otherDurationFormat = AmountFormats.wordBased(duration, Locale.getDefault());
//        String javaDurationFormat = String.format("%dh %dm", duration.toHours(), duration.toMinutesPart());
//
//        System.out.println("Duration JODA = " + jodaDurationFormat);
//        System.out.println("Duration Java = " + javaDurationFormat);

//        System.out.println("FORMAT OLD = " + TimeUtil.format(duration, true, true));
//        System.out.println("FORMAT noSeconds = " + TimeUtil.format(duration, false, true));
//        System.out.println("FORMAT noColons = " + TimeUtil.format(duration, true, false));
//        System.out.println("FORMAT noBoth = " + TimeUtil.format(duration, false, false));
}
