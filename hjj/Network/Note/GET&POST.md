# GET & POST

## :bookmark_tabs: 목차

[:arrow_up: **Network**](../README.md)

1. ### GET & POST
   - [:page_facing_up: GET](#get-요청)
   - [:page_facing_up: POST](#post-요청)
   - [:page_facing_up: GET과 POST 비교](#get과-post-비교)


## GET 요청

> 서버에게 리소스를 요청하기 위해 사용되는 HTTP Method

- 조회를 요청하는 것이기 때문에 서버에 영향을 주지 않음.
- URL 파라미터에 key와 value가 결합된 쿼리 스트링 형태로 요청하는 데이터를 담아 보냄.
    - 따라서 body가 없음.
    - 헤더를 통해 데이터를 전송하기에 데이터 전송량에 한계가 있음 - 길이 제한이 있음.
    - 파라미터에 다 노출되기 때문에 민감함 데이터를 처리할 때는 GET 요청을 사용하면 안됨.
    - 예시 : `www.example.com/question?type=2&number=125`
- 멱등성을 보장함. 
    - 즉, 같은 요청에 대해 같은 응답을 받는 성질을 가지기 때문에 반복되는 요청의 경우 웹 브라우저의 캐시 데이터에 보관해서 서버로 불필요한 요청을 보내지 않도록 함.
    - 이러한 멱등성을 기반으로 캐시의 효과를 볼 수 있음.
- 캐시 가능
    - GET을 통해 서버에 리소스를 요청할 때 웹 캐시가 요청을 가로채서 서버로부터 리소스를 다시 받아오는 대신 복사본을 반환
- 브라우저 히스토리에 남음.
- 북마크 될 수 있음.

</br>

## POST 요청

> 리소스를 생성/업데이트 하기 위해 데이터를 보낼 때 사용되는 HTTP Method

- 전송하는 데이터들을 서버에 반영해야 하기 때문에 서버에 영향을 줌.
- 전송할 데이터를 body에 담아서 보냄.
    - 길이 제한이 없음.
    - 따라서 대용량 데이터 전송에 적합.
    - 겉으로 정보가 드러나는 GET보다는 보안적인 면에서 우수하나 암호화가 적용되지 않으면 POST 요청도 보안에 취약할 수 있음.
- 헤더의 Content-Type에 요청 데이터 타입을 표시해줘야 서버가 처리하기 편함.
- 캐시 불가능
- 브라우저 히스토리에 남지 않음.
- 북마크 할 수 없음.


### GET과 POST 비교

| | GET | POST |
| --- | --- | --- |
| 데이터 담는 위치 | header - URL(파라미터) | body |
| 데이터 길이 제한 | 있음 | 없음|
| 멱등성<sup>1</sup> | 보장 | 보장하지 않음. | 
| 캐시 | 가능 | 불가능|
| 브라우저 히스토리 | 남음. | 남지 않음|
| 북마크 | 됨 | 안됨 | 
| 보안 | URL에 데이터가 다 노출되기 때문에 POST 보다는 취약 | 데이터를 body에 담고 브라우저 히스토리가 저장되지 않기 때문에 GET 보다 안전 |

<sup>1</sup> 멱등성 : 연산을 여러 번 적용하더라도 결과가 달라지지 않는 성질




</br>

---

- 참고

    [HTTP Request Methods](https://www.w3schools.com/tags/ref_httpmethods.asp)

    [[네트워크] HTTP GET 요청과 POST 요청](https://pabeba.tistory.com/150#recentEntries)

    [HTTP의 GET과 POST 메서드 비교. [ 네트워크 면접 질문1 ]](https://murphymoon.tistory.com/entry/HTTP%EC%9D%98-GET%EA%B3%BC-POST-%EB%A9%94%EC%84%9C%EB%93%9C-%EB%B9%84%EA%B5%90-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC-%EB%A9%B4%EC%A0%91-%EC%A7%88%EB%AC%B81)