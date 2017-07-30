package ru.stqa;

public class Good {
  String name;
  String regularPrice;
  String campaignPrice;

  public Good(String name, String regularPrice, String campaignPrice) {
    this.name = name;
    this.regularPrice = regularPrice;
    this.campaignPrice = campaignPrice;
  }

  public String getRegularPrice() {
    return regularPrice;
  }

  public String getCampaignPrice() {
    return campaignPrice;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Good good = (Good) o;

    if (name != null ? !name.equals(good.name) : good.name != null) return false;
    if (regularPrice != null ? !regularPrice.equals(good.regularPrice) : good.regularPrice != null) return false;
    return campaignPrice != null ? campaignPrice.equals(good.campaignPrice) : good.campaignPrice == null;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (regularPrice != null ? regularPrice.hashCode() : 0);
    result = 31 * result + (campaignPrice != null ? campaignPrice.hashCode() : 0);
    return result;
  }
}
