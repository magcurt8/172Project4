public class TreeNode {

	public LineSegment line, segment;
	public TreeNode leftchild;
	public TreeNode rightchild;
	public TreeNode parent;
	public TreeNode root;

	public TreeNode(LineSegment line, LineSegment segment){
		this.line = line;
		this.segment = segment;
		this.leftchild = null;
		this.rightchild = null;
		this.parent = null;
	}

	public void printInOrder() {
		if (leftchild != null)
			leftchild.printInOrder();
		
		//System.out.println(line.p1.x + " " + line.p1.y + " " + line.p2.x + " " + line.p2.y);
		
		if (rightchild != null)
			rightchild.printInOrder();
	}
	
	public static String printNode(LineSegment n){
		return n.p1.x + " " + n.p1.y + " " + n.p2.x + " " + n.p2.y;
	}
	public int count() {
		int c = 1;
		if (leftchild != null)
			c += leftchild.count();
		if (rightchild != null)
			c += rightchild.count();
		return c;
	}
	public static int externalNodes(TreeNode n){
		if(n.leftchild == null || n.rightchild == null)
			return 1;
		else
			return externalNodes(n.leftchild) + externalNodes(n.rightchild);
	}
	
	public static int externalPathLength(TreeNode n, int m){
		if(n.leftchild == null && n.rightchild == null){
			m++;
			return m;
		}
		else{
			return externalPathLength(n.leftchild, m++) + externalPathLength(n.rightchild, m++);
		}
		}
		public static double averagePathLength(TreeNode n){
			return (double) externalPathLength(n, 0) / (double) externalNodes(n);
		}
}