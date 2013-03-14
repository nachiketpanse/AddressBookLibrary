package edu.nyu.pqs.ProblemSet1;

import java.io.Serializable;

public class AddressBookEntry implements Serializable {
  /**
   * @author Nachiket Immutable class for contacts Can be constructed only with
   *         {@code AddressBookEntry.AddressBookEntryBuilder.build} Required
   *         parameters are {@code name} and {@code postalAddress}
   *         {@code phoneNumber, emailAddress and note are optional}
   */
  private static final long serialVersionUID = 4864623303606393787L;
  private final Name name;
  private final PostalAddress postalAddress;
  private final PhoneNumber phoneNumber;
  private final EmailAddress emailAddress;
  private final Note note;

  /**
   * Builder pattern based class for building a new instance of an
   * {@code AddressBookEntry} class. Collects all required parameters and any
   * optional ones. Calling {@code build} will call the constructor of
   * {@code Contact} Calling build invokes the constructor of AddressBookEntry
   * and validates required fields.
   */

  public static class AddressBookEntryBuilder {
    // Required Parameters
    private final Name name;
    private final PostalAddress postalAddress;

    // Optional Parameters
    private PhoneNumber phoneNumber;
    private EmailAddress emailAddress;
    private Note note;

    /**
     * Constructor for AddressBookEntryBuilder
     * 
     * @param name
     * @param postalAddress
     */
    public AddressBookEntryBuilder(Name name, PostalAddress postalAddress) {
      this.name = name;
      this.postalAddress = postalAddress;
    }

    /**
     * Setter for phoneNumber
     * 
     * @param phoneNumber
     * @return this AddressBookEntryBuilder
     */
    public AddressBookEntryBuilder phoneNumber(PhoneNumber phoneNumber) {
      this.phoneNumber = phoneNumber;
      return this;
    }

    /**
     * Setter for emailAddress
     * 
     * @param emailAddress
     * @return this AddressBookEntryBuilder
     */
    public AddressBookEntryBuilder emailAddress(EmailAddress emailAddress) {
      this.emailAddress = emailAddress;
      return this;
    }

    /**
     * Setter for note
     * 
     * @param note
     * @return this AddressBookEntryBuilder
     */
    public AddressBookEntryBuilder note(Note note) {
      this.note = note;
      return this;
    }

    /**
     * Calls the constructor of AddressBookEntry
     * 
     * @return instance of AddressBookEntry
     */
    public AddressBookEntry build() {
      return new AddressBookEntry(this);
    }
  }

  private AddressBookEntry(AddressBookEntryBuilder addressBookEntryBuilder) {
    this.name = addressBookEntryBuilder.name;
    this.postalAddress = addressBookEntryBuilder.postalAddress;
    this.phoneNumber = addressBookEntryBuilder.phoneNumber;
    this.emailAddress = addressBookEntryBuilder.emailAddress;
    this.note = addressBookEntryBuilder.note;
    validateRequiredFeilds();
  }

  private void validateRequiredFeilds() {
    if (name == null) {
      throw new NullPointerException("name is null");
    }
    if (postalAddress == null) {
      throw new NullPointerException("postalAddress is null");
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "AddressBookEntry [name=" + name + ", postalAddress="
        + postalAddress + ", phoneNumber=" + phoneNumber + ", emailAddress="
        + emailAddress + ", note=" + note + "]";
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
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((note == null) ? 0 : note.hashCode());
    result = prime * result
        + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
    result = prime * result
        + ((postalAddress == null) ? 0 : postalAddress.hashCode());
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
    if (!(obj instanceof AddressBookEntry)) {
      return false;
    }
    AddressBookEntry other = (AddressBookEntry) obj;
    if (emailAddress == null) {
      if (other.emailAddress != null) {
        return false;
      }
    } else if (!emailAddress.equals(other.emailAddress)) {
      return false;
    }
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }
    if (note == null) {
      if (other.note != null) {
        return false;
      }
    } else if (!note.equals(other.note)) {
      return false;
    }
    if (phoneNumber == null) {
      if (other.phoneNumber != null) {
        return false;
      }
    } else if (!phoneNumber.equals(other.phoneNumber)) {
      return false;
    }
    if (postalAddress == null) {
      if (other.postalAddress != null) {
        return false;
      }
    } else if (!postalAddress.equals(other.postalAddress)) {
      return false;
    }
    return true;
  }

  /**
   * Getter for name
   * 
   * @return name
   */
  public Name getName() {
    return name;
  }

  /**
   * Getter for postalAddress
   * 
   * @return postalAddress
   */
  public PostalAddress getPostalAddress() {
    return postalAddress;
  }

  /**
   * Getter for phoneNumber
   * 
   * @return phoneNumber
   */
  public PhoneNumber getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * Getter for emailAddress
   * 
   * @return emailAddress
   */
  public EmailAddress getEmailAddress() {
    return emailAddress;
  }

  /**
   * Getter for note
   * 
   * @return note
   */
  public Note getNote() {
    return note;
  }

}