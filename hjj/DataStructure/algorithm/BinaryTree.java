class BinaryTree {
    private int data;
    private BinaryTree left;
    private BinaryTree right;
    
    public BinaryTree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
    public int getData() {
        return data;
    }
    
    public void setData(int data) {
        this.data = data;
    }
    
    public BinaryTree getLeft() {
        return left;
    }
    
    public void setLeft(BinaryTree left) {
        this.left = left;
    }
    
    public BinaryTree getRight() {
        return right;
    }
    
    public void setRight(BinaryTree right) {
        this.right = right;
    }
}

class BinaryTree {
    private BinaryTree root;
    
    public BinaryTree() {
        root = null; // 이진 트리의 루트 노드 초기화
    }
    
    public boolean isEmpty() {
        return root == null; // 이진 트리가 비어 있는지 여부 반환
    }
    
    public void insert(int data) {
        root = insertNode(root, data); // 데이터를 이진 트리에 삽입
    }
    
    private BinaryTree insertNode(BinaryTree current, int data) {
        if (current == null) {
            current = new BinaryTree(data); // 현재 노드가 null인 경우 새로운 노드 생성
        } else {
            if (data <= current.getData()) {
                current.setLeft(insertNode(current.getLeft(), data)); // 데이터가 현재 노드의 데이터보다 작거나 같으면 왼쪽 자식에 삽입
            } else {
                current.setRight(insertNode(current.getRight(), data)); // 데이터가 현재 노드의 데이터보다 크면 오른쪽 자식에 삽입
            }
        }
        return current;
    }
    
    public boolean search(int data) {
        return searchNode(root, data); // 데이터를 이진 트리에서 검색
    }
    
    private boolean searchNode(BinaryTree current, int data) {
        if (current == null) {
            return false; // 현재 노드가 null인 경우 데이터를 찾지 못한 것이므로 false를 반환.
        }
        
        if (data == current.getData()) {
            return true; // 현재 노드의 데이터와 찾는 데이터가 일치하면 true를 반환
        } else if (data < current.getData()) {
            return searchNode(current.getLeft(), data); // 데이터가 현재 노드의 데이터보다 작으면 왼쪽 자식을 탐색
        } else {
            return searchNode(current.getRight(), data); // 데이터가 현재 노드의 데이터보다 크면 오른쪽 자식을 탐색
        }
    }
    
    public void delete(int data) {
        root = deleteNode(root, data); // 데이터를 이진 트리에서 삭제
    }
    
    private BinaryTree deleteNode(BinaryTree current, int data) {
        if (current == null) {
            return null; // 현재 노드가 null인 경우 삭제할 데이터를 찾지 못한 것이므로 null 반환
        }
        
        if (data == current.getData()) {
            // 삭제할 노드가 단말 노드인 경우
            if (current.getLeft() == null && current.getRight() == null) {
                return null; // 왼쪽과 오른쪽 자식이 없는 단말 노드를 삭제하고 null 반환
            }
            // 삭제할 노드가 오른쪽 자식만 가지는 경우
            else if (current.getLeft() == null) {
                return current.getRight(); // 오른쪽 자식을 현재 노드로 대체
            // 삭제할 노드가 왼쪽 자식만 가지는 경우
            else if (current.getRight() == null) {
                return current.getLeft(); // 왼쪽 자식을 현재 노드로 대체
            }
            // 삭제할 노드가 양쪽 자식을 가지는 경우
            else {
                int smallestValue = findSmallestValue(current.getRight()); // 오른쪽 서브트리에서 가장 작은 값을 찾는다
                current.setData(smallestValue); // 삭제할 노드의 데이터를 찾은 가장 작은 값으로 대체
                current.setRight(deleteNode(current.getRight(), smallestValue)); // 가장 작은 값을 가진 노드를 삭제
                return current;
            }
        } else if (data < current.getData()) {
            current.setLeft(deleteNode(current.getLeft(), data)); // 데이터가 현재 노드의 데이터보다 작으면 왼쪽 자식 삭제
            return current;
        } else {
            current.setRight(deleteNode(current.getRight(), data)); // 데이터가 현재 노드의 데이터보다 크면 오른쪽 자식 삭제
            return current;
        }
    }
    
    private int findSmallestValue(BinaryTree root) {
    	// 오른쪽 서브트리에서 가장 작은 값을 찾기 위해 왼쪽 자식으로 계속 이동한다.
        return root.getLeft() == null ? root.getData() : findSmallestValue(root.getLeft());
    }
}