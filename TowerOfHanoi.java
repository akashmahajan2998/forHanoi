//package intro;

public class TowerOfHanoi {

	public static void toh_with_recursion(int num_disks, int start_pos, int end_pos) {
		// Case1
		if (start_pos == end_pos) {
			return;
		}
		// Otherwise
		if (num_disks == 1) {
			System.out.println((Integer.toString(start_pos))+" "+(Integer.toString(end_pos)));
			return;
		}
		else {
			toh_with_recursion(num_disks - 1, start_pos, 6-start_pos-end_pos);
			System.out.println((Integer.toString(start_pos))+" "+(Integer.toString(end_pos)));
			toh_with_recursion(num_disks - 1, 6-start_pos-end_pos, end_pos);
			return;
		}
	}
	
	public static void toh_without_recursion(int num_disks, int start_pos, int end_pos) {
		// Case1
		if (start_pos == end_pos) {
			return;
		}
		// Other case
		MyStack<Integer[]> stack1 = new MyStack<>();
		if (num_disks==1) {
			System.out.println((start_pos)+" "+(end_pos));
		}
		else {
			// Initial creation of stack
			Integer[] arr1 = {num_disks-1,6-start_pos-end_pos,end_pos};
			stack1.push(arr1);
			Integer[] arr2 = {1,start_pos,end_pos};
			stack1.push(arr2);
			Integer[] arr3 = {num_disks-1,start_pos,6-start_pos-end_pos};
			stack1.push(arr3);
		}
		while (stack1.empty() != true) {
			int temp_a = 1;
			try {
				temp_a = stack1.peek()[0];				
			}
			catch(Exception e){
			}
			while (temp_a>1) {
				Integer[] arr4= {0,0,0};
				try {
					arr4 = stack1.pop();				
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
					temp_a = stack1.peek()[0];				
				}
				catch(Exception e){
				}
			}
			// pop if stack(top)[0] = 1
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
		//toh_with_recursion(5, 1, 3);
		toh_without_recursion(4,1,3);
	}

}
