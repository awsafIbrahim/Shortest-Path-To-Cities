import java.util.Comparator;

/* Compare two cities for use in sorting or data structures
 */ 
public class CityComparator implements Comparator<City> {
  /* compare cities by their distance from the start of the rail network
   * return: negative if c1 is closer to 0, 0 if equal distance, positive if c2 is closer to 0
   */
  public int compare(City x, City y) {

    return y.compare(x,y);

  }
}
