package graphs;

public class MaxDepthBinaryTree {

	private MaxDepthNode root;

	/**
	 * Computes the max depth of a given tree.
	 * 
	 * @param node the node to search.
	 * @return the number of nodes along the longest path from the root node
	 *         down to the farthest leaf node.
	 */
	public int maxDepth(MaxDepthNode node) {

		if (node == null) {
			return 0;
		}

		// Computes the depth of each subtree recursively.
		int lDepth = maxDepth(node.getLeft());
		int rDepth = maxDepth(node.getRight());

		// Uses the larger one.
		if (lDepth > rDepth) {
			return lDepth + 1;
		} else {
			return rDepth + 1;
		}
	}

	public void setRoot(MaxDepthNode root) {
		this.root = root;
	}

	public MaxDepthNode getRoot() {
		return root;
	}
}
