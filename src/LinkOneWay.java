public class LinkOneWay extends Link{


    /* Construct a Link between c1 and c2 with length len
     * add a unidirectional link to both cities
     */
    public LinkOneWay(City c1, City c2, int len) {

        super(c1,c2,len);
        c1.addLink(this);
    }

    //Print the cities and "one" at the end
    public String toString(){
        return city1.toString() + " " + length + " " + city2.toString() + " " + "one";
    }
}
