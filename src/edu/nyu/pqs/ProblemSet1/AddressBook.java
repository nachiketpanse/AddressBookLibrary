package edu.nyu.pqs.ProblemSet1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * AddressBook.java Singleton class for creating an addressbook.
 * 
 * @author Nachiket
 */
public class AddressBook {

  private static final AddressBook addressBook = new AddressBook();
  private List<AddressBookEntry> addressBookList = new ArrayList<AddressBookEntry>();

  private AddressBook() {
  }

  /**
   * Gets the AddressBook instance
   * 
   * @return AddressBook singleton instance
   */
  public static AddressBook getInstance() {
    return addressBook;
  }

  /**
   * Adds addressBookEntry to the AddressBook
   * 
   * @param addressBookEntry
   *          Entry to be added
   * @return true if object was added else false
   * @throws NullPointerException
   *           if addressBookEntry is null
   */
  public boolean addAddressBookEntry(AddressBookEntry addressBookEntry)
      throws NullPointerException {
    if (addressBookEntry == null) {
      throw new NullPointerException("addressBookEntry is null");
    }
    return addressBookList.add(addressBookEntry);
  }

  /**
   * Removes first instance addressBookEntry from the address book
   * 
   * @param addressBookEntry
   *          Entry to be removed
   * @return true if addressBookEntry was removed else false
   * @throws NullPointerException
   *           if addressBookEntry is null
   */
  public boolean removeAddressBookEntry(AddressBookEntry addressBookEntry) {
    if (addressBookEntry == null) {
      throw new NullPointerException("addressBookEntry is null");
    }
    return addressBookList.remove(addressBookEntry);
  }

  /**
   * Searches for addressBookEntries having the emailAddress
   * 
   * @param emailAddress
   *          Search using EmailAddress
   * @return Unmodifiable list of AddressBookEntry that have a matching
   *         emailAddress
   * @throws NullPointerException
   *           if emailAddress is null
   */
  public List<AddressBookEntry> searchAddressBookEntry(EmailAddress emailAddress)
      throws NullPointerException {
    if (emailAddress == null) {
      throw new NullPointerException("emailAddress was null");
    }
    List<AddressBookEntry> searchResult = new ArrayList<AddressBookEntry>();
    for (AddressBookEntry e : addressBookList) {
      if (e.getEmailAddress().equals(emailAddress)) {
        searchResult.add(e);
      }
    }
    return Collections.unmodifiableList(searchResult);
  }

  /**
   * Searches for addressBookEntries having the name
   * 
   * @param name
   *          Search using Name
   * @return Unmodifiable list of AddressBookEntry that have a matching name
   * @throws NullPointerException
   *           if name is null
   */
  public List<AddressBookEntry> searchAddressBookEntry(Name name)
      throws NullPointerException {
    if (name == null) {
      throw new NullPointerException("name is null");
    }
    List<AddressBookEntry> searchResult = new ArrayList<AddressBookEntry>();
    for (AddressBookEntry e : addressBookList) {
      if (e.getName().equals(name)) {
        searchResult.add(e);
      }
    }
    return Collections.unmodifiableList(searchResult);
  }

  /**
   * Searches for addressBookEntries have the note
   * 
   * @param note
   *          Search using Note
   * @return Unmodifiable list of AddressBookEntry that have a matching note
   * @throws NullPointerException
   *           if note is null
   */
  public List<AddressBookEntry> searchAddressBookEntry(Note note)
      throws NullPointerException {
    if (note == null) {
      throw new NullPointerException("note is null");
    }
    List<AddressBookEntry> searchResult = new ArrayList<AddressBookEntry>();
    for (AddressBookEntry e : addressBookList) {
      if (e.getNote().equals(note)) {
        searchResult.add(e);
      }
    }
    return Collections.unmodifiableList(searchResult);
  }

  /**
   * Searches for AddressBookEntries that have the PhoneNumber
   * 
   * @param phoneNumber
   *          Search using phoneNumber
   * @return Unmodifiable list of AddressBookEntry that have a matching
   *         phoneNumber
   * @throws NullPointerException
   *           If phoneNumber is null
   */
  public List<AddressBookEntry> searchAddressBookEntry(PhoneNumber phoneNumber)
      throws NullPointerException {
    if (phoneNumber == null) {
      throw new NullPointerException("phoneNumber is null");
    }
    List<AddressBookEntry> searchResult = new ArrayList<AddressBookEntry>();
    for (AddressBookEntry e : addressBookList) {
      if (e.getPhoneNumber().equals(phoneNumber)) {
        searchResult.add(e);
      }
    }
    return Collections.unmodifiableList(searchResult);
  }

  /**
   * Searches for AddressBookEntries that have the postalAddress
   * 
   * @param postalAddress
   *          Search using postalAddress
   * @return Unmodifiable list of AddressBookEntry that have a matching
   *         postalAddress
   * @throws NullPointerException
   *           If postalAddress is null
   */
  public List<AddressBookEntry> searchAddressBookEntry(
      PostalAddress postalAddress) throws NullPointerException {
    if (postalAddress == null) {
      throw new NullPointerException("postalAddress is null");
    }
    List<AddressBookEntry> searchResult = new ArrayList<AddressBookEntry>();
    for (AddressBookEntry e : addressBookList) {
      if (e.getPostalAddress().equals(postalAddress)) {
        searchResult.add(e);
      }
    }
    return Collections.unmodifiableList(searchResult);
  }

  /**
   * Saves the addressbook to a file named AddressBook.ser
   * 
   * @throws FileNotFoundException
   * @throws IOException
   * @throws NullPointerException
   */
  public void saveAddressBook() throws FileNotFoundException, IOException,
      NullPointerException {

    for (AddressBookEntry e : addressBookList) {
      FileIO.saveAddressBookEntry(e);
    }

  }

  /**
   * Reads AddressBookEntries from a file named AddressBook.ser
   * 
   * @throws FileNotFoundException
   * @throws NullPointerException
   * @throws IOException
   * @throws ClassNotFoundException
   */
  public void readAddressBook() throws FileNotFoundException,
      NullPointerException, IOException, ClassNotFoundException {
    addressBookList = FileIO.readAddressBook();
  }
}