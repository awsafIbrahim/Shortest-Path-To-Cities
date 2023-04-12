public class LinkTwoWay extends Link{
    /* Construct a Link between c1 and c2 with length len
     * add a bidirectional  link to both cities
     * It sorts the cities according to their alphabetical order
     */
    public LinkTwoWay(City c1, City c2, int len) {

        super(c1,c2,len);
        if(c1.compareTo(c2)<0){
            city1=c1;
            city2=c2;}
        else {
            city1=c2;
            city2=c1;
        }
        c1.addLink(this);
        c2.addLink(this);

    }
    //Prints the cities in sorted order (alphabetically)
    public String toString(){


        return city1.toString()+ " " + length+ " " +city2.toString();
    }
}
