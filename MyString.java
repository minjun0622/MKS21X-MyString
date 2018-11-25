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
    if (index < 0 || index >= data.length) {
      throw new IndexOutofBoundsException("Index cannot be negative or greater/equal to the length");
    }
    data[index];
    }
    
//Returns the length of the sequence at the index specified.
    public int length(int index) {
      return data.length;
    }

//Charsequence is a sequence of strings,
//subSequence returns the sequence of strings beginning from start integer and end intger.
    public CharSequence subSequence(int start, int end) {
      if (start < 0 || end < 0 || end > length() || start > end) {
        throw new IndexOutofBoundsException("Start is not negative,
        end is not negative, end should not be greater than length, start is not greater than end.");
      }
      String result = "";
      for (int i = start; i < end; i++) {
        result += data[i];
        //Utilizes a for loop to start from the start specified with the integer and ending it with an end.
      }
    }

//Returns a string containing the characters in this sequence in the same order as this sequence.
//The length of the string will be the length of this sequence.
    public String toString () {
      String result = "";
      for (int i = 0; i < length(); i++) {
        result += data[i];
      }
      return result;
      //similiar to subsequence, instead, it uses a for loop to copy over the entire data into a string.
    }

//Compares the object and the object specified.
    public compareTo (CharSequence o) {
      if (o = null) {
        throw new NullPointerException("The object cannot be null");
        //throws an exception when the object is null.
      }
      if (this.length() < o.length()) {
        return 1;
      }
      if (this.length() > o.length()) {
        return 1;
      }
      for (int i = 0; i < o.length(); i++) {
        if (this.charAt(i) != o.charAt(i)) {
          return (int)(this.charAt(i)) - (int)(o.charAt(i));
        }
      }
      return 0;
    }
    //a negative integer, zero, or a positive integer as this object is less than,
    //equal to, or greater than the specified object.

    public static void main(String[] args) {
      try {
        System.out.println()
      }


    }
  }
