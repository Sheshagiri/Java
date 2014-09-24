import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Sheshagiri
 *
 */
public class FlipkartTest3 {

    /**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {8,3,2,4,5,6};
		List result = new ArrayList();
		int k=11;
		int i=0,curr=0,temp=0;
		while(curr<=arr.length){
			if(temp<k && curr<=arr.length-1){
				temp=temp+arr[curr];
				result.add(arr[curr]);
				curr=curr+1;
                i=i+1;
			} else if(temp==k){
    		    System.out.println(result);
                result.clear();
    			temp=0;
                curr=curr-i+1;
                i=0;
			}
            else {
				result.clear();
				temp=0;
                curr=curr-i+1;
                i=0;
			}
		}
	}
}
