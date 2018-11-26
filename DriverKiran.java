import java.util.ArrayList;
public class DriverKiran{
  public static void main(String[] args){
    //testing constructor
    String[] matchingStrings = {"New York",
                                "Albany",
                                "Rochester",
                                "Purchase",
                                "Montauk",
                                "Islip",
                                "Syracuse",
                                "Buffalo",
                                "Plattsburgh",
                                "Rome",
                                "Utica",
                                "Schenectady",
                                "Yonkers",
                                "New Rochelle",
                                "White Plains",
                                "",
                                " "
                              };
    MyString ms1 = new MyString("glowing");
    MyString ms2 = new MyString(ms1);
    MyString[] sampleMSs = sampleVals(matchingStrings);
    System.out.println("constructor: good");
    System.out.print("charAt: ");
    printErrors('A',testCharAt(sampleMSs,matchingStrings));
    System.out.print("length: ");
    printErrors('L',testLength(sampleMSs,matchingStrings));
    System.out.print("subSequence: ");
    printErrors('S',testSubSequence(sampleMSs,matchingStrings));
    System.out.print("toString:  ");
    printErrors('T',testToString(sampleMSs,matchingStrings));
    System.out.print("compareTo: ");
    printErrors('C',testCompareTo(sampleMSs,matchingStrings));
    System.out.println("\nnote: if you somehow messed up length(), it may result in a false positive for other methods; correct length first");
  }
  public static int randInt(int start, int endExcluded){
    return start + (int)(Math.random()*(endExcluded-start));
  }
  public static void printErrors(char chr,ArrayList<String> E){
    if(E.size()==0) System.out.println("good");
    else{
      System.out.println("fails, "+E.size()+" errors");
      for(int i=0;i<E.size();i++){
        System.out.println("\tC"+(i+1)+".\t"+E.get(i));
      }
    }
  }
  public static MyString[] sampleVals(String[] A){
    MyString[] out = new MyString[A.length];
    for(int i=0;i<out.length;i++){
      out[i] = new MyString(A[i]);
    }
    return out;
  }
  public static ArrayList<String> testCharAt(MyString[] A,String[] B){
    ArrayList<String> errors = new ArrayList<String>();
    for(int i=0;i<A.length;i++){
      for(int j=0;j<B[i].length();j++){
        try{
          if(A[i].charAt(j)!=B[i].charAt(j)) errors.add("incorrect output for \""+A[i]+"\".charAt("+j+"): "+B[i].charAt(j));
        }catch(StringIndexOutOfBoundsException e){
          errors.add("exception StringIOOB thrown at incorrect time, \""+B[i]+"\".charAt("+j+")");
        }catch(ArrayIndexOutOfBoundsException e){
          errors.add("array throws ArrayIOOB thrown(never should be thrown), when no exception should have thrown, \""+B[i]+"\".charAt("+j+")");
        }catch(Exception e){
          errors.add("unexpected exception "+e.getClass().getName()+" thrown when no exception should have, \""+B[i]+"\".charAt("+j+")");
        }
      }
      try{
        A[i].charAt(-1);
        errors.add("successful run for bad input, \""+B[i]+"\".charAt(-1) returns '"+A[i].charAt(-1)+"'");
      }catch(StringIndexOutOfBoundsException e){
      }catch(ArrayIndexOutOfBoundsException e){
        errors.add("array throws exception rather than MyString; ArrayIOOB thrown, \""+B[i]+"\".charAt(-1)");
      }catch(Exception e){
        errors.add("unexpected exception "+e.getClass().getName()+" thrown instead of StringIOOB, \""+B[i]+"\".charAt(-1)");
      }
      try{
        A[i].charAt(B[i].length());
        errors.add("successful run for bad input, \""+B[i]+"\".charAt(length()) returns '"+A[i].charAt(B[i].length())+"'");
      }catch(StringIndexOutOfBoundsException e){
      }catch(ArrayIndexOutOfBoundsException e){
        errors.add("array throws exception rather than MyString; ArrayIOOB thrown, \""+B[i]+"\".charAt(length())");
      }catch(Exception e){
        errors.add("unexpected exception "+e.getClass().getName()+" thrown instead of StringIOOB, \""+B[i]+"\".charAt(length())");
      }
      try{
        A[i].charAt(200);
        errors.add("successful run for bad input, \""+B[i]+"\".charAt(200) returns '"+A[i].charAt(200)+"'");
      }catch(StringIndexOutOfBoundsException e){
      }catch(ArrayIndexOutOfBoundsException e){
        errors.add("array throws exception rather than MyString; ArrayIOOB thrown, \""+B[i]+"\".charAt(200)");
      }catch(Exception e){
        errors.add("unexpected exception "+e.getClass().getName()+" thrown instead of StringIOOB, \""+B[i]+"\".charAt(200)");
      }
    }
    return errors;
  }
  public static ArrayList<String> testLength(MyString[] A,String[] B){
    ArrayList<String> errors = new ArrayList<String>();
    for(int i=0;i<A.length;i++){
      try{
        if(A[i].length()!=B[i].length()) errors.add("incorrect output: \""+B[i]+"\".length(), correct "+B[i].length()+",returned "+A[i].length());
      }catch(Exception e){
        errors.add("unexpected error "+e.getClass().getName()+" thrown for \""+B[i]+"\".length() (no exception should ever be thrown here)");
      }
    }
    return errors;
  }
  public static ArrayList<String> testSubSequence(MyString[] A,String[] B){
    ArrayList<String> errors = new ArrayList<String>();
    for(int i=0;i<A.length;i++){
      int start,end;
      for(int j=0;j<6;j++){//6 tests of any random valid subSequence;
        start = randInt(0,B[i].length()+1);
        end = randInt(start,B[i].length()+1);
        testSubHelper(errors,A[i],B[i],start,end);
      }
      for(int j=0;j<3;j++){//3 tests of subSequences ending with length()
        start = randInt(0,B[i].length()+1);
        end = B[i].length();
        testSubHelper(errors,A[i],B[i],start,end);
      }
      for(int j=0;j<3;j++){//3 tests of subSquences starting with 0
        end = randInt(0,B[i].length()+1);
        testSubHelper(errors,A[i],B[i],0,end);
      }
      for(int j=0;j<3;j++){//3 testsof subSequences at same position
        start = randInt(0,B[i].length()+1);
        testSubHelper(errors,A[i],B[i],start,start);
      }
      testSubHelper(errors,A[i],B[i],0,0);//special case: start and end 0(valid)
      testSubHelper(errors,A[i],B[i],B[i].length(),B[i].length());//special case: length,length(valid)
    }
    return errors;
  }
  public static void testSubHelper(ArrayList<String> errors,MyString a,String b,int start,int end){
    try{
      if(a.subSequence(start,end).compareTo(b.subSequence(start,end))!=0) {
        errors.add("incorrect output for \""+b+"\".subSequence("+start+","+end+"): correct "+b.subSequence(start,end)+", returned "+a.subSequence(start,end));
      }
    }catch(StringIndexOutOfBoundsException e){
      errors.add("StringIOOB exception raised when not necessary, \""+b+"\".subSequence("+start+","+end+")");
    }catch(ArrayIndexOutOfBoundsException e){
      errors.add("array threw ArrayIOOB, unnecessary and should never be thrown; \""+b+"\".subSequence("+start+","+end+")");
    }catch(Exception e){
      errors.add("unexpected exception "+e.getClass().getName()+" thrown for \""+b+"\".subSequence("+start+","+end+")");
    }
  }
  public static ArrayList<String> testToString(MyString[] A,String[] B){
    ArrayList<String> errors = new ArrayList<String>();
    for(int i=0;i<A.length;i++){
      try{
        if(!(A[i].toString().equals(B[i]))){
          errors.add("incorrect output for toString method, \""+B[i]+"\".toString() returns "+A[i].toString()+", correct: \""+B[i]+"\"");
        }
      }catch(Exception e){
        errors.add("unexpected exception "+e.getClass().getName()+" thrown for \""+B[i]+"\".toString(), no exception should ever be thrown here");
      }
    }
    return errors;
  }
  public static ArrayList<String> testCompareTo(MyString[] A,String[] B){
    ArrayList<String> errors = new ArrayList<String>();
    int k;//for use within loop
    MyString empty = new MyString("");
    for(int i=0;i<A.length;i++){
      for(int j=0;j<6;j++){//six unspecified tests
        k = randInt(0,A.length);
        testCTHelper(errors,A[i],B[i],A[k],B[k]);
        testCTHelper(errors,A[k],B[k],A[i],B[i]);
      }
      testCTHelper(errors,A[i],B[i],A[i],B[i]);//should always be 0: testing against self
      testCTHelper(errors,A[i],B[i],empty,"");//test against empty string
      testCTHelper(errors,empty,"",A[i],B[i]);//test empty string against it
      for(int j=0;j<6;j++){//tests where length will determine; subsequences(relies on working subSequence)
        k = randInt(0,B[i].length());
        testCTHelper(errors,A[i],B[i],A[i].subSequence(0,k),B[i].substring(0,k));
        testCTHelper(errors,A[i].subSequence(0,k),B[i].substring(0,k),A[i],B[i]);
      }
    }
    return errors;
  }
  public static void testCTHelper(ArrayList<String> errors,MyString aI,String bI,MyString aK,String bK){
    int aCompareTo,bCompareTo;
    try{
      aCompareTo = aI.compareTo(aK);
      bCompareTo = bI.compareTo(bK);
      if (!(signsMatch(aCompareTo,bCompareTo))){
        errors.add("incorrect sign output for \""+bI+"\".compareTo\""+bK+"\") returns "+signOf(aCompareTo)+", correct: "+signOf(bCompareTo));
      }
    }catch(StringIndexOutOfBoundsException e){
      errors.add("StringIOOB thrown by \""+bI+"\".compareTo(\""+bK+"\"), no exception should ever be thrown here (likely a bad loop)");
    }catch(Exception e){
      errors.add("unexpected exception "+e.getClass().getName()+" thrown for \""+bI+"\".compareTo(\""+bK+"\"), no exception should ever be thrown here");
    }
  }
  public static boolean signsMatch(int a,int b){
    if(a==0||b==0) return a==b;
    return a/Math.abs(a)==b/Math.abs(b);
  }
  public static char signOf(int a){
    if (a==0) return '0';
    if (a<0) return '-';
    else return '+';
  }
}
