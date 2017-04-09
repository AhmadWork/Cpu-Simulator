import java.util.*;

import org.omg.Messaging.SyncScopeHelper;

import java.lang.*;
import java.lang.reflect.Array;
import java.io.*;
import java.util.Arrays;

public class CpuScheduler {

	public <T> void sjf(LinkedList<process> processes, long start) throws FileNotFoundException, UnsupportedEncodingException {
		float cput=0;
		long avgWaiting=0;
		int que=0;
		int cm = 0;
		int cpt=7; 
		PrintWriter write = new PrintWriter("/Users/work/Desktop/turnaroundsjf.txt", "UTF-8");
		ArrayList<process> m = new<process> ArrayList();

		process[] arrprocess = new process[processes.size()];
		Queue<Integer> io = new LinkedList<Integer>();
		
		int i = 0;
		
		long timer=0;
		while (!processes.isEmpty()) {
			long end = System.currentTimeMillis();
		 timer = end - start;
			process p = (process) processes.remove();

			// System.out.println(timer);
			if (timer < p.arrivealtime) {
				processes.add(p);
			} else if (timer == p.arrivealtime) {
				que++;
				m.add(p);
				System.out.println("arrivalTime: " + p.arrivealtime);
				System.out.println("Time: " + timer);
				while (!p.io.isEmpty())
					io.add(p.io.remove());

				System.out.println("process has been added");
				i++;
			} else {
				while (!p.io.isEmpty())
					io.add(p.io.remove());
			m.add(p);
				System.out.println("process has been added");
				i++;
			}
		
			for(int q=0;q<m.size();q++){
				
				arrprocess[q]=m.get(q);
		
			}
			for (int j = 0; j < i; j++) {
				for (int t = 0; t < j; t++) {

					if (arrprocess[j].sumcpu > arrprocess[t].sumcpu) {
						process tmp = arrprocess[j];
						arrprocess[j] = arrprocess[t];
						arrprocess[t] = tmp;

					}
					
				}
				
			}
			for (int j = 0; j < i; j++) {
			if(j>0)
				 cm=arrprocess[j-1].arrivealtime+arrprocess[j-1].sumcpu;
				if(cm>arrprocess[j].arrivealtime)
				
					que=arrprocess[j].sumcpu;
			}
			for(int q = 0; q < i; q++){
			
				if(!arrprocess[q].isdone){
					
					arrprocess[q].tad=arrprocess[q].sumcpu+arrprocess[q].sumio;
					arrprocess[q].tad+=System.currentTimeMillis()-end;
					arrprocess[q].tad=arrprocess[q].sumcpu+arrprocess[q].sumio;
					if(q>1)
						
					que+=arrprocess[q-1].sumcpu;
					arrprocess[q].tad+=System.currentTimeMillis()-end;
					cput+=100*arrprocess[q].sumcpu/arrprocess[q].tad;
					avgWaiting+=arrprocess[q].tad-20;
					
					for(int t = 0; t < arrprocess[q].sumcpu; t++);;
					System.out.println("process TurnAround Time "+arrprocess[q].tad);
					write.println(que);
					System.out.println("process No#"+arrprocess[q].id+" has been termniated");
					
					arrprocess[q].isdone=true;
					break;
			}
			
		}
		}
		System.out.println("___________________________________________________________ ");
		System.out.println("The Averge Waiting For Shortest Job First Is : "+avgWaiting/20);
		System.out.println("");
		System.out.println("The CPU UTILIZATION For Round Robin Is : "+cput+"%");
		write.close();
		}	
		
