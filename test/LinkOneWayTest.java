import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkOneWayTest {
    public static final String city1Name = "A";
    public static final String city2Name = "B";

    public static  int distance=5;
    @Test
    void testToString() {
        City c1=new City(city1Name);
        City c2=new City(city2Name);
        LinkOneWay l= new LinkOneWay(c1,c2,distance);
        String result=city1Name + " " + distance + " " + city2Name + " one";
        assertEquals(result,l.toString(), "toString() did not work properly");
    }

    @Test
    void testToString2(){
        City c1=new City(city2Name);
        City c2=new City(city1Name);
        LinkOneWay l= new LinkOneWay(c1,c2,distance);
        String result=city2Name + " " + distance + " " + city1Name + " one";
    }
}