package edu.nyu.pqs.ProblemSet1;

import java.io.Serializable;

import javax.naming.directory.InvalidAttributeValueException;

/**
 * @author Nachiket Immutable class for EmailAddress. Can be constructed only
 *         with{@code EmailAddress.EmailAddressBuilder.build} Required
 *         parameters are {@code emailAddress}
 */
public class EmailAddress implements Serializable {
  private static final long serialVersionUID = 761468381529159673L;
  private final String emailAddress;

  /**
   * Builder pattern based class for building a new instance of an
   * {@code EmailAddress} class. Collects all required parameters and any
   * optional ones. Calling {@code build} will call the constructor of
   * {@code EmailAddress} Calling build invokes the constructor of
   * AddressBookEntry and validates required fields.
   */

  public static class EmailAddressBuilder {
    final String emailAddress;

    /**
     * Constructor for EmailAddressBuilder
     * 
     * @param emailAddress
     */
    public EmailAddressBuilder(String emailAddress) {
      this.emailAddress = emailAddress;
    }

    /**
     * Calls the constructor of EmailAddress
     * 
     * @return instance of EmailAddress
     */
    public EmailAddress build() throws InvalidAttributeValueException {
      return new EmailAddress(this);
    }
  }

  private EmailAddress(EmailAddressBuilder emailAddressBuilder)
      throws InvalidAttributeValueException {
    if (validateEmailAddress(emailAddressBuilder.emailAddress)) {
      this.emailAddress = emailAddressBuilder.emailAddress;
    } else {
      throw new InvalidAttributeValueException("Invalid email address");
    }
  }

  /**
   * Getter for emailAddress
   * 
   * @return emailAddres
   */

  String getEmailAddress() {
    return emailAddress;
  }

  private boolean validateEmailAddress(String emailAddress) {
    emailAddress.replaceAll("\\s", "");
    int positionOfAt = emailAddress.indexOf("@");
    int positionOfDot = emailAddress.indexOf(".");
    if ((positionOfAt != -1) && (positionOfDot != -1)
        && ((positionOfAt + 1) < positionOfDot)) {
      return true;
    } else {
      return false;
    }
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
        + ((emailAddress == null) ? 0 : emailAddress.hashCode());
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
    if (!(obj instanceof EmailAddress)) {
      return false;
    }
    EmailAddress other = (EmailAddress) obj;
    if (emailAddress == null) {
      if (other.emailAddress != null) {
        return false;
      }
    } else if (!emailAddress.equals(other.emailAddress)) {
      return false;
    }
    return true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "EmailAddress [emailAddress=" + emailAddress + "]";
  }

}