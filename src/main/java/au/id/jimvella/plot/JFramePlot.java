package au.id.jimvella.plot;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class JFramePlot extends JFrame{

	XYSeries dataset;
	
	public JFramePlot(String title){
		this.dataset = new XYSeries(title);
		
		boolean legend = true;
		boolean tooltips = true;
		boolean urls = false;
		JFreeChart chart = ChartFactory.createXYLineChart(title, "N", "Exexution (s)", new XYSeriesCollection(dataset), PlotOrientation.HORIZONTAL, 
				legend, tooltips, urls);
		
		chart.getPlot().setBackgroundPaint(Color.white);
		chart.getXYPlot().setDomainGridlinePaint(Color.gray);
		chart.getXYPlot().setRangeGridlinePaint(Color.gray);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
        
        pack();
		setVisible(true);
	}
	
	public void add(double x, double y){
		dataset.add(x, y);
	}
}
