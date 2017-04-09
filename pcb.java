public class pcb {
	int id;
	String state;
	String jopNeature;
	double turnaroundTime;
	double waitingTime;
	process p;

	public pcb(int id, String state, String jopNeature, double turnaroundTime, double waitingTime,process p) {
		this.id = id;
		this.state = state;
		this.jopNeature = jopNeature;
		this.turnaroundTime = turnaroundTime;
		this.waitingTime = waitingTime;
		this.p=p;
	}

}