public class MyString implements CharSequence, Comparable<CharSequence>{
  private char[] data;
  public MyString(CharSequence s){
    data = new char[s.length()];
//Initializing data with the length of s.
    for (int i = 0; i < s.length(); i++) {
      data[i] = s.charAt(i);
      //copies it over.
    }
  }

//Returns the char value at the specified index. An index ranges from zero to length() - 1.
//The first char value of the sequence is at index zero, the next at index one, and so on, as for array indexing.
//If the char value specified by the index is a surrogate, the surrogate value is returned.
  public char charAt(int index) {
    if (index < 0 || index >= data.length)
      throw new IndexOutOfBoundsException();
    return data[index];
    }


//Returns the length of the sequence at the index specified.
    public int length() {
      return data.length;
    }

//Charsequence is a sequence of strings,
//subSequence returns the sequence of strings beginning from start integer and end intger.
    public CharSequence subSequence(int start, int end) {
       if (start < 0 || end < 0 || end > length() || start > end)
        throw new IndexOutOfBoundsException();
      String result = "";
      for (int i = start; i < end; i++) {
        result += data[i];
        //Utilizes a for loop to start from the start specified with the integer and ending it with an end.
      }
      return result;
    }

//Returns a string containing the characters in this sequence in the same order as this sequence.
//The length of the string will be the length of this sequence.
    public String toString () {
      String result = "";
      for (int i = 0; i < data.length; i++) {
        result += data[i];
      }
      return result;
      //similiar to subsequence, instead, it uses a for loop to copy over the entire data into a string.
    }

//Compares the object and the object specified.
    public int compareTo (CharSequence o) {
      int count = 0;
      if (o == null)
        throw new NullPointerException();
        //throws an exception when the object is null.
        if (data.length < o.length())
          count = -1;
      if (data.length > o.length())
          count = 1;
        //checks if the length of data is greater or less than object. Return 1 and -1 respectively.
        if (data.length == o.length()) {
          for (int i = 0; i < data.length; i++) {
            if (data[i] > o.charAt(i))
            count = 1;
            if (data[i] < o.charAt(i))
            count = -1;
          //uses a for loop to check if the specified value at data is not equal to charsequence o.
          // Returns -1, 1, 0
        }
      }
      return count;
      //if they're the same, then return 0.
    //a negative integer, zero, or a positive integer as this object is less than,
    //equal to, or greater than the specified object.
  }
  }
