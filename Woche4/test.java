import java.util.* ;
public class test {
  public static void main(String[] argv) {
    ArrayList<Integer> l = new ArrayList<Integer>() ;
    l.add(2) ;
    l.add(4) ;
    l.add(6) ;
    l.add(8) ;

    for (Iterator<Integer> it = l.iterator() ; it.hasNext() == true; ) {
      Integer tmp1 = it.next() ;
      Integer tmp2 = it.next() ;
      System.out.print(tmp2) ;
    }
    System.out.println() ;
  }
}