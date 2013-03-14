package edu.nyu.pqs.ProblemSet1;

import java.io.Serializable;

/**
 * @author Nachiket Immutable class for Note. Can be constructed only with
 *         {@code Note.NoteBuilder.build} Required parameters are {@code note}
 */
class Note implements Serializable {

  private static final long serialVersionUID = -538123511402869101L;
  private final String note;

  /**
   * Builder pattern based class for building a new instance of an {@code Note}
   * class. Collects all required parameters and any optional ones. Calling
   * {@code build} will call the constructor of {@code Note} and validates
   * required fields.
   */
  public static class NoteBuilder {
    // Required parameter
    final String note;

    /**
     * Constructor for NoteBuilder
     * 
     * @param note
     */
    public NoteBuilder(String note) {
      this.note = note;
    }

    /**
     * Calls the constructor of Note
     * 
     * @return instance of Note
     */
    public Note build() {
      return new Note(this);
    }

  }

  private Note(NoteBuilder noteBuilder) {
    this.note = noteBuilder.note;
    validate();
  }

  private void validate() {
    if (note == null) {
      throw new NullPointerException("note is null");
    }
  }

  String getNote() {
    return note;
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
    result = prime * result + ((note == null) ? 0 : note.hashCode());
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
    if (!(obj instanceof Note)) {
      return false;
    }
    Note other = (Note) obj;
    if (note == null) {
      if (other.note != null) {
        return false;
      }
    } else if (!note.equals(other.note)) {
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
    return "Note [note=" + note + "]";
  }

}