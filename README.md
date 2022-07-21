# 전자정부 프레임워크 4.0 기반의 관리자 사이트

※ 전자정부 프레임워크 4.0의 샘플 예제를 기반으로 만든 관리자 사이트 입니다. 백엔드와 프론트엔드가 결합된 형태입니다.
원하는 형태로 수정해서 사용하시면 됩니다.


## BackEnd 환경 및 실행 방법
프로젝트에서 사용된 환경 프로그램 정보는 다음과 같습니다.

|프로그램 명  |버전 명 |
|---------  |------ |
|java       |1.8    |
|maven      |3.8.1  |
|postgresql |       |
|Mybatis    |2.2.2  |

DB는 postgresql을 사용 하였습니다. 다른 DB를 사용하시려면 globals.properties 파일을 변경 하시면 됩니다.
또 해당 쿼리가 postgresql에 맞춰진 만큼 쿼리 수정이 필요합니다.

소스를 다운로드 받으신 후에 maven 라이브러리를 받습니다.
EgovBootApplication을 실행시키면 BackEnd가 실행이 됩니다.

http://localhost:8080/admin/api
를 호출하면 스웨거 화면이 나타납니다. 그럼 정상적으로 실행이 된 것입니다.


## FrontEnd 환경 및 실행 방법
FrontEnd 템플릿은 jsp 이며 다양한 외부 라이브러리를 사용하고 있습니다.

|프로그램 명  |버전 명 |
|---------  |------ |
|webpack       |5.50.0   |
|toast-ui      |3.1.7  |
|jquery |3.6.0       |
|lodash    |4.17.21  |
|moment    |2.29.1 |
|eslint    |7.32.0  |
|babel    |7.15.0  |
|prettier    |2.3.2  |

webpack.config.js에 각 js 파일들을 output으로 설정하고 있습니다.
module 폴더에 공통으로 사용할 컴퍼넌트를 작성했으며 adminConfig에는 시스템에서 공통적으로
사용하는 라이브러리 파일들을 import 하였습니다.

webapp 폴더에서
````
npm install
````
실행 시켜서 package.json 파일에 등록된 라이브러리를 설치합니다.

설치가 끝난 후에
````
npm run dev
````
를 실행 시키면 dist 폴더에 패킹한 js가 생성됩니다.

http://localhost:8080/
를 실행시켜 로그인 페이지가 나타나면 정상적으로 실행됨을 볼수 있습니다.







