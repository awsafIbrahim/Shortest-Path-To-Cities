import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.Set;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

/* Test cases
   1. find() black-box
   1a. find() returns a City that exists when it is the only City
   1b. find() returns a City that exists when it is the second City created
   1c. find() returns a new City when the City does not exist and there were no previous cities
   1d. find() returns a new City when the City does not exist and there were previous cities
   2. addLink() black-box
   2a. addLink adds a link when links is empty
   2b. addLink adds a link when links is not empty
   3. compareTo() black-box
   3a. compareTo returns negative if this.name is alphanumerically less
   3b. compareTo returns 0 if this.name.equals(p.name)
   3c. compareTo returns positive if this.name is alphanumerically greater
   4. toString () white-box returns the name of a city
   5. compare() black-box
   5a. compare returns negative if 0 <= c1.distance <= c2.distance
   5b. compare returns 0 if 0 <= c1.distance == c2.distance
   5c. compare returns positive if 0 <= c2.distance <= c1.distance
   6. getLinkTo black-box
   6a. getLinkTo returns true when a path from this to dest exists, and
         the followed links have been added to routeLinks
   6b. getLinkTo returns false when a path from this to dest does not exist.
*/

class CityTest {

  public static final String city1Name = "City1";
  public static final String city2Name = "City2";
  public static final String city3Name = "City3";
  public static final int cityDistanceShort = 1;
  public static final int cityDistanceLong = 2;

  /* clear the cities HashMap after every test */
  @AfterEach
  public void clearCities() {
    City.cities.clear();
  }

  /* 1. find() black-box */
  /* 1a. find() returns a City that exists when it is the only City */
  @Test
  void find_existsOne() {
    City city1 = new City(city1Name);
    City result = City.find(city1Name);
    assertSame(city1, result, "find did not return the same City");
  }

  /* 1b. find() returns a City that exists when it is the second City created */
  @Test
  void find_existsTwo() {
    City city1 = new City(city1Name);
    City city2 = new City(city2Name);
    City result = City.find(city2Name);
    assertSame(city2, result, "find did not return the same City");
  }

  /* 1c. find() returns a new City when the City does not exist and there were no previous cities */
  @Test
  void find_notExistsOne() {
    int numCities = City.cities.size();
    City result = City.find(city1Name);
    assertTrue(city1Name.equals(result.name), "find returned a City with the wrong name");
    assertEquals(numCities+1, City.cities.size(), "City.cities did not increase in size");
  }

  /* 1d. find() returns a new City when the City does not exist and there were previous cities */
  @Test
  void find_notExistsTwo() {
    City city1 = new City(city1Name);
    int numCities = City.cities.size();
    City result = City.find(city2Name);
    assertTrue(city2Name.equals(result.name), "find returned a City with the wrong name");
    assertNotSame(city1, result, "find did not return a new City");
    assertEquals(numCities+1, City.cities.size(), "City.cities did not increase in size");
  }

  /* 2. addLink() black-box */
  /* 2a. addLink adds a uni directional link between two cities*/
  @Test
  void addLink_Unidirectional() {
    City city1 = new City(city1Name);
    int numLinks = city1.links.size();
    City city2 = new City(city2Name);
    int numLinks2=city2.links.size();


    Link link = new Link(city1, city2, cityDistanceShort);
    city1.addLink(link);
    assertEquals(numLinks+1, city1.links.size(), "addLink did not increase length of links");
    assertEquals(numLinks2, city2.links.size(), " addLink did not establish a unidirectional link");
    assertTrue(city1.links.contains(link), "addLink did not add the link to links");
    assertFalse(city2.links.contains(link), " addLink established a bidirectional link");
  }

  /* 2b. addLink adds a bidirectional link between two cities */
  @Test
  void addLink_bidirectional() {
    City city1 = new City(city1Name);
    City city2 = new City(city2Name);
    Link link = new Link(city1, city2, cityDistanceShort);
    int numLinks = city1.links.size();
    int numLinks2=city2.links.size();
    city1.addLink(link);
    city2.addLink(link);

    assertEquals(numLinks+1, city1.links.size(), "addLink did not increase length of links");
    assertEquals(numLinks2+1,city2.links.size(), " addLink did not increase the length of the links");
    assertTrue(city1.links.contains(link), "addLink did not add the link to links");
    assertTrue(city2.links.contains(link), "addLink did not add the link to links");

  }