	public <T> void roundrobin(LinkedList<process> processes,long start ) throws FileNotFoundException, UnsupportedEncodingException{
		//	System.out.println("hi");
		
			Queue<process> rr = new LinkedList<process>();
			Queue<Integer> io = new LinkedList<Integer>();
			PrintWriter write = new PrintWriter("/Users/work/Desktop/turnaroundrr.txt", "UTF-8");
			float cput=0;
			long end=0;
			long avgWaiting=0;
			int que=0;
		while(!processes.isEmpty()){

				process p=(process) processes.remove();
				 end =System.currentTimeMillis();
				long timer=end-start;
				//System.out.println(timer);
	if(timer<p.arrivealtime){
		processes.add(p);
	}
	
	else if(timer==p.arrivealtime){		
		que+=6;
		System.out.println("arrivalTime: "+p.arrivealtime);
		System.out.println("Time: "+timer);
				while(!p.io.isEmpty())
	io.add(p.io.remove());
				rr.add(p);
				System.out.println("process has been added");
				int n=0;
				System.out.println("process No"+n++);
	}
	else{
		que+=timer-p.arrivealtime;
		rr.add(p);
	}
			}
		
			while(!rr.isEmpty()){
				
				process m=rr.remove();
				
				m.tad++;
				if(m.cpu.size()>0){
				int f=m.cpu.remove();
				
			if(f==1&& m.cpu.size()==1){
				m.cpu.remove();
			
			}
		
			if(f>10){
				
				for(long i1=0;i1<10;i1++);
		        	

					//System.out.println("hi");
					
					//System.out.println("cpu burst "+m.arrivealtime+" :" +f);
					f-=10;
					//System.out.println("cpu burst back with :" +f);	
					m.cpu.add(f);
					que+=1;
					}
					else{
		            	if(f>0){
		            	
		            		for(long j1=0;j1<f;j1++);
		            		
		            		//System.out.println("cpu burst "+m.arrivealtime+" :"+f);
		    				
		            		f=0;
		            		
		            	
		            	}
					}
		
				if(!m.cpu.isEmpty()){
				rr.add(m);
				//System.out.println("");
				/*System.out.println("_______________________________");

				System.out.println("processNO#"+m.id+" re added");
				System.out.println("_______________________________");
				*/
				}
			
		
				else{
				
				
					cput+=100*m.sumcpu/m.tad;
					
					avgWaiting+=m.tad;
		
					write.println(que);
					System.out.println("");
					System.out.println("process NO#"+m.id+" TurnAround Time "+m.tad);
				
			
				System.out.println("process No#"+m.id+" has been termniated");
				}
				m.tad=m.sumcpu+m.sumio;
				
					
				}
				}
			write.close();
		while(!io.isEmpty()){
				//System.out.println("hi");
				for(long z=0;z<io.peek();z++);
					
						io.remove();
						
					}System.out.println("___________________________________________________________ ");
		System.out.println("The Averge Waiting For Round Robin Is : "+avgWaiting/20);
		System.out.println("");
		System.out.println("The CPU UTILIZATION For Round Robin Is : "+cput+"%");
		
				}
	
	}


class FileHandler {
	public static LinkedList<process> readProcesses() throws FileNotFoundException, IOException {
		LinkedList<process> data = new LinkedList<process>();
		FileReader fr = new FileReader("/Users/work/Desktop/u2.txt");
		BufferedReader bf = new BufferedReader(fr);
		String line;
		String[] parts;
		String[] cp;
		String[] ios;
		Queue<Integer> io;
		Queue<Integer> cpu;
		int q = 0;
		int g = 0;
		int k=0;
		while ((line = bf.readLine()) != null) {
			io = (Queue<Integer>) new LinkedList<Integer>();
			cpu = (Queue<Integer>) new LinkedList<Integer>();
			parts = line.split(";");
			for (String b : parts) {
				q += Integer.parseInt(parts[2]);
				/*
				  if(q>1024){ System.out.println("Memory is Full!!!!");
				  
				  
				  }
				 */
				if (b.contains("CPU:")) {
					cp = b.split(":");
					cpu.add(Integer.parseInt(cp[1]));
				}
				if (b.contains("IO:")) {
					ios = b.split(":");
					io.add(Integer.parseInt(ios[1]));
				}
				k = 0;
				int isize = io.size();
				for (int l = 0; l < isize; l++) {
					int tmp = io.remove();
					k+= tmp;
					io.add(tmp);
				}
				g = 0;
				int csize = cpu.size();
				for (int i = 0; i < csize; i++) {
					int tmp = cpu.remove();
					g+= tmp;
					cpu.add(tmp);
				}
				

			}

			process p = new process(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]),
					g,k,cpu, io);
			data.add(p);
		}
		
		bf.close();
		return data;
	}
}
