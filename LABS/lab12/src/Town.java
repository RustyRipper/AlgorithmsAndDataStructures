

public class Town  {
    int index;
    String name;
    int distance;
    String color;
    int time;
    int endTime;
    Town p;

    public Town(int index, String name) {
        this.index = index;
        this.name = name;

    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
