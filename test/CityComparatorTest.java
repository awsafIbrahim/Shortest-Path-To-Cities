import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    1. compare() black-box
    1a. compare returns negative if 0 <= x.distance <= y.distance
    1b. compare returns 0 if 0 <= x.distance == y.distance
    1c. compare returns positive if 0 <= x.distance <= y.distance

*/

class CityComparatorTest {

  public static final String city1Name = "City1";
  public static final String city2Name = "City2";
  public static final int cityDistanceShort = 1;
  public static final int cityDistanceLong = 2;

  /* 1a. compare returns negative if 0 <= x.distance <= y.distance */
  @Test
  void compare_xSmaller() {
    City cityX = new City(city1Name);
    City cityY = new City(city2Name);
    cityX.distance = cityDistanceShort;
    cityY.distance = cityDistanceLong;
    CityComparator cityComparator = new CityComparator();
    assertTrue(cityComparator.compare(cityX, cityY) < 0, "compare was not negative");
  }

  /* 1b. compare returns 0 if 0 <= x.distance == y.distance */
  @Test
  void compare_xEqual() {
    City cityX = new City(city1Name);
    City cityY = new City(city2Name);
    cityX.distance = cityDistanceShort;
    cityY.distance = cityDistanceShort;
    CityComparator cityComparator = new CityComparator();
    assertTrue(cityComparator.compare(cityX, cityY) == 0, "compare was not zero");
  }

  /* 1c. compare returns positive if 0 <= x.distance <= y.distance */
  @Test
  void compare_xLarger() {
    City cityX = new City(city1Name);
    City cityY = new City(city2Name);
    cityX.distance = cityDistanceLong;
    cityY.distance = cityDistanceShort;
    CityComparator cityComparator = new CityComparator();
    assertTrue(cityComparator.compare(cityX, cityY) > 0, "compare was not positive");
  }

}