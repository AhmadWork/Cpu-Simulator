import java.io.IOException;
import java.util.LinkedList;

public class reading implements Runnable {
	long start;

	FileHandler f = new FileHandler();
	LinkedList<process> processes = new LinkedList<process>();

	@Override
	public void run() {

		try {
			start = System.currentTimeMillis();
			processes = FileHandler.readProcesses();

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
