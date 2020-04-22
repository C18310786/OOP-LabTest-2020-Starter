package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	
	ArrayList<Tasks> task = new ArrayList<Tasks>();

	public void settings()
	{
		size(1200, 800);
	}

	public void loadTasks()
	{
		Table t = loadTable("tasks.csv", "header");

		for(TableRow tr:t.rows())
		{
			Tasks tsk = new Tasks(tr);
			task.add(tsk);
		}
	}

	public void printTasks()
	{
		for(Tasks tsk:task)
		{
			println(tsk);
		}
	}

	public void displayTasks()
	{
		float border = width * 0.10f;

		stroke(255, 255, 255);
		textAlign(CENTER, CENTER);
		for(int i = 0; i <= 30; i++)
		{
			float x = map(i, 0, 30, 200, width - border);
			line(x, border - 30, x, height - 25);
			fill(255);
			text(i, x, border / 2);
		}

		for(int i = 0; i < 9; i++)
		{
			Tasks tsk = task.get(i);

			float y = map(i, 1, 9, height - border, 110);
			rect(100, y, 200, y);
			text(tsk.getTask(), border / 2, y);
		
		}
	}
	
	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}

	
	
	public void setup() 
	{
		loadTasks();
		printTasks();
	}
	
	public void draw()
	{			
		background(0);
		displayTasks();
	}
}
