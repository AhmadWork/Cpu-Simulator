import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class createFile {
	int sizeMemory = 1024;
	int arrivalTime;
	int cpuBurstTime, ioBurstTime;
	int idProcess = 1;
	int bursts, range;
	Random r = new Random();

	public createFile(int sizeMemory, int arrivalTime, int cpuBurstTime, int ioBurstTime, int idProcess, int bursts,
			int range, Random r) {
		this.sizeMemory = sizeMemory;
		this.arrivalTime = arrivalTime;
		this.cpuBurstTime = cpuBurstTime;
		this.ioBurstTime = ioBurstTime;
		this.idProcess = idProcess;
		this.bursts = bursts;
		this.range = range;
		this.r = r;
	}

	public createFile() throws UnsupportedEncodingException {
		try {
			PrintWriter write = new PrintWriter("/Users/work/Desktop/u2.txt", "UTF-8");
			for (int i = 0; i < 20; i++) {
				if(sizeMemory>128){
				bursts = r.nextInt(5 - 1 + 1) + 1;
				arrivalTime = r.nextInt(100 - 1 + 1) + 1;
				range = r.nextInt(128 - 1 + 1) + 1;
				write.print(idProcess + ";");
				write.print(arrivalTime + ";");
				write.print(range + ";");
				for (int ii = 0; ii < bursts; ii++) {
					cpuBurstTime = r.nextInt(100 - 16 + 1) + 16;
					ioBurstTime = r.nextInt(200 - 15 + 1) + 15;
					write.print("CPU:" + cpuBurstTime + ";");
					//write.print("IO:" + ioBurstTime + ";");
					
				}
				write.println("CPU:" + "1");
				}
				idProcess++;
				sizeMemory = sizeMemory - range;
			}
			write.close();
		} catch (FileNotFoundException fileNotFound) {
			System.out.println("Can't find the file");
		}
	}
}