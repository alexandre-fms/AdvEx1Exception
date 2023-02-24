import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FoundException {

	public static void main(String[] args){
		Date date = null;
		Date today = new Date();
		
		List<Date> dateList = new ArrayList<Date>();
		dateList.add(date);
		dateList.add(today);

		
		for(Date ladate: dateList) {
			test1(ladate);
		}
	}
	
	public static void test1(Date date){
		try {
			System.out.println(date.getClass().getName());
		} catch (NullPointerException e) {
			
			e.printStackTrace();
			System.out.println("ha ben mince, c'est cassé.");
		}
	}
	
	

}
