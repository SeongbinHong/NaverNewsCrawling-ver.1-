# NaverNewsCrawling-ver.1-

[제약 조건]
네이버 뉴스에 등록된 뉴스만 필요
네이버 API는 네이버 뉴스에 등록되지 않고, 자사 홈페이지에 등록된 뉴스들도 같이 반환해줌
data.items[index].link를 통해서 https://n.news.naver.com 으로 시작하는 데이터만 추출해야 함
이미지가 등록된 뉴스만 필요
네이버 뉴스중에는, 이미지 없이 글로만 쓰여진 뉴스들이 존재함
뉴스를 직접 크롤링 하여, 이미지 태그가 존재하는지 확인 후 이미지 링크를 같이 알 수 있어야함

[구현 방식]
Front에서 Back으로 api 요청
Back은 네이버 뉴스 api를 활용해 데이터를 가져온다
가져온 데이터를 2가지 기준으로 필터링 한다.
네이버 뉴스에 등록된 기사만 가져온다
크롤링을 통해 img태그가 포함된 뉴스 기사만 가져온다
api로 응답받은 title, link, description에 imageLink를 포함하여 restapi로 반환해준다.
Front에서 api 응답을 받아 화면에 보여준다.
