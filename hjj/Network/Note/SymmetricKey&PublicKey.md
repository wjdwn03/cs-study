# 대칭키 & 공개키 <sub>Symmetric Key & Public Key</sub>

## :bookmark_tabs: 목차

[:arrow_up: **Network**](../README.md)

1. ### 대칭키와 공개키
   - [:page_facing_up: 단방향 암호화](#단방향-암호화)
   - [:page_facing_up: 양방향 암호화 - 대칭키](#양방향-암호화---대칭키)
   - [:page_facing_up: 양방향 암호화 - 공개키](#양방향-암호화---공개키)
   - [:page_facing_up: 대칭키, 공개키 비교](#대칭키와-공개키-비교)
   - [:page_facing_up: SSL의 시초 - 대칭키와 공개키의 혼합](#ssl의-시초---대칭키와-공개키의-혼합)


### 단방향 암호화

> 암호화는 가능하지만 <u>복호화는 불가능</u>한 암호화 방식

- 주로 **해시 알고리즘**을 이용하여 구현
- 해시의 특징인 무결성이 보장
    - 이러한 특징을 이용하여 파일 or 데이터의 식별자, 사용자의 비밀번호, 블록체인 등에 활용
- 대표적인 해시 알고리즘 : MD5, SHA 등

#### 단방향 암호화의 한계

- 해시 함수는 본래 데이터를 빠르게 검색하기 위해서 탄생했지만 이러한 해시 함수의 빠른 처리 속도는 공격자에게 오히려 장점으로 작용
- `레인보우 테이블` : 특정 해시 알고리즘에 대해 동일한 평문에 대하여 항상 동일 해시값을 갖는 특징을 이용하여 해시 함수의 해시 값들을 대량으로 정리한 테이블
- `레인보우 공격` : 레인보우 테이블을 이용해 사용자의 정보를 해킹하는 공격
- 레인보우 공격 문제를 보안하기 위해 단방향 암호화를 진행할 때 솔팅(Salting)과 키 스트레칭(Key Stretching)을 적용
- `솔팅` : 단방향 해시 함수 암호화를 진행 할 때 본래 데이터에 추가적으로 랜덤한 데이터를 더하는 방식
- `키 스트레칭` : 단방향 해쉬값을 계산 한 후, 그 해쉬값을 또 다시 해시하고 또 이를 반복하는 방식

- **BCrypt**
    - 비밀번호 해시에 사용하기 위해 만들어진 알고리즘
    - 레인보우 테이블 공격을 방지하기 위해 솔팅과 키 스트레칭을 적용한 대표적인 예시
    - Java의 경우 Spring Security에 BCrypt가 구현되어 있음.
        <details>
        <summary>BCrypt java 코드</summary>
        <div markdown="1">

        ```java
        import org.springframework.security.crypto.bcrypt.BCrypt;

        // 사용자 입력 암호
        String plain_password = "password_1234";

        // pw_hash 는 bcrypt 로 암호화된 비밀번호가 저장되며 이 값을 DB 에 저장하면 됩니다.
        String pw_hash = BCrypt.hashpw(plain_password, BCrypt.gensalt(10));

        // 사용자가 입력한 암호 검증
        String candidate_password = "password_123";
        String stored_hash = pw_hash;

        if (BCrypt.checkpw(candidate_password, stored_hash))
            System.out.println("It matches");
        else
            System.out.println("It does not match");
        ```

        </div>
        </details>

</br>

### 양방향 암호화 - 대칭키

> 암호화와 복호화에 같은 암호키(대칭키)를 사용하는 알고리즘

<img src="../img/SymmetricKey.png">

- 파일이나 이메일 등을 암호화하는데 매우 효과적으로 사용됨.
- 일반적으로 암호 알고리즘은 공개되기 때문에 암호문을 해독하기 위해서는 암호화에 사용된 비밀키만 찾으면 되기 때문에 대칭키 암호에서는 키의 비밀 유지가 가장 중요

#### 대칭키 알고리즘 종류
- DES<sub> Data Encryption Standard</sub>
    - 64비트 길이의 비밀키를 사용하는 알고리즘
    - 현재는 안전성을 보장할 수 없게 되어 사용하지 않음.
- AES<sub> Advanced Encryption Standard</sub> 
    - 128비트 이상의 키를 사용하는 알고리즘
- SEED
    

#### 장점
- 공개키 방식에 비하여 구현이 용이
- CPU/메모리를 적게 사용
- 매우 빠른 암/복호화 속도

#### 단점
- 키를 주고 받는 과정에서 키가 유출될 가능성이 있음.
- 키 유출 시 암호화된 모든 암호문이 쉽게 해독 가능
- 키 전달과 관리가 어려움.
- 특히 여러 상대방과 통신할 경우 각각의 키를 관리하는 것은 더욱 어려워짐.


</br>

### 양방향 암호화 - 공개키

> 암호화와 복호화에 사용하는 암호키를 분리한 알고리즘

<img src="../img/PublicKey.png">

- 비대칭키 암호화라고도 부름.
- 대칭키 암호화 방식의 키를 교환해야 하는 문제를 해결하기 위해 등장
- 암호화하는 키와 복호화 하는 키를 구분하기 때문에 대칭키의 고질적인 문제였던 키의 탈취나 관리의 어려움 등을 보완할 수 있음.

#### 공개키 암호화 진행 과정
1. A가 웹 상에 공개된 'B의 Public Key'를 이용해 평문을 암호화하여 B에게 보냄.
1. B는 자신의 Private Key로 복호화한 평문을 확인, A의 Public Key로 응답을 암호화하여 A에게 보냄.
1. A는 자신의 Private Key로 암호화된 응답문을 복호화함.

- Private Key로만 암호화 데이터를 복호화할 수 있기 때문에 해커가 Public Key와 암호화된 데이터를 훔진다고 해도 해당 데이터를 확인할 수 없음.
- 따라서 Public Key는 공개되더라도, Private Key는 절대 공개되면 안됨.

#### 공개키 알고리즘 종류
- RSA<sub>Rivest Shamir Adleman</sub>
    - 암호화뿐만 아니라 전자서명이 가능한 최초의 알고리즘으로 알려져있음.
- DSA<sub>Digital Signature Algorithm</sub>
    - 디지털 서명을 위한 표준


#### 장점
- 대칭키 방식보다 보안성 높음.

#### 단점
- 대칭키에 비해 속도가 약 1,000배 느림.
- 속도가 느리기 때문에 긴문서의 암호화하는 경우보다 대칭키 알고리즘의 키값에 대한 암호에 사용.

</br>

### 대칭키와 공개키 비교
| | 대칭키 암호화 | 공개키 암호화 |
| --- | --- | --- |
| 키 개수 | 1개 | 2개 |
| 키 보관 형태 | 비밀리에 보관 | Publick Key : 어디든 배포 </br> Private Key : 비밀리에 보관 |
| 키 교환 | 키를 교환하는 것이 어려우며 위험 | Public Key를 교환하는 것은 매우 쉬움 |
| 키 길이 | 주로 64, 128비트 등 짧은 길이 | 주로 512, 1024, 2048비트 등 긴 길이 |
| 암호화 속도 | 빠름 | 느림 |
| 암호화할 수 있는 평문의 길이 | 제한 없음 | 제한 있음 |
|기밀성 | 가능 | 가능 |
| 인증 | 부분적 가능 |가능|
| 무결성 | 부분적 가능 | 가능 |
| 부인 방지 | 불가능 | 가능 |

</br>


### SSL의 시초 - 대칭키와 공개키의 혼합

- 대칭키의 단점은 대칭키 전달 시 해커가 키를 탈취했을 때 그 이후 모든 데이터가 탈취된 키에 의해 유출될 수 있다는 것.

<img src="../img/SymmetricKey_Problem.png" width="400">

- 따라서 대칭키 전달시에만 공개키 암호화 방식을 사용하여 전달하고 그 이후 모든 통신은 대칭키를 이용하여 이루어짐.
- 즉, 공개키 알고리즘을 통해 안전하게 키를 교환한 후 해당 키로 대칭키 알고리즘을 통해 통신하게 됨.

<img src="../img/Mix_SymmetricKey_PublicKey.png" width="400">

#### 과정
1. A는 암호화 통신에 사용할 대칭키를 B의 Public Key로 암호화해서 B에게 보냄.
1. B는 암호문을 자신의 Private Key로 복호화하여 대칭키 획득
1. B는 획득한 대칭키로 A에게 보낼 데이터를 암호화하여 보냄.
1. A는 대칭키로 암호문을 복호화
1. 이후 해당 대칭키로 계속 통신



</br>

---

- 참고

    [암호화의 종류와 Bcrypt](https://velog.io/@yenicall/%EC%95%94%ED%98%B8%ED%99%94%EC%9D%98-%EC%A2%85%EB%A5%98%EC%99%80-Bcrypt)
    [대칭키 암호화](https://lesstif.gitbook.io/web-service-hardening/encryption)
    [암호 이야기 2편 – 암호 알고리즘에 대하여](https://www.lgcns.com/blog/cns-tech/security/16037/)
    [Network - 대칭키, 공개키(비대칭키)란 무엇인가?!(+ SSL, HTTPS)](https://jaehoney.tistory.com/290)