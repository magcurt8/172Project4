import java.awt.Dimension;
import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.FileReader;
//import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;

public class Test {

	public static void main(String[] args) {
		
		int line_mnt; //point_mnt;
		BinaryTree BST = new BinaryTree();
		String[] input = new String[4];
		String container, infile = "infile.txt";//, outfile = "outfile.txt";
		LineSegment line;
		Point one = new Point(0,0);
		Point two = new Point(0,0);
		//TreeNode node;
		
		try{
			
		BufferedReader read = new BufferedReader(new FileReader(infile));
		//BufferedWriter write = new BufferedWriter(new FileWriter(outfile));
		line_mnt = Integer.parseInt(read.readLine());
		double x1, y1, x2, y2;
		
		JFrame frame = new JFrame();
		MyMouseListener mml = new MyMouseListener();
		frame.addMouseListener(mml);
		frame.setPreferredSize(new Dimension(500,500));
		UnitSquare u = new UnitSquare();
		u.addMouseListener(mml);
		frame.add(u);
		frame.pack();
		frame.setVisible(true);
		
		for(int i = 0; i < line_mnt; i++){
			container = read.readLine();
			input = container.split(" ");
			
			x1 = Double.parseDouble(input[0]);
			y1 = Double.parseDouble(input[1]);
			x2 = Double.parseDouble(input[2]);
			y2 = Double.parseDouble(input[3]);
			
			line = new LineSegment(x1, y1, x2, y2);
			
			BST.insert(line);
			//System.out.println("inserting:" + x1 + " " + y1 + " " + x2 + " " + y2);
			u.addLine(line);
		}
		
		//int count = BST.getNode().count();
		//double left = TreeNode.leftChildCount(BST.getNode());
		//double right = TreeNode.rightChildCount(BST.getNode());
		//double length = BST.average_height(BST.root);
		BST.printInOrder();
		
		//System.out.println("This is the count: " + count);
		//System.out.println("Left: " + left + "\nRight: " + right);
		System.out.println("Average height of a tree: " + TreeNode.averagePathLength(BST.getNode()));
		System.out.println("Number of external nodes: "+TreeNode.externalNodes(BST.getNode()));
		//write.write("Amount of leaves in the tree: " + count);
		//write.newLine();
		
		//write.write("Average height of a tree: " + length);
		//write.newLine();
		
		container = read.readLine();
		while(container != null){
			input = container.split(" ");
			
			x1 = Double.parseDouble(input[0]);
			y1 = Double.parseDouble(input[1]);
			x2 = Double.parseDouble(input[2]);
			y2 = Double.parseDouble(input[3]);
			
			one.x = x1;
			one.y = y1;
			
			two.x = x2;
			two.y = y2;
			
			//TreeNode node1 = BST.search(BST.getNode(), one);
			//TreeNode node2 = BST.search(BST.getNode(), two);
			
			//TreeNode.printNode(node1);
			//TreeNode.printNode(node2);
			
			
			if(BST.search(BST.getNode(), one, two) == null){
				//write.write("Points " + one + " and " + two + " are in the same region.");
				System.out.println("Points " + one + " and " + two + " are in the same region.");
			} else {
				//write.write("Points " + one + " and " + two + " are separated by line " 
				//		+ TreeNode.printNode(BST.search(BST.getNode(), one, two)));
				System.out.println("Points " + one + " and " + two + " are separated by line "
						+ TreeNode.printNode(BST.search(BST.getNode(), one, two)));
			}
			
			//write.newLine();
			container = read.readLine();
		}
		read.close();
		u.setTree(BST);
	}catch (IOException e) {
		e.printStackTrace();
	}
	}

}