public class BinarySearchTree_Traversal {

	static class Node {

		int value;

		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
			left = null;
			right = null;
		}

		public Node(Node left, Node right) {
			this.left = left;
			this.right = right;
		}
	}

	public static class BinaryTree {

		static Node root;

		// 중위순회(왼쪽자식->부모->오른쪽자식)
		public static void inOrder(Node now) {

			if (now == null)
				return;

			// 왼쪽 자식 노드
			inOrder(now.left);

			// 부모노드
			System.out.println(now.value);

			// 오른쪽 자식 노드
			inOrder(now.right);
		}

		// 전위순회(부모->왼쪽자식->오른쪽자식)
		public static void preOrder(Node now) {

			if (now == null)
				return;

			// 부모노드
			System.out.println(now.value);

			// 왼쪽 자식 노드
			preOrder(now.left);

			// 오른쪽 자식 노드
			preOrder(now.right);

		}

		// 후위순회(왼쪽자식->오른쪽자식->부모)
		public static void postOrder(Node now) {

			if (now == null)
				return;

			// 왼쪽 자식 노드
			postOrder(now.left);

			// 오른쪽 자식 노드
			postOrder(now.right);

			// 부모노드
			System.out.println(now.value);
		}

	} // end BinaryTree class

}