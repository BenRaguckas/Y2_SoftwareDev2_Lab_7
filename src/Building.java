class Building implements Walls, Roof{
    private int walls;
    private String roof;

    public Building(){
        this.roof = ROOF_DEFAULT;
        this.walls = WALLS_DEFAULT;
    }

    public Building(int walls, String roof){
        this.walls = walls;
        this.roof = roof;
    }

    @Override
    public String getRoof() {
        return roof;
    }

    @Override
    public void setRoof(String roof) {
        this.roof = roof;
    }

    @Override
    public int getWalls() {
        return walls;
    }

    @Override
    public void setWalls(int walls) {
        this.walls = walls;
    }

    @Override
    public String toString() {
        return "Building " +
                "walls = " + walls +
                ", roof = '" + roof + "'.";
    }
}

class House extends Building implements Rooms {
    private int rooms;

    public House(){
        super();
        this.rooms = ROOMS_DEFAULT;
    }

    public House(int walls, String roof, int rooms){
        super(walls, roof);
        this.rooms = rooms;
    }

    @Override
    public int getRooms() {
        return rooms;
    }

    @Override
    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return super.toString() + " Type = House, " + "rooms = " + rooms + ".";
    }
}

class ApartmentBlock extends Building implements Units {
    private int units;

    public ApartmentBlock(){
        super();
        this.units = UNITS_DEFAULT;
    }

    public ApartmentBlock(int walls, String roof, int units) {
        super(walls, roof);
        this.units = units;
    }

    @Override
    public int getUnits() {
        return units;
    }

    @Override
    public void setUnits(int units) {
        this.units = units;
    }

    @Override
    public String toString() {
        return super.toString() + " Type = Apartment Block, " + "Units = " + units + ".";
    }
}

class OfficeBlock extends Building implements Cubicles {
    int cubicles;

    public OfficeBlock(){
        super();
        this.cubicles = CUBICLES_DEFAULT;
    }

    public OfficeBlock(int walls, String roof, int cubicles) {
        super(walls, roof);
        this.cubicles = cubicles;
    }

    @Override
    public int getCubicles() {
        return cubicles;
    }

    @Override
    public void setCubicles(int cubicles) {
        this.cubicles = cubicles;
    }

    @Override
    public String toString() {
        return super.toString() + " Type = Office Block, " + "Cubicles = " + cubicles + ".";
    }
}