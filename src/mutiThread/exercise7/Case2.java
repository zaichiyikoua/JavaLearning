package mutiThread.exercise7;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
*	多线程核心   练习题2
*	@author  zaichiyikoua
*	@time  2019年12月31日
*	@description  { SimpleDateFormat非线程安全 }
*/

public class Case2 extends Thread {
    // 利用Threadlocal来解决SimpleDateFormat的非线程安全问题

    @SuppressWarnings("unused")
    private SimpleDateFormat format;
    private String dateString;

    public Case2(SimpleDateFormat format, String dateString) {
        super();
        this.format = format;
        this.dateString = dateString;
    }

    @SuppressWarnings("unused")
    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            Date parse = DateUtil.getSimpleDateFormat("yyyy-MM-DD").parse(dateString);
            String string = DateUtil.getSimpleDateFormat("yyyy-MM-DD").format(parse).toString();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}

class DateUtil {
    private static ThreadLocal<SimpleDateFormat> local = new ThreadLocal<SimpleDateFormat>();

    public static SimpleDateFormat getSimpleDateFormat(String datePattern) {
        SimpleDateFormat format = null;
        format = local.get();
        if (format == null) {
            format = new SimpleDateFormat(datePattern);
            local.set(format);
        }
        return format;
    }
}
