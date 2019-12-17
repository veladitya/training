package life;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.TimeZone;

public class Utils {

	public static void main(String[] args) {
		//instant is always ZULU/GMT
		Instant gmtTime =Instant.parse("2019-12-12T15:38:19.803Z");
		//conver 
		ZonedDateTime  estTimeZone = gmtTime.atZone(ZoneId.of("America/New_York"));
		LocalDateTime localDateTime = estTimeZone.toLocalDateTime();
        System.out.println("GMTTime = " + gmtTime +" in ESTTime ="+ localDateTime );
	}

	private static TimeZone smapleUtils() {
		String s= "WITH SRCH AS ( "
				 + "    SELECT "
				 + "        SRCH_STRT_DT, "
				 + "        SRCH_END_DT, "
				 + "        TRUNC(SRCH_STRT_DT) - 1 + ROWNUM AS OPER_DT, "
				 + "        TRIM(TO_CHAR ((TRUNC(SRCH_STRT_DT) - 1 + ROWNUM), 'DAY')) AS DOW "
				 + "    FROM ALL_OBJECTS "
				 + "    INNER JOIN "
				 + "    ("
				 + "SELECT "
				 + "            TO_TIMESTAMP(:startDate,'YYYY-MM-DD\"T\"HH24:MI:SS') SRCH_STRT_DT, "
				 + "            TO_TIMESTAMP(:endDate,'YYYY-MM-DD\"T\"HH24:MI:SS') SRCH_END_DT "
				 + "        FROM DUAL "
				 + "    ) DTSET ON 1=1 "
				 + "    WHERE SRCH_STRT_DT - 1 + ROWNUM <= SRCH_END_DT "
				 + ") ";
		 
		 System.out.println(s);
		
		 System.out.println( " ==>> "+Instant.now());
		 System.out.println(" ==>> "+Instant.now().atZone(ZoneId.of("GMT")).toInstant());
		compareGMTAndDate();
		DateFormat gmtFormat = new SimpleDateFormat();
		TimeZone gmtTime = TimeZone.getTimeZone("GMT");
		gmtFormat.setTimeZone(gmtTime);
		DateFormat gmtFormat1 = new SimpleDateFormat();
		try {
			System.out.println(gmtFormat1.parse(gmtFormat.format(new Date())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gmtTime;
	}

	private static void compareGMTAndDate() {
		System.out.println(Instant.now());
		//System.out.println(Date.from(Instant.now().atZone(ZoneId.systemDefault()).toLocalDateTime()));
		
		Date date = new Date();
		DateFormat gmtFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		TimeZone gmtTime = TimeZone.getTimeZone("GMT");
		gmtFormat.setTimeZone(gmtTime);
		DateFormat gmtFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			System.out.println(gmtFormat1.parse(gmtFormat.format(date)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void getLastDateOfMonth() {
		Date dateToConvert = new Date();

		LocalDate lastDayOfMonth = dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
				.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println(lastDayOfMonth.getDayOfWeek());
	}
}
