package edu.nyu.pqs.ProblemSet1;

import java.io.Serializable;

/**
 * @author Nachiket Immutable class for Name. Can be constructed only with
 *         {@code Name.NameBuilder.build} Required parameters are
 *         {@code firstName} and {@code lastName}
 */
public class Name implements Serializable {

  private static final long serialVersionUID = 3266233395528594212L;
  private final String firstName;
  private final String middleName;
  private final String lastName;

  /**
   * Builder pattern based class for building a new instance of an {@code Name}
   * class. Collects all required parameters and any optional ones. Calling
   * {@code build} will call the constructor of {@code Name} validates required
   * fields.
   */
  public static class NameBuilder {
    // Required parameters
    final String firstName;
    final String lastName;

    // Optional Parameters
    String middleName;

    /**
     * Constructor for NameBuilder
     * 
     * @param firstName
     * @param lastName
     */
    public NameBuilder(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
    }

    /**
     * Setter for middleName
     * 
     * @param middleName
     * @return this NameBuilder
     */
    public NameBuilder middleName(String middleName) {
      this.middleName = middleName;
      return this;
    }

    /**
     * Calls the constructor of Name
     * 
     * @return instance of Name
     */
    public Name build() {
      return new Name(this);
    }
  }

  private Name(NameBuilder nameBuilder) {
    this.firstName = nameBuilder.firstName;
    this.middleName = nameBuilder.middleName;
    this.lastName = nameBuilder.lastName;
    validate();
  }

  private void validate() {
    if (firstName == null) {
      throw new NullPointerException("firstName is null");
    }
    if (lastName == null) {
      throw new NullPointerException("lastName is null");
    }
  }

  String getFirstName() {
    return firstName;
  }

  String getMiddleName() {
    return middleName;
  }

  String getLastName() {
    return lastName;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Name [firstName=" + firstName + ", middleName=" + middleName
        + ", lastName=" + lastName + "]";
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
    result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
    result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
    result = prime * result
        + ((middleName == null) ? 0 : middleName.hashCode());
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
    if (!(obj instanceof Name)) {
      return false;
    }
    Name other = (Name) obj;
    if (firstName == null) {
      if (other.firstName != null) {
        return false;
      }
    } else if (!firstName.equals(other.firstName)) {
      return false;
    }
    if (lastName == null) {
      if (other.lastName != null) {
        return false;
      }
    } else if (!lastName.equals(other.lastName)) {
      return false;
    }
    if (middleName == null) {
      if (other.middleName != null) {
        return false;
      }
    } else if (!middleName.equals(other.middleName)) {
      return false;
    }
    return true;
  }
}