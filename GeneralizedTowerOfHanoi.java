//package intro;

public class GeneralizedTowerOfHanoi {
	
	public static void gtoh_with_recursion(int num_disks, int start_pos, int r, int b) {
		// Case1
		if (start_pos == r && start_pos ==b) { 
			// if all same, do nothing
			return;
		}
		// Case2
		if (start_pos == r) {
			r = 6 - start_pos - b;
			// shift all disks to the new defined r
			TowerOfHanoi.toh_with_recursion(num_disks, start_pos, r);
			int temp = r;
			r = start_pos;
			start_pos = temp;
		}
		else if (start_pos == b) {
			b = 6 - start_pos - r;
			// shift all disks to the new defined b
			TowerOfHanoi.toh_with_recursion(num_disks, start_pos, b);
			int temp = b;
			b = start_pos;
			start_pos = temp;		
		}
		// Case3
		if (r==b) {
			// if both r and b are same
			TowerOfHanoi.toh_with_recursion(num_disks, start_pos, r);
		}
		else if (num_disks % 2 == 1) {
			TowerOfHanoi.toh_with_recursion(num_disks, start_pos, b);
			if (num_disks>1) {
			for (int i = 1; i<=num_disks-2; i=i+2) {
				TowerOfHanoi.toh_with_recursion(num_disks-i, b, r);
				TowerOfHanoi.toh_with_recursion(num_disks-i-1, r, b);
			}
			}
		}
		else {
			TowerOfHanoi.toh_with_recursion(num_disks, start_pos, r);
			if (num_disks>2) {
				for (int i = 1; i<=num_disks-2; i=i+2) {
					TowerOfHanoi.toh_with_recursion(num_disks-i, r, b);
					TowerOfHanoi.toh_with_recursion(num_disks-i-1, b, r);
				}
				TowerOfHanoi.toh_with_recursion(1, r, b);
			}
			else {
				TowerOfHanoi.toh_with_recursion(1, r, b);
			}
		}
	}
	
	public static void gtoh_without_recursion(int num_disks, int start_pos, int r, int b) {
		MyStack<Integer[]> stack1 = new MyStack<>();
		// Case1
		if (start_pos == r && start_pos ==b) { 
			// if all same, do nothing
			return;
		}
		// Case2
		if (r == b) {
			TowerOfHanoi.toh_without_recursion(num_disks, start_pos, r);
			return;
		}
		// Case3
		if (start_pos == r) {
			r = 6 - start_pos - b;
			// shift all disks to the new defined r
			TowerOfHanoi.toh_without_recursion(num_disks, start_pos, r);
			int temp = r;
			r = start_pos;
			start_pos = temp;
		}
		// Case4
		else if (start_pos == b) {
			b = 6 - start_pos - r;
			// shift all disks to the new defined b
			TowerOfHanoi.toh_without_recursion(num_disks, start_pos, b);
			int temp = b;
			b = start_pos;
			start_pos = temp;		
		}
		int fixed_r = r;
		int fixed_b = b;
		if (num_disks == 1) {
			System.out.println((start_pos)+" "+b);
		}
		else if(num_disks ==2) {
			System.out.println((start_pos)+" "+b);
			System.out.println((start_pos)+" "+r);
		}
		else {
			int i = 2;
			Integer[] arr = {1,r,b};
			stack1.push(arr);
			while (i<num_disks) {
				Integer[] arr1 = {i-1,start_pos,r};
				stack1.push(arr1);
				Integer[] arr2 = {1,b,r};
				stack1.push(arr2);
				Integer[] arr3 = {i-1,b,start_pos};
				stack1.push(arr3);
				int temp = b;
				b = r;
				r = temp;
				i=i+1;
			}
			if (num_disks%2 ==1) {
				Integer[] arr1 = {num_disks-1,fixed_r,fixed_b};
				stack1.push(arr1);
				Integer[] arr2 = {1,start_pos,fixed_b};
				stack1.push(arr2);
				Integer[] arr3 = {num_disks-1,start_pos,fixed_r};
				stack1.push(arr3);
			}
			
			else {
				Integer[] arr1 = {num_disks-1,fixed_b,fixed_r};
				stack1.push(arr1);
				Integer[] arr2 = {1,start_pos,fixed_r};
				stack1.push(arr2);
				Integer[] arr3 = {num_disks-1,start_pos,fixed_b};
				stack1.push(arr3);
			}
		}
		while (stack1.empty() != true) {
			Integer[] arr4 = {0,0,0};
			try {
				arr4 = stack1.peek();				
			}
			catch(Exception e){
			}
			while (arr4[0]>1) {
				try {
					arr4= stack1.pop();				
				}
				catch(Exception e){
				}
				Integer[] arr1 = {arr4[0]-1,6-arr4[1]-arr4[2],arr4[2]};
				stack1.push(arr1);
				Integer[] arr2 = {1,arr4[1],arr4[2]};
				stack1.push(arr2);
				Integer[] arr3 = {arr4[0]-1,arr4[1],6-arr4[1]-arr4[2]};
				stack1.push(arr3);
				try {
					arr4 = stack1.peek();				
				}
				catch(Exception e){
				}
			}
			Integer[] temp_b= {0,0,0};
			try {
				temp_b = stack1.pop();				
			}
			catch(Exception e){
			}
			System.out.println((temp_b[1])+" "+(temp_b[2]));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		gtoh_without_recursion(4, 2, 1, 2);
		System.out.println(00000000);
		gtoh_with_recursion(4, 2, 1, 2);
	}

}
