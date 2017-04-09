
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class process {
	int id;
	int arrivealtime;
	int size;
	int sumcpu;
	int sumio;
	Queue<Integer> cpu = (Queue<Integer>) new LinkedList<Integer>();
	Queue<Integer> io = (Queue<Integer>) new LinkedList<Integer>();
	int tad;
boolean isdone;
	
	

	public process(int id, int arrivealtime, int size, int sumcpu, int sumio, Queue<Integer> cpu, Queue<Integer> io) {
		super();
		this.id = id;
		this.arrivealtime = arrivealtime;
		this.size = size;
		this.sumcpu = sumcpu;
		this.sumio = sumio;
		this.cpu = cpu;
		this.io = io;
		
		this.isdone=false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getArrivealtime() {
		return arrivealtime;
	}

	public void setArrivealtime(int arrivealtime) {
		this.arrivealtime = arrivealtime;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Queue<Integer> getCpu() {
		return cpu;
	}

	public void setCpu(Queue<Integer> cpu) {
		this.cpu = cpu;
	}

	public Queue<Integer> getIo() {
		return io;
	}

	public void setIo(Queue<Integer> io) {
		this.io = io;
	}
}
