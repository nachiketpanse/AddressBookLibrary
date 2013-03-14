package edu.nyu.pqs.ProblemSet1;

import java.io.Serializable;

/**
 * @author Nachiket Immutable class for PhoneNumber. Can be constructed only
 *         with{@code PhoneNumber.PhoneNumberBuilder.build} Required parameters
 *         are {@code prefix} and {@code lineNumber}
 */
public class PhoneNumber implements Serializable {

  private static final long serialVersionUID = 6091120438383055277L;
  private final String countryCode;
  private final String prefix;
  private final String lineNumber;

  /**
   * Builder pattern based class for building a new instance of an
   * {@code PhoneNumber} class. Collects all required parameters and any
   * optional ones. Calling {@code build} will call the constructor of
   * {@code phoneNumber} and validates required fields.
   */
  public static class PhoneNumberBuilder {
    // Required parameters
    String prefix;
    String lineNumber;

    // Optional Parameters
    String countryCode;

    /**
     * Constructor for PhoneNumber
     * 
     * @param prefix
     * @param lineNumber
     */
    public PhoneNumberBuilder(String prefix, String lineNumber) {
      this.prefix = prefix;
      this.lineNumber = lineNumber;
    }

    /**
     * Setter for countryCode
     * 
     * @param countryCode
     * @return this PhoneNumberBuilder
     */
    public PhoneNumberBuilder countryCode(String countryCode) {
      this.countryCode = countryCode;
      return this;
    }

    /**
     * Calls the constructor of PhoneNumber
     * 
     * @return instance of PhoneNumber
     */
    public PhoneNumber build() {
      return new PhoneNumber(this);
    }
  }

  private PhoneNumber(PhoneNumberBuilder phoneNumberBuilder) {
    this.countryCode = phoneNumberBuilder.countryCode;
    this.prefix = phoneNumberBuilder.prefix;
    this.lineNumber = phoneNumberBuilder.lineNumber;
    validate();
  }

  private void validate() {
    if (prefix == null) {
      throw new NullPointerException("prefix is null");
    }
    if (lineNumber == null) {
      throw new NullPointerException("lineNumber is null");
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "PhoneNumber [countryCode=" + countryCode + ", prefix=" + prefix
        + ", lineNumber=" + lineNumber + "]";
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
        + ((countryCode == null) ? 0 : countryCode.hashCode());
    result = prime * result
        + ((lineNumber == null) ? 0 : lineNumber.hashCode());
    result = prime * result + ((prefix == null) ? 0 : prefix.hashCode());
    return result;
  }

  /*
   * (non-Javadoc)
   * 
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
    if (!(obj instanceof PhoneNumber)) {
      return false;
    }
    PhoneNumber other = (PhoneNumber) obj;
    if (countryCode == null) {
      if (other.countryCode != null) {
        return false;
      }
    } else if (!countryCode.equals(other.countryCode)) {
      return false;
    }
    if (lineNumber == null) {
      if (other.lineNumber != null) {
        return false;
      }
    } else if (!lineNumber.equals(other.lineNumber)) {
      return false;
    }
    if (prefix == null) {
      if (other.prefix != null) {
        return false;
      }
    } else if (!prefix.equals(other.prefix)) {
      return false;
    }
    return true;
  }

  String getCountryCode() {
    return countryCode;
  }

  String getPrefix() {
    return prefix;
  }

  String getLineNumber() {
    return lineNumber;
  }
}