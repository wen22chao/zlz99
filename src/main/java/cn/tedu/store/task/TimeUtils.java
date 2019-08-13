package cn.tedu.store.task;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

	public static String getTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String string = sdf.format(date);
		return string;
	}

}
