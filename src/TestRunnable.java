/**
 * 2.2
 * @author ArenasA
 *
 */
public class TestRunnable implements Runnable {


	@Override
	public void run() {
		String test[] = {"!*!", "\"**\"", "#***#", "$****$", "%*****%", "&******&",
				"'*******'", "(********(", ")*********)", "************"};
		for(int i = 0; i < test.length; i++) {
			System.out.println(test[i]);
		}
	}
	
	
	public static void main(String[] args) {		
		Thread thread = new Thread(new TestRunnable());
		thread.start();
	}

}
