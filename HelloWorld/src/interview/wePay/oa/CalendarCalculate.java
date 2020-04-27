package interview.wePay.oa;

import java.util.Calendar;

/**
 * 计算某一年的第十个月的第二个星期二是第几号
 */
public class CalendarCalculate {

    public int calculate(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, 9);
        calendar.set(Calendar.WEEK_OF_MONTH, 1);
        calendar.set(Calendar.DAY_OF_WEEK, 3);
        int date = calendar.get(Calendar.DAY_OF_MONTH);
        if (date <= 3 ) {
            calendar.set(Calendar.WEEK_OF_MONTH, 2);
        }else {
            calendar.add(Calendar.MONTH,1);
            calendar.set(Calendar.WEEK_OF_MONTH, 3);
        }
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static void main(String[] args) {
        CalendarCalculate calendarCalculate = new CalendarCalculate();
        System.out.println(calendarCalculate.calculate(1943));
        System.out.println(calendarCalculate.calculate(1944));
        System.out.println(calendarCalculate.calculate(1945));
        System.out.println(calendarCalculate.calculate(1946));
        System.out.println(calendarCalculate.calculate(1947));
        System.out.println(calendarCalculate.calculate(2019));
        System.out.println(calendarCalculate.calculate(2018));
        System.out.println(calendarCalculate.calculate(2017));
    }
}
