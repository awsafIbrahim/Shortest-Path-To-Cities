import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/*
   1. getLength() black-box returns the length of a link
   2. getAdj() black-box
   2a. getAdj() returns city1 if c is city2
   2b. getAdj() returns city2 if c is city1
   3. isUsed() black-box
   3a. isUsed() returns true if the link is on a shortest path
   3b. isUsed() returns false if the link is not  on a shortest path
   4. setUsed() withe-box set set used to u
   4a. setUsed() set to true
   4a. setUsed() set to false
   5. testToString() black-box
   5a. testToString() returns a return a string representation of the Link in sorted order
   5b. testToString() returns a return a string representation of the Link in unsorted order
   6. compareTo() black-box
   6a. compareTo() returns 0 if both links have the same city1 and city2
   6b. compareTo() returns negative int if this.city1 < l.city1
   6c. compareTo() returns negative int if city1 are equal and this.city2 < l.city2
   6d. compareTo() returns a positive int if none of the previous conditions occur
*/

class LinkTest {

  public static final String city1Name = "City1";
  public static final String city2Name = "City2";
  public static final String city3Name = "City3";
  public static final int cityDistance = 3;

  /* 1. getLength() returns the length length of a link */
  @Test
  void getLength() {
    City city1 = new City(city1Name);
    City city2 = new City(city2Name);
    Link link = new Link(city1, city2, cityDistance);
    int expectedDistance = cityDistance;
    int resultDistance = link.getLength();
    City.cities.clear();
    assertEquals(expectedDistance, resultDistance, "getLength returned wrong value");
  }

  /* 2. getAdj() black-box */
  /* 2a. getAdj() returns city1 if c is city2 */
  @Test
  void getAdj_city1() {
    City city1 = new City(city1Name);
    City city2 = new City(city2Name);
    Link link = new Link(city1, city2, cityDistance);
    String expectedString = city1Name;
    String resultString = link.getAdj(city2).toString();
    City.cities.clear();
    assertEquals(expectedString, resultString, "getAdj with city2 returned wrong city");
  }

  /* 2b. getAdj() returns city2 if c is city1 */
  @Test
  void getAdj_city2() {
    City city1 = new City(city1Name);
    City city2 = new City(city2Name);
    Link link = new Link(city1, city2, cityDistance);
    String expectedString = city2Name;
    String resultString = link.getAdj(city1).toString();
    City.cities.clear();
    assertEquals(expectedString, resultString, "getAdj with city1 returned wrong city");
  }

  /* 3. isUsed() black-box */
  /* 3a. isUsed() returns true if the link is on a shortest path */
  @Test
  void isUsed_true() {
    City city1 = new City(city1Name);
    City city2 = new City(city2Name);
    Link link = new Link(city1, city2, cityDistance);
    link.setUsed(true);
    assertTrue(link.isUsed() == true, "true was not returned on the path");
  }

  /* 3b. isUsed() returns false if the link is not  on a shortest path */
  @Test
  void isUsed_false() {
    City city1 = new City(city1Name);
    City city2 = new City(city2Name);
    Link link = new Link(city1, city2, cityDistance);
    link.setUsed(false);
    assertTrue(link.isUsed() == false, "false was not returned on the path");
  }

  /* 4. setUsed() black-box */
  /* 4a. setUsed() set to true */
  @Test
  void setUsed_true() {
    City city1 = new City(city1Name);
    City city2 = new City(city2Name);
    Link link = new Link(city1, city2, cityDistance);
    link.setUsed(true);
    assertTrue(link.used == true, "used was not set to true");
  }

  /* 4a. setUsed() set to true */
  @Test
  void setUsed_false() {
    City city1 = new City(city1Name);
    City city2 = new City(city2Name);
    Link link = new Link(city1, city2, cityDistance);
    link.setUsed(false);
    assertTrue(link.used == false, "used was not set to false");
  }



  /* 6. compareTo() black-box */
  /* 6a. compareTo() returns 0 if both links have the same city1 and city2 */
  @Test
  void compareTo_equals() {
    City city1 = new City(city1Name);
    City city2 = new City(city2Name);
    Link link1 = new Link(city1, city2, cityDistance);
    Link link2 = new Link(city1, city2, cityDistance);
    assertTrue(link1.compareTo(link2) == 0, "compare was not 0");
  }

  /* 6b. compareTo() returns negative int if this.city1 < l.city1 */
  @Test
  void compareTo_sameCity1() {
    City city1 = new City(city1Name);
    City city2 = new City(city2Name);
    City city3 = new City(city3Name);
    Link link1 = new Link(city2, city1, cityDistance);
    Link link2 = new Link(city3, city1, cityDistance);
    assertTrue(link1.compareTo(link2) < 0, "compare was not negative");
  }

  /* 6c. compareTo() returns negative int if the city1 are equal and this.city2 < l.city2 */
  @Test
  void compareTo_sameCity2() {
    City city1 = new City(city1Name);
    City city2 = new City(city2Name);
    City city3 = new City(city3Name);
    Link link1 = new Link(city1, city2, cityDistance);
    Link link2 = new Link(city1, city3, cityDistance);
    assertTrue(link1.compareTo(link2) < 0, "compare was not negative");
  }

  /* 6d. compareTo() returns a positive int if none of the previous conditions occur */
  @Test
  void compareTo_differentCities() {
    City city1 = new City(city1Name);
    City city2 = new City(city2Name);
    City city3 = new City(city3Name);
    Link link1 = new Link(city2, city3, cityDistance);
    Link link2 = new Link(city1, city2, cityDistance);
    assertTrue(link1.compareTo(link2) > 0, "compare was not positive");
  }
}
