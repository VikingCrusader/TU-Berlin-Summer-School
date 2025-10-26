package shipment_project;
class Container {
    private double height;
    private double width;
    private double length;
    //getters and setters
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    // Constructors
    public Container(double height, double width, double length) {
        super();
        this.height = height;
        this.width = width;
        this.length = length;
    }

    // calculate volume
    public double calVol () {
        double vol;
        vol = this.length * this.width * this.height;
        return vol;
    }



}