
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class test {

	public static void main(String args[]) throws FileNotFoundException, IOException {

		pcb p = null;
		//createFile cf=new createFile();
		reading m1 = new reading();
		FileHandler f = new FileHandler();
		
		Thread t1 = new Thread(m1);
		t1.run();
		pcb[] arrpcb=new pcb[m1.processes.size()];
		

		for(int l=0;l<m1.processes.size();l++){
			int m=m1.processes.get(l).sumcpu;
		
			if(m1.processes.get(l).sumcpu>m1.processes.get(l).sumio){
			 p= new pcb(m1.processes.get(l).id,"new","CPU BOUND",0,0,m1.processes.get(l));
			}
			else if(m1.processes.get(l).sumcpu<m1.processes.get(l).sumio)
			{
					 p= new pcb(m1.processes.get(l).id,"new","IO BOUND",m1.processes.get(l).tad,m1.processes.get(l).tad,m1.processes.get(l));
			}
			
			arrpcb[l]=p;
		}
		
		int[] arrtt=new int[m1.processes.size()];
		int[] arrwt=new int[m1.processes.size()];
		
		CpuScheduler cp=new CpuScheduler();
	cp.roundrobin(m1.processes, m1.start);
	
	FileReader fr = new FileReader("/Users/work/Desktop/turnaroundrr.txt");
	BufferedReader bf = new BufferedReader(fr);
	String[] parts;
	String[] tt;
	String line;
int j=0;
	while ((line = bf.readLine()) != null) {
		
		
		arrtt[j]=Integer.parseInt(line);
		
		j++;
	}
	
int w=0;
		for(int i=0;i<arrpcb.length;i++){
			w=0;
			arrpcb[i].state="terminated";
		

			w=arrpcb[i].p.sumcpu+arrpcb[i].p.sumio;
			arrtt[i]+=arrpcb[i].p.sumcpu+arrpcb[i].p.sumio;
			w=arrtt[i]-w;
			
		System.out.println("PCB ");
		System.out.println("ID : "+arrpcb[i].id);
		System.out.println("STATE : "+arrpcb[i].state);
		System.out.println("JOP NEATURE : "+arrpcb[i].jopNeature);
		System.out.println("TURN AROUND : "+arrtt[i]);
		System.out.println("WAITING TIME : "+w);
		System.out.println();
		}
		
	}

}
