package dataStructureStudy;

public class MyTree {

	Node node;
}

class Node {
	public int iData;
	public double dData;
	public Node leftNode;
	public Node rightNode;
	
	public void dispaly(){
		System.out.println("{" + iData + "," + dData + "}");
	}
}//end Node class

class Tree {
	private Node root;
	
	public Tree() {
		root = null;
	}
	
	public Node find(int key){
		Node node = root;
		while (node != null){
			if (node.iData == key){
				return node;
			}
			if (key < node.iData){
				node = node.leftNode;
			} else {
				node = node.rightNode;
			}
		}
		return null;
	}
	
	public void insert (int id,double dd){
		Node nodeToIns = new Node();
		nodeToIns.iData = id;
		nodeToIns.dData = dd;
		
		if (this.find(id) != null){
			throw new RuntimeException("该id值已存在于树中，不能插入！");
		}
	}
}
