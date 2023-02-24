
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 2.3
 * @author ArenasA
 *
 */
public class ThreadTime {

  public static void main(String[] args) {
    //DateFormat df = new SimpleDateFormat("HH:mm:ss");
    Thread thread = new Thread(new MonRunnable(1000));

    //System.out.println(df.format(new Date()));

    thread.start();
  }

  private static class MonRunnable implements Runnable {

    private long delai;

    public MonRunnable(long delai) {
      this.delai = delai;
    }

    @Override
    public void run() {
    	DateFormat df = new SimpleDateFormat("HH:mm:ss.SSS");
    	while(true) {
	      try {
	        Thread.sleep(delai);
	        System.out.print(df.format(new Date())+"\r");
	        //System.out.println("-");
	      } catch (InterruptedException e) {
	        e.printStackTrace();
	      }
    	}
    }
  }
}