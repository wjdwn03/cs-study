public class BinarySearchTree_Delete {

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
		
		public void remove(int value) {
	        root = removeNode(root, value);
	    }

	    private Node removeNode(Node node, int value) {
	        if (node == null)
	            throw new RuntimeException("해당 값을 가진 노드를 찾을 수 없습니다.");

	        if (node.value > value)
	            node.left = removeNode(node.left, value);
	        else if (node.value < value) {
	            node.right = removeNode(node.right, value);
	        } 
	        //삭제할 노드를 찾은 경우
	        else {
	            if (node.left != null) {
	                //왼쪽 서브트리에서 가장 오른쪽에 있는 값 찾아 대체하기
	                Node child = findMaxNode(node.left);
	                int removedvalue = node.value;
	                node.value = child.value;
	                child.value = removedvalue;
	                //다시 옮겨진 위치에서 서브트리에 대해 재귀적으로 실행
	                node.left = removeNode(node.left, value);
	            } else if (node.right != null) {
	                //오른족 서브트리에서 가장 왼쪽에 있는 값 찾아 대체하기
	                Node child = findMinNode(node.right);
	                int removedvalue = node.value;
	                node.value = child.value;
	                child.value = removedvalue;
	                //다시 옮겨진 위치에서 서브트리에 대해 재귀적으로 실행
	                node.right = removeNode(node.right, value);
	            } else {
	                //삭제할 노드가 단말 노드인 경우 부모 노드와의 연결 종료
	                return null;
	            }
	        }

	        return node;
	    }
	    
	    private Node findMaxNode(Node node) {
	        if (node.right == null)
	            return node;
	        else
	            return findMaxNode(node.right);
	    }

	    private Node findMinNode(Node node) {
	        if (node.left == null)
	            return node;
	        else
	            return findMinNode(node.left);
	    }


	} // end BinaryTree class 
	
}