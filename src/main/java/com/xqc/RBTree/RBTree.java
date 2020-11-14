package com.xqc.RBTree;
/**
 * 
 * @ClassName:RBTree.java
 * @Author qcxiao
 * @Date:2020年8月9日下午3:45:56
 * @Version:1.0
 * @Description:红黑树数据结构定义
 */
public class RBTree {
	//红色
	private final int R=0;
	//黑色
	private final int B =1;
	//树的根节点
	private Node root;
	
	class Node{
		int data;
		int color = R;//最开始的为红色
		Node left;
		Node right;
		Node parent;
		public Node (int data) {
			this.data = data;
		}
		
	}
	/**
	* 
	* @Function: RBTree.java
	* @Description: 插入数据
	*
	* @Return Type:void
	* @Parament:
	* @Throws：异常描述
	*
	* @Version: v1.0.0
	* @Author : qcxiao
	* @Date:2020年8月9日 下午4:07:52
	 */
	private void insert(Node root,int data){
		//如果比根节点大，插入右子树
		if(root.data< data){
			//如果右子树为空，直接插入
			if(root.right == null){
				root.right = new Node(data);
			}else{
				insert(root.right,data);
			}
		}else{
			if(root.left == null){
				root.left = new Node(data);
			}else{
				insert(root.left, data);
			}
			
		}
	}
	
	/**
	 * 
	* @Function: RBTree.java
	* @Description: 左旋
	*
	* @Return Type:void
	* @Parament:
	* @Throws：异常描述
	*
	* @Version: v1.0.0
	* @Author : qcxiao
	* @Date:2020年8月9日 下午4:29:34
	 */
	private void leftRotate(Node node) {
		//如果node没有父节点，只需要操作两个点
		if(node.parent == null){
			//取得根节点的右子树节点
			Node right = root.right;
			//将根节点的右指针指向右节点的左子树
			root.right = right.left;
			
			right.left.parent = root;
			root.parent=right;
			right.parent = null;
		}else{
			
		}

	}
	
	

}
