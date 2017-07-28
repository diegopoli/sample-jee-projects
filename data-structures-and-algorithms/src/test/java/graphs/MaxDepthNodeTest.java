package graphs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxDepthNodeTest {

	private MaxDepthBinaryTree tree;

	@Test
	public void testEmptyTree() {
		tree = new MaxDepthBinaryTree();
		assertEquals(0, tree.maxDepth(tree.getRoot()));
	}

	@Test
	public void testTreeWithoutNodes() {
		tree = new MaxDepthBinaryTree();
		tree.setRoot(new MaxDepthNode(1));
		assertEquals(1, tree.maxDepth(tree.getRoot()));
	}

	@Test
	public void testTreeWithLeftNodesOnly() {
		tree = new MaxDepthBinaryTree();
		tree.setRoot(new MaxDepthNode(1));
		tree.getRoot().setLeft(new MaxDepthNode(2));
		assertEquals(2, tree.maxDepth(tree.getRoot()));
	}

	@Test
	public void testTreeWithRightNodesOnly() {
		tree = new MaxDepthBinaryTree();
		tree.setRoot(new MaxDepthNode(1));
		tree.getRoot().setRight(new MaxDepthNode(2));
		tree.getRoot().getRight().setRight(new MaxDepthNode(3));
		assertEquals(3, tree.maxDepth(tree.getRoot()));
	}

	@Test
	public void testTreeWithLeftAndRightNodes() {
		tree = new MaxDepthBinaryTree();
		tree.setRoot(new MaxDepthNode(1));
		tree.getRoot().setLeft(new MaxDepthNode(2));
		tree.getRoot().setRight(new MaxDepthNode(3));
		tree.getRoot().getLeft().setLeft(new MaxDepthNode(4));
		tree.getRoot().getLeft().setRight(new MaxDepthNode(5));
		tree.getRoot().getLeft().getRight().setLeft(new MaxDepthNode(6));
		assertEquals(4, tree.maxDepth(tree.getRoot()));
	}
}
