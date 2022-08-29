public class BranchComplete {
	
	BST tree;
	
	public BranchComplete() {
		this.tree = new BST();

		this.tree.insert(12, 'G');
		this.tree.insert(11, 'A');
		this.tree.insert(19, 'C');
		this.tree.insert(62, 'A');
		this.tree.insert(53, 'T');
		this.tree.insert(44, 'T');
		this.tree.insert(7, 'C');
	}

	public int DNATreeCalc(int a, int b, int c) {
		int ret = 0;

		int sum = this.tree.sum(this.tree.root);
				
		if (sum < a) {
			if (sum > b) {
				ret = sum + b;
			}
			
			ret = sum + a;
		}

		if (b - a > c) {
			ret = sum + c;
		}

		return ret;
	}
}
