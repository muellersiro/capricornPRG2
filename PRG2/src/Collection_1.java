import java.util.*;

public class Collection_1 {

	public static void main(String[] args) {

		ArrayList l = new ArrayList();
		l.add(new Integer(8));
		l.add(new Integer(2));
		l.add(new Integer(9));
		l.add(new Integer(3));
		l.add("hallo");
		l.add(true);
		
		Object o = new Integer(8);
		System.out.println(l.contains(o));
		
		System.out.println(l);
		
	}

}
