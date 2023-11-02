public class BinarySearchTree_Add {

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

		public static void addNode(int value) {
			// 트리가 비어있다면
			if (root == null) {
				root = new Node(value); // 루트 노드 추가
			}
			// 트리가 비어있지 않은 경우
			// 노드를 추가한다.
			else {
				
				addChild(root, value);
			}

		}

		private static Node addChild(Node current, int value) {
			
			// 비어있는 노드면 거기에 노드를 추가해준다.
			if(current == null) {
				current = new Node(value);
				return current;
			}
			
			// current 노드보다 값이 작으면 current 노드의 왼쪽 자식에 추가해준다.
			if(value < current.value) {
				current.left = addChild(current.left, value);
			}
			// current 노드보다 값이 작으면 current 노드의 오른쪽 자식에 추가해준다.
			else if( value > current.value) {
				current.right = addChild(current.right, value);
			}
			
			return current;
			
		} // end addChild


	} // end BinaryTree class 
	
}