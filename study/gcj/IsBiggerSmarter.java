package gcj;
import java.io.IOException;

public class IsBiggerSmarter implements Runnable {
	static String ReadLn(int maxLength) { // utility function to read from
											// stdin,
											// Provided by
											// Programming-challenges, edit for
											// style only
		byte line[] = new byte[maxLength];
		int length = 0;
		int input = -1;
		try {
			while (length < maxLength) {// Read untill maxlength
				input = System.in.read();
				if ((input < 0) || (input == '\n'))
					break; // or untill end of line ninput
				line[length++] += input;
			}

			if ((input < 0) && (length == 0))
				return null; // eof
			return new String(line, 0, length);
		} catch (IOException e) {
			return null;
		}
	}

	public static void main(String args[]) // entry point from OS
	{
		IsBiggerSmarter myWork = new IsBiggerSmarter(); // Construct the
														// bootloader
		myWork.run(); // execute
	}

	public void run() {
		new myStuff().run();
	}
}

class myStuff implements Runnable {
	public void run() {
		String line;
		while ((line = IsBiggerSmarter.ReadLn(500)) != null) {
			String aaa[] = line.split("\\s");
			int startNum = Integer.parseInt(aaa[0]);
			int endNum = Integer.parseInt(aaa[1]);
			System.out.println(startNum + " " + endNum + " " + dojob(startNum, endNum));

		}
		
		
//		Scanner in = new Scanner(System.in);
//		while (true) {
//			try {
//				int startNum = in.nextInt();
//				int endNum = in.nextInt();
//				int max = dojob(startNum, endNum);
//				System.out.println(startNum + " " + endNum + " " + max);
//			} catch (NoSuchElementException e) {
//				break;
//			}
//
//
//			}
//		}
	}

	public int dojob(int s, int e) {
		int maxIndex = 1;
		for (int i = s; i <=e; i++){
			int data = i;
			int index = 1;
			while(data != 1){
				if (data % 2 == 1) data = data*3 + 1;
				else {
					data = data/2;
				}
				index++;
			}
			if (index > maxIndex) maxIndex = index;
		}
		return maxIndex;

	}

}
