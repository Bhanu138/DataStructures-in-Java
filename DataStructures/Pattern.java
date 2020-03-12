import java.util.*;
class Pattern{
	public static void patternAlternate(int n){
		boolean isColumn = true;
		boolean isRow = true;
		for (int i=0;i<n;i++ ) {
			for (int j=0;j<=i;j++ ) {
				if(isColumn){
					System.out.print("1 ");
				}else{
					System.out.print("0 ");
				}
				isColumn = isColumn ? false : true;
			}
			System.out.println();
			isRow = isRow ? false : true;
			isColumn = isRow;
		}
	}
	public static void abcPat(int n){
		int left = n, right = n;
		for (int i=1;i<=2*n;i++) {
			char ch = 'A';
			for (int j=1;j<=2*n;j++) {
				if(j<left){
					System.out.print("  ");
				}else if(j>=left){
					System.out.print(ch+" ");
					if(j<n){
						ch++;
					}else{
						ch--;
					}
				}
				if(j>=right)
					break;
			}
			left = i >= n ? left+1 : left-1;
			right = i >= n ? right-1 : right+1;
			System.out.println();
		}
	}
	public static void pascalTriangle(int n){
		String previousRow = "";
		int left = n;
		for(int i=1;i<=n;i++){
			String line = "";
			if(i == 1){
				line = "1";
			}else if(i==2){
				line = "1   1";
			}else{
				line = "1 ";
				int index = 1;
				String[] nums = previousRow.trim().split("\\s+");
				while (index<nums.length) {
					int num1 = Integer.parseInt(nums[index]);
					int num2 = Integer.parseInt(nums[index-1]);
					line += "  "+(num1+num2)+" ";
					index++;
				}
				line += "  1";
			}
			for(int j=1;j<left;j++)
				line = "  " + line;
			left--;
			previousRow = line;
			System.out.println(line);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter No: ");
		int n = sc.nextInt();
		pascalTriangle(n);
	}
}