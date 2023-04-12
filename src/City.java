import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Set;
import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

/* Class representing a City
 */
public class City {
  /* lookup table of all cities by name */
  public static HashMap<String, City> cities = new HashMap<String, City>();
  public String name;
  /* adjacent Links */
  public final HashSet<Link> links = new HashSet<Link>();
  /* shortest path distance */
  public int distance;
  /* shortest path parent */
  public Link parent;

  /* construct a City with name nm
   * add to the HashMap of cities
   */
  public City(String nm) {
    name = nm;
    cities.put(name, this);
  }

  /* find a city with name nm in cities
   * return the city if it exists
   * otherwise return a new city with that name
   */
  public static City find(String nm) {
    City p = cities.get(nm);
    if (p == null) {
      p = new City(nm);
      return p;
    }
    return p;
  }

  /* add a link to links
   */
  public void addLink(Link lnk) {
    links.add(lnk);
  }

  /* compare cities by their names
   * return: negative if c1 is alphanumerically less,
   *  0 if names are the same,
   *  positive if c2 is alphanumerically less
   */
  public int compareTo(City p) {
    return name.compareTo(p.name);
  }

  /* return the name of the city
   */
  public String toString() {
    return name;
  }

  /* compare cities by their distance from the start of the rail network
   * return: negative if c1 is closer to 0, 0 if equal distance, positive if c2 is closer to 0
   */
  public int compare(City c1, City c2) {
    return c1.distance - c2.distance;
  }

  /* find a path from this to dest of used links
   * return true if a path of used links is found and false otherwise
   * add the followed Links to routeLinks
   */
  public boolean getLinksTo(City dest, Set<Link> routeLinks) {
    for (Link l : links) {
      if (l.isUsed() && (l != parent)) {
        City child = l.getAdj(this);
        if ((dest == child) || child.getLinksTo(dest, routeLinks)) {
          routeLinks.add(l);
          return true;
        }
      }
    }
    return false;
  }

  /* create a shortest path tree starting from this City
   * uses Dijkstra's shortest paths algorithm
   * set the distance of this City to 0 and others to infinity
   * consider each found City closest to the start
   *   update the best known distance to all adjacent cities
   * postcondition: every City.distance is the shortest distance from this to that City
   * postcondition: every City.parent is the Link before that City in the set of shortest paths
   */
  public void makeTree() {
    Comparator<City> comparator = new CityComparator();
    PriorityQueue<City> pq = new PriorityQueue<City>(comparator);
    // add cities to the priority queue. Set the distance of this City to 0 and others to Integer.MAX_VALUE
    for (City c : cities.values()) {
      if (c != this) {
        c.distance = Integer.MAX_VALUE;
      } else {
        c.distance = 0;
      }
      c.parent = null;
      pq.add(c);
      for (Link l : c.links) {
        l.setUsed(false);
      }
    }
 
    HashSet<City> tree = new HashSet<City>();
    // visit the next closest city and update the distances of its adjacent cities in the priority queue
    while (!pq.isEmpty()) {
      City city = pq.poll();
      if (city.parent !=  null) {
        city.parent.setUsed(true);
      }
      tree.add(city);

      for (Link l : city.links) {
        City child = l.getAdj(city);
        if (!tree.contains(child)) {
          int length = l.getLength();
          
          if (child.distance > city.distance + length) {
            pq.remove(child);
            child.distance = city.distance + length;
            child.parent = l;
            pq.add(child);
          }
        }
      }
    }
  }
}
