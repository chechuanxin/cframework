import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
	        while(sc.hasNext()) {
	        	int size = sc.nextInt();
	        	String data = sc.next();
	        	char[] chs = data.toCharArray();
	        	boolean has = false;
	        	while(++chs[chs.length - 1] <= (char)('a' + size - 1)) {
	        		if(!match(chs)) {
	        			System.out.println(new String(chs));
	        			has = true;
	        			break;
	        		}
	        	}
	        	if(!has) System.out.println("NO");
	        }
	        
		}
        
	}
	
	public static boolean match(char[] chs) {
		int l = 0, r = chs.length - 1;
		while(l < r) {
			if(chs[l] == chs[r]) {
				int mid = (l + r) / 2;
				String str1 = new String(chs, l, (r - l + 1) / 2);
				char[] rc = reverse(Arrays.copyOfRange(chs, mid + 1, r + 1));
				if(str1.equals(new String(rc))) return true;
			}
			l++;
		}
		return false;
	}
	
	public static char[] reverse(char[] chs) {
		char[] res = new char[chs.length];
		for (int i = chs.length - 1; i >= 0; i--) {
			res[chs.length - 1 - i] = chs[i];
		}
		return res;
	}

}
