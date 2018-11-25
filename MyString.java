public class MyString implements CharSequence, Comparable<CharSequence>{
  private char[] data;
  public MyString(CharSequence s){
    data = new char[s.length];
//Initializing data with the length of s.
    char data [] = char newdata [s.length()];
    for (int i = 0; i < s.length(); i++) {
      data[i] = s.charAt(i);
      //copies it over.
    }
  }
//Returns the char value at the specified index. An index ranges from zero to length() - 1.
//The first char value of the sequence is at index zero, the next at index one, and so on, as for array indexing.
//If the char value specified by the index is a surrogate, the surrogate value is returned.
  public char charAt(int index) {
    if (index < 0 || index > data.length) {
      throw new IndexOutofBoundsException("Index cannot be negative or greater/equal to the length");
    }
    return newdata [s.length()];
    }
//Returns the length of the sequence at the index specified.
    public int length(int index) {
      return newdata [s.length()];
    }
//Charsequence is a sequence of strings,
//subSequence returns the sequence of strings beginning from start integer and end intger.
    public CharSequence subSequence(int start, int end) {
      if (start < 0 || end < 0 || end > s.length() || start > end) {
        throw new IndexOutofBoundsException("Start is not negative,
        end is not negative, end should not be greater than length, start is not greater than end.");
      }
      return newdata[start, end]
    }
//Returns a string containing the characters in this sequence in the same order as this sequence.
//The length of the string will be the length of this sequence.
    public String toString () {
      return newdata;
    }
  }
