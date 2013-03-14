package edu.nyu.pqs.ProblemSet1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

class FileIO {

  private static final String FILENAME = "AddressBook.ser";

  public static void saveAddressBookEntry(AddressBookEntry addressbookEntry)
      throws IOException, FileNotFoundException, NullPointerException {
    try {
      FileOutputStream fileOutputStream = new FileOutputStream(FILENAME, true);
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(
          fileOutputStream);
      objectOutputStream.writeObject(addressbookEntry);
      objectOutputStream.close();
    } catch (FileNotFoundException e) {
      throw e;
    } catch (IOException e) {
      throw e;
    } catch (NullPointerException e) {
      throw e;
    }
  }

  public static List<AddressBookEntry> readAddressBook()
      throws FileNotFoundException, IOException, NullPointerException,
      ClassNotFoundException {
    List<AddressBookEntry> list = new ArrayList<AddressBookEntry>();
    try {
      ObjectInputStream objectInputStream = new ObjectInputStream(
          new FileInputStream(FILENAME));
      while (objectInputStream.available() != 0) {
        list.add((AddressBookEntry) objectInputStream.readObject());

      }
      objectInputStream.close();
      return list;
    } catch (FileNotFoundException e) {
      throw e;
    } catch (IOException e) {
      throw e;
    } catch (NullPointerException e) {
      throw e;
    }
  }
}