package dataStructureStudy;

public class HuffmanTree {
	HFmanNode root = null;
	
	public HuffmanTree(String str){
		char[] charArray = str.toLowerCase().toCharArray();
		SortedQueue sq = new SortedQueue();
		for (char charValue : charArray){
			HFmanNode hfn = new HFmanNode(charValue);
			QueueNode qn = new QueueNode(hfn);
			sq.push(qn);
		}
		while (sq.head != null){
			QueueNode nodel = sq.pop();
			QueueNode noder = sq.pop();
			//只有一个节点时
			if (noder == null){
				root = nodel.hfmNode;
				return;
			}
			HFmanNode newHfN = new HFmanNode(nodel.hfmNode,noder.hfmNode);
			QueueNode newQN = new QueueNode(newHfN);
		}
	}

	public HuffmanTree(HFmanNode node){
		root = node;
	}
	
}


class HFmanNode{
	String code;//编码
	char value;//字符
	int num;//频率
	HFmanNode leftNode;
	HFmanNode rightNode;
	
	public HFmanNode(char charValue){
		this.value = charValue;
		this.num = 1;
		this.leftNode = null;
		this.rightNode = null;
	}
	
	public HFmanNode(HFmanNode leftNode,HFmanNode rightNode){
		this.num = leftNode.num + rightNode.num;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}
}

class SortedQueue{
	QueueNode head;
	
	public SortedQueue(){
		head = null;
	}
	
	public void push(QueueNode node){
		//如果队列为空
		if (head == null){
			head = node;
			return;
		}
		//队列不为空
		QueueNode nodeToFind = this.find(node.hfmNode.value);
		if (nodeToFind != null){
			this.delete(nodeToFind);
			nodeToFind.hfmNode.num ++;
			this.push(nodeToFind);
			return;
		}
		//若没有找到
		int num = node.hfmNode.num;
		QueueNode positionNodeToPush = this.findNoLast(num);
		node.next = positionNodeToPush.next;
		node.pre = positionNodeToPush;
		positionNodeToPush.next.pre = node;
		positionNodeToPush.next = node;
		return;
	}
	
	public QueueNode pop(){
		QueueNode node = head;
		if (node != null){
			head = head.next;
		}
		return node;
		
	}
	
	private QueueNode find(char value){
		QueueNode node = head;
		while(node != null){
			if (node.hfmNode.value == value){
				return node;
			}
			node = node.next;
		}
		return null;
	}
	
	private void delete(QueueNode node){
		QueueNode preN = node.pre;
		QueueNode nextN = node.next;
		preN.next = nextN;
		nextN.pre = preN;
	}
	//寻找频率为num的最后一个节点
	private QueueNode findNoLast(int num){
		QueueNode node = head;
		//此处的head不会是null,故没有再加判断
		while(node != null && node.hfmNode.num <= num){
			node = node.next;
		}
		node = node.pre;
		return node;
	}
}

class QueueNode{
	HFmanNode hfmNode;
	QueueNode next;
	QueueNode pre;
	
	public QueueNode(HFmanNode hfmNode){
		this.hfmNode = hfmNode;
		this.next = null;
		this.pre = null;
	}
}