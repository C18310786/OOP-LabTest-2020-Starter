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
		float leftborder = 200;
		float rectHeight = 35;

		textAlign(CENTER, CENTER);
		for(int i = 0; i < 30; i++)
		{
			stroke(255);
			float x = map(i, 1, 31, leftborder , width - border);
			float y = map(i, 9, 0, height - border, 110);
			line(x, border - 40, x, height - 40);
			fill(255);
			text(i + 1, x, border / 2);
			if(i < 9)
			{
				noStroke();
				Tasks tsk = task.get(i);
				text(tsk.getTask(), border / 2, y);
				float start = map(tsk.getStart(), 2, 32, leftborder , width - border );
				float end = map(tsk.getEnd(), 2, 32, leftborder , width - border);
				float widthRect = end - start;
				float colour = map(i, 0, 9, 0, 255);
				fill(colour, 255, 255);
				rect(start, y - rectHeight / 2, widthRect, rectHeight, 5);
			}
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
		colorMode(HSB);
	}
	
	public void draw()
	{			
		background(0);
		displayTasks();
	}
}
