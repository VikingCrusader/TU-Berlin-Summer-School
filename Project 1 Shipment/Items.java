package shipment_project;

class Items {
    private double length;
    private double width;
    private double height;
    private double weight;
    // the number of the specific item
    private int num;
    //Constructors
    public Items(double length, double width, double height, double weight, int num) {
        super();
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.num = num;
    }


    //Getters and Setters
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getNum() {
        return num;
    }


    public void setNum(int num) {
        this.num = num;
    }


    //calculate volume

    double volumeCal () {
        double v = this.length * this.width * this.height;
        return v;
    }

    //total volume of this specific item
    public double totalVolCal () {
        double totalVolume = this.length * this.width * this.height * num;
        return totalVolume;
    }

    //total weight of this specific item
    public double totalWeight () {
        double totalWeight = this.weight * num;
        return totalWeight;
    }


    @Override
    public String toString() {
        return "Items [length=" + length + ", width=" + width + ", height=" + height + ", weight=" + weight + ", num="
                + num + ", volume=" + volumeCal() + ", totalVolume=" + totalVolCal() + ", totalWeight=" + totalWeight() + "]";
    }



}