package ru.stqa;

public class Country {
  private int zones;
  private String name;

  public int getZones() {
    return zones;
  }

  public String getName() {
    return name;
  }

  public Country(int zones, String name) {

    this.zones = zones;
    this.name = name;
  }

  @Override
  public String toString() {
    return "Country{" +
            "zones=" + zones +
            ", name='" + name + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Country country = (Country) o;

    if (zones != country.zones) return false;
    return name != null ? name.equals(country.name) : country.name == null;
  }

  @Override
  public int hashCode() {
    int result = zones;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }
}
