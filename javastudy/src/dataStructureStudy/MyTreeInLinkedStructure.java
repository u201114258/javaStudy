package dataStructureStudy;

/**
 * Created by cchen on 6/6/2017.
 * the methods should be realized:
 * the constructor(Factory)
 * addRoot(e)
 * addLeft(p,e)
 * addRight(p,e)
 * set(p,e)
 * attach(p,T1,T2)
 * remove(p)
 */
public class MyTreeInLinkedStructure {
}

class TreeNode<V>{
    private TreeNode parent;
    private V value;
    private TreeNode leftChild;
    private TreeNode rightChild;
}