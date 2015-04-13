package au.id.jimvella;

import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYSeries;
import org.junit.Test;

import au.id.jimvella.plot.JFramePlot;

public class PlotTest {


	@Test
	public void main() throws InterruptedException{
		
		JFramePlot frame = new JFramePlot("Test");
		frame.add(1,1);
		frame.add(2, 2);
		Thread.sleep(3000);
		frame.add(3, 5);
		Thread.sleep(3000);
		
		synchronized(frame){ 
			frame.wait();
		}
	}
	
}
