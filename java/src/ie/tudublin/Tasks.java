package ie.tudublin;

import processing.data.TableRow;

public class Tasks {
    private String task;
    private int start;
    private int end;

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public Tasks(String task, int start, int end)
    {
        this.task = task;
        this.start = start;
        this.end = end;
    }

    public Tasks()
    {
        this("", 0, 0);
    }

    public Tasks(TableRow tr)
    {
        tr.getString("Task");
        tr.getInt("Start");
        tr.getInt("End");
    }

    public String toString()
    {
        return "Task: " + this.task + " Start: " + this.start + " End: " + this.end;
    }

}