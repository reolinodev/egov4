# 기본 프레임 워크 개발 내용 - 최규연
1. jsp 기본 화면 띄우기 [0] - 테스트 완료
2. db 연결해보기 [0] - 테스트 완료 (globals.properties)
3. 프로퍼티 분리 하기 [O] - application-qa.properties 적용되는 것 확인
4. rest api 컨트롤러 만들어 보기 [0] - 테스트 완료
5. validator 사용해보기 [X] 
6. logback 수정 [0]
7. 테스트 코드 샘플 만들기 [0] - 완료
8. swagger 적용하기 [0] - 테스트 완료
9. 암호화 적용하기 [0] - 프레임워크가 가진 함수, 양방향 추가 - 테스트 완료
10. Transaction TransactionAdvisor 처리 [0] - 코드 적용된 상태. transaction이 rollback 되는지 확인 필요
11. 기존 백엔드 api 적용하기 [0]
12. 웹팩 적용하기 [0] - 완료
13. 기존 프론트엔드 화면 적용하기 [0] - 완료
14. 세션 처리, 로그아웃 처리 [0] - 완료
15. 아이프레임 화면 이전 url 히스토리 저장 [O]
16. 아이프레임 내에 컨텐츠가 늘어날 경우 아이프레임 높이 적용하기 []
17. 메뉴 관리 [O] - 완료
18. 텍스트 에디터 추가 [0]
19. 텍스트 에디터 뷰어 추가 [0]
20. 첨부파일 저장 [] - 멀티 첨부파일 업로드 되는 라이브러리 있는지 확인
21. 첨부파일 다운로드 []
22. 엑셀 업로드 []
23. 엑셀 다운로드 []
24. 히스토리 저장 [] - 특히 READ, UPDATE, DELETE 되는 거 확인
25. 권한처리 하기 [O]
26. 불필요한 소스 삭제 [0] - java단의 let은 남겨 놓음. utill이 존재함
27. swagger 오류 수정 []
28. 히스토리 메뉴 만들기 : 로그인 이력 및 조작 히스토리 []
29. 쿠키대신 로컬스토리지 사용 []
30. GIS 샘플 만들어보기 [O] : 완료
31. 외부 DB 연결 후 데이터 세팅 [0] : 완료 
32. 개발환경 세팅 가이드 작성 [0] : 완료 
33. 개발규약 가이드 작성 []
34. direct url 안나오게 처리 []
35. 테스트 개발 환경 구축하기 []
36. 불필요한 로그 정리 하기 []
37. 로그인시 시작시 세션스토리지 날리고 시작할 것 [0]
38. 메뉴 삭제시 하위 권한도 같이 삭제[0]
39. board 도메인으로 메뉴 설정[]

# 이슈사항
5.validation이 정상 작동하지 않음. 전자정부 자체 validation을
쓰던지 아니면 프론트 단에서 처리를 해야할듯

6.log42j의 불필요한 로그를 줄이고 싶은데 api 확인이 필요

9.DB프로퍼티 암호화 실패. 프레임워크에서 설정변경이 필요한듯
