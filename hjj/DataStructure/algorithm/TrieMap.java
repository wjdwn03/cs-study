package day231012;

import java.util.HashMap;
import java.util.Map;

public class TrieMap {

	static class Node {

		Map<Character, Node> child = new HashMap<>(); // 자식노드
		boolean isLastChar; // 마지막 글자 여부

	}

	static class Trie {

		private Node root = new Node();

		public Trie() {
			root = new Node();
		}

		// 자식 노드 추가
		void add(String str) {

			// 항상 루트 노드에서부터 시작해야 함.
			Node node = this.root;

			int size = str.length();

			// 문자열의 각 글자를 가져와 자식 노드 중에 있는지 확인
			// 없으면 자식 노드 새로 생성
			for (int i = 0; i < size; i++) {
				node = node.child.computeIfAbsent(str.charAt(i), k -> new Node());
			}

			// 저장할 문자열의 마지막 글자에 문자열의 끝임을 명시
			node.isLastChar = true;
		}

		// 문자열 검색
		boolean get(String str) {
			// 항상 루트부터 시작
			Node node = this.root;

			int size = str.length();

			// 문자열의 각 글자마다 노드가 존재하는지 확인
			for (int i = 0; i < size; i++) {

				// 존재하면 해당 노드를 가져오고 아니면 null
				node = node.child.getOrDefault(str.charAt(i), null);

				// null인 경우 해당 문자열이 존재하지 않는 것임.
				if (node == null) {
					return false;
				}
			}

			// 문자열의 마지막 글자까지 매핑되는 노드가 존재하더라도 해당 문자열이 존재 하지 않을 수 있음.
			// ex) poppy만 등록되어 있는 경우
			// pop을 검색할 때 pop이라는 단어를 찾을 수는 있지만 Trie에 pop이 등록되어 있는 건 아님.
			// 따라서 검색하고자 하는 문자열이 존재하더라도 마지막 글자에 해당하는 노드의 isLastChar를 확인해야 함.
			return node.isLastChar;
		}

		// 삭제

	}

}