  /* 3. compareTo() black-box */
  /* 3a. compareTo returns negative if this.name is alphanumerically less */
  @Test
  void compareTo_xSmaller() {
    City city1 = new City(city1Name);
    City city2 = new City(city2Name);
    assertTrue(city1.compareTo(city2) < 0, "compareTo was not negative");
    City.cities.clear();
  }

  /* 3b. compareTo returns 0 if this.name.equals(p.name) */
  @Test
  void compareTo_xEqual() {
    City city1 = new City(city1Name);
    City city2 = new City(city1Name);
    assertTrue(city1.compareTo(city2) == 0, "compareTo was not zero");
  }

  /* 3c. compareTo returns positive if this.name is alphanumerically greater */
  @Test
  void compareTo_xLarger() {
    City city1 = new City(city2Name);
    City city2 = new City(city1Name);
    assertTrue(city1.compareTo(city2) > 0, "compareTo was not positive");
  }

  /* 4. toString () white-box returns the name of a city */
  @Test
  void testToString() {
    City city1 = new City(city1Name);
    assertTrue(city1Name.equals(city1.toString()), "toString did not return City name");
  }

  /* 5. compare() black-box */
  /* 5a. compare returns negative if 0 <= c1.distance <= c2.distance */
  @Test
  void compare_xSmaller() {
    City city1 = new City(city1Name);
    City city2 = new City(city2Name);
    city1.distance = cityDistanceShort;
    city2.distance = cityDistanceLong;
    assertTrue(city1.compare(city1, city2) < 0, "compare was not negative");
  }

  /* 5b. compare returns 0 if 0 <= c1.distance == c2.distance */
  @Test
  void compare_xEqual() {
    City city1 = new City(city1Name);
    City city2 = new City(city2Name);
    city1.distance = cityDistanceShort;
    city2.distance = cityDistanceShort;
    assertTrue(city1.compare(city1, city2) == 0, "compare was not zero");
  }

  /* 5c. compare returns positive if 0 <= c2.distance <= c1.distance */
  @Test
  void compare_xLarger() {
    City city1 = new City(city1Name);
    City city2 = new City(city2Name);
    city1.distance = cityDistanceLong;
    city2.distance = cityDistanceShort;
    assertTrue(city1.compare(city1, city2) > 0, "compare was not positive");
  }

  /* 6. getLinkTo black-box */
  /* 6a. getLinkTo returns true when a unidirectional path from this to dest exists, and
             the followed links have been added to routeLinks */
  @Test
  void getLinksTo_Unidirectional() {
    City city1 = new City(city1Name);
    City city2 = new City(city2Name);
    Link link = new Link(city1, city2, cityDistanceShort);
    link.setUsed(true);
    city1.addLink(link);
    Set<Link> routeLinks = new HashSet<Link>();
    assertTrue(city1.getLinksTo(city2, routeLinks), "getLinkTo returned false when there is a path");
    assertFalse(city2.getLinksTo(city1,routeLinks),"getLinkTo returned true when there is no path");
    assertTrue(routeLinks.contains(link), "getLinkTo did not add link to routeLinks");
  }

  /* 6. getLinkTo black-box */
  /* 6a. getLinkTo returns true when a bidirectional path from this to dest exists, and
             the followed links have been added to routeLinks */
  @Test
  void getLinksTo_bidirectional(){
    City city1 = new City(city1Name);
    City city2 = new City(city2Name);
    Link link = new Link(city1, city2, cityDistanceShort);
    link.setUsed(true);
    city1.addLink(link);
    city2.addLink(link);
    Set<Link> routeLinks=new HashSet<Link>();
    assertTrue(city1.getLinksTo(city2,routeLinks),"getLinkTo returned false when there is a path");
    assertTrue(city2.getLinksTo(city1,routeLinks),"getLinkTo returned false when there is a path");
    assertTrue(routeLinks.contains(link));
  }

  /* 6b. getLinkTo returns false when a path from this to dest does not exist. */
  @Test
  void getLinksTo_notExists() {
    City city1 = new City(city1Name);
    City city2 = new City(city2Name);
    Set<Link> routeLinks = new HashSet<Link>();
    assertFalse(city1.getLinksTo(city2, routeLinks), "getLinkTo returned true when there is no path");
  }

}
