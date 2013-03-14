package edu.nyu.pqs.ProblemSet1;

import java.io.Serializable;

/**
 * @author Nachiket Immutable class for PostalAddress. Can be constructed only
 *         with{@code PostalAddress.PostalAddressBuilder.build} Required
 *         parameters are {@code streetName} {@code city} {@code state}
 */
class PostalAddress implements Serializable {

  private static final long serialVersionUID = -265225807673107228L;
  private final String streetName;
  private final String apartmentNumber;
  private final String city;
  private final String state;
  private final String zipCode;

  /**
   * Builder pattern based class for building a new instance of an
   * {@code PostalAddtess} class. Collects all required parameters and any
   * optional ones. Calling {@code build} will call the constructor of
   * {@code PostalAddress} Calling build invokes the constructor of
   * AddressBookEntry and validates required fields.
   */
  public static class PostalAddressBuilder {
    // Required parameters
    final String streetName;
    final String city;
    final String state;
    // Optional parameters
    String apartmentNumber;
    String zipCode;

    /**
     * Constructor for PostalAddressBuilder
     * 
     * @param streetName
     * @param city
     * @param state
     */
    public PostalAddressBuilder(String streetName, String city, String state) {
      this.streetName = streetName;
      this.city = city;
      this.state = state;
    }

    /**
     * Setter for apartmentNumber
     * 
     * @param apartmentNumber
     * @return this PostalAddressBuilder
     */
    public PostalAddressBuilder apartmentNumber(String apartmentNumber) {
      this.apartmentNumber = apartmentNumber;
      return this;
    }

    /**
     * Setter for zipCode
     * 
     * @param zipCode
     * @return this PostalAddressBuilder
     */
    public PostalAddressBuilder zipCode(String zipCode) {
      this.zipCode = zipCode;
      return this;
    }

    /**
     * Calls the constructor of PostalAddress
     * 
     * @return instance of PostalAddress
     */
    public PostalAddress build() {
      return new PostalAddress(this);
    }
  }

  private PostalAddress(PostalAddressBuilder postalAddressBuilder) {
    this.streetName = postalAddressBuilder.streetName;
    this.apartmentNumber = postalAddressBuilder.apartmentNumber;
    this.city = postalAddressBuilder.city;
    this.state = postalAddressBuilder.state;
    this.zipCode = postalAddressBuilder.zipCode;
    validate();
  }

  private void validate() {
    if (streetName == null) {
      throw new NullPointerException("streetName is null");
    }
    if (city == null) {
      throw new NullPointerException("city is null");
    }
    if (state == null) {
      throw new NullPointerException("state is null");
    }

  }

  public String getStreetName() {
    return streetName;
  }

  public String getApartmentNumber() {
    return apartmentNumber;
  }

  public String getCity() {
    return city;
  }

  public String getState() {
    return state;
  }

  public String getZipCode() {
    return zipCode;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result
        + ((apartmentNumber == null) ? 0 : apartmentNumber.hashCode());
    result = prime * result + ((city == null) ? 0 : city.hashCode());
    result = prime * result + ((state == null) ? 0 : state.hashCode());
    result = prime * result
        + ((streetName == null) ? 0 : streetName.hashCode());
    result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
    return result;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "PostalAddress [streetName=" + streetName + ", apartmentNumber="
        + apartmentNumber + ", city=" + city + ", state=" + state
        + ", zipCode=" + zipCode + "]";
  }

  /*
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof PostalAddress)) {
      return false;
    }
    PostalAddress other = (PostalAddress) obj;
    if (apartmentNumber == null) {
      if (other.apartmentNumber != null) {
        return false;
      }
    } else if (!apartmentNumber.equals(other.apartmentNumber)) {
      return false;
    }
    if (city == null) {
      if (other.city != null) {
        return false;
      }
    } else if (!city.equals(other.city)) {
      return false;
    }
    if (state == null) {
      if (other.state != null) {
        return false;
      }
    } else if (!state.equals(other.state)) {
      return false;
    }
    if (streetName == null) {
      if (other.streetName != null) {
        return false;
      }
    } else if (!streetName.equals(other.streetName)) {
      return false;
    }
    if (zipCode == null) {
      if (other.zipCode != null) {
        return false;
      }
    } else if (!zipCode.equals(other.zipCode)) {
      return false;
    }
    return true;
  }

}