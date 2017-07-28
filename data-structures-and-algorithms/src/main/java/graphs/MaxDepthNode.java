package graphs;

public class MaxDepthNode {

	private int data;
	private MaxDepthNode left, right;

	MaxDepthNode(int item) {
		this.data = item;
		this.left = null;
		this.right = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public MaxDepthNode getLeft() {
		return left;
	}

	public void setLeft(MaxDepthNode left) {
		this.left = left;
	}

	public MaxDepthNode getRight() {
		return right;
	}

	public void setRight(MaxDepthNode right) {
		this.right = right;
	}
}
