import java.util.Calendar;
import java.util.Date;

/**
 * Assignment#2
 * @author ªLÞ³ÂE
 * StudentID : 403530045
 * Description : Implement Gauss's algorithm and calculate Ash Wednesday
 */
public class AshWednesday 
{
	/**
	 * private constructor: class can't be instantiated(create an object) 
	 */
	private AshWednesday()
	{
	}
	/** 
	 * calculate Easter and Ash Wednesday
	 * @parameter selectYear specify the year we want to calculate 
	 * @return AshWednesday after calculation 
	 */
	public static String calculateAshWednesday(int selectYear)
	{
		Date dt,dt2; // store the year,month,date
		Calendar cal = Calendar.getInstance(); // calendar can modify the date
	    String ashWed_str;
		String east_str;
		int Y = selectYear, M = 24, N = 5; //Gauss's algorithm
		int a,b,c,d,e;
		a = Y % 19;
		b = Y % 4;
		c = Y % 7;
		d = (19*a + M) % 30;
		e = (2*b + 4*c + 6*d + N) % 7;
		if(d + e < 10)
		{
			east_str = "In " + selectYear + ", Easter is: month = 3 and day = " + (d+e+22);
			System.out.println(east_str);
			
			dt = new Date(Y,3-1,d+e+22);// '2' actual equals to May(2+1)
			cal.setTime(dt);
			cal.add(Calendar.DATE, -46);
			dt2 = cal.getTime();
			
			ashWed_str = "In " + selectYear + ", Ash Wednesday is: month = "+ (dt2.getMonth()+1) + " and day = " + dt2.getDate();
		
		}
		else
		{
			east_str = "In " + selectYear + ", Easter is: month = 4 and day = " + (d+e-9);
			System.out.println(east_str);
			
			dt = new Date(Y,4-1,d+e-9);
			cal.setTime(dt);
			cal.add(Calendar.DATE, -46);
			dt2 = cal.getTime();
			ashWed_str = "In " + selectYear + ", Ash Wednesday is: month = "+ (dt2.getMonth()+1) + " and day = " + dt2.getDate();
			// getMonth() return the number 0-11 needed to plus one and will equal to actual month
		}
		
		return ashWed_str;
		
		
	}
	
}
