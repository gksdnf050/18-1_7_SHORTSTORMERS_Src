# 18-1_7_SHORTSTORMERS_Src
자바 swing으로 ToDoList 프로그램 만들기



#1. 프로젝트 개요   

본 프로젝트는 대학생을 위한 과목별 To do list 관리 프로그램을 제작하는 프로젝트입니다.   
사용자(대학생)는 수강하는 과목과 그에 해당하는 To do(해야할 일)를 등록하고 체계적으로 관리할 수 있습니다.   
본 프로그램은 사용자가 체계적인 관리를 통해 일의 효율성을 높이는 것을 목적으로 합니다.   



 
2. 주요 일정

단계                일정                        산출물

Project plan        2018.03.26 – 2018.03.30     프로젝트 계획서

Requirement         2018.03.30 – 2018.04.13     요구사항 명세서,
Analysis                                        프로젝트 계획서

Design              2018.04.13 – 2018.05.03     Class 설계서,
                                                UI 설계서

Implementation      2018.05.04 – 2018.05.20     소스 코드

Testing             2018.05.21 – 2018.05.31     테스트 케이스,
                                                테스트 결과 보고서

Presentation        2018.05.31 – 2018.06.04     최종발표 PPT



 
3. 역할 및 책임

팀원      역할                            책임

임명진    Project Manager, Developer      프로젝트 전체적인 진행 상황을 관리하고 일감에 대한 분배를 책임진다. 
                                          또한 발주자와의 정확하고 활발한 의사소통을 통해 프로젝트의 방향을 제시한다.

천정호    Designer, Developer             발주자의 요구사항을 충족시키고 개발자가 이해할 수 있는 설계서를 작성한다. 또한 설계서를 통해 기능을 구현하는 소스코드를 작성한다.

이한울    Developer                       발주자의 요구사항을 기반으로 작성된 설계서를 통해 기능을 구현하는 소스코드를 작성한다.

김철환    Developer                       발주자의 요구사항을 기반으로 작성된 설계서를 통해 기능을 구현하는 소스코드를 작성한다.

조은재    Tester                          개발자의 결과물을 테스트하고 피드백을 제공한다. 오류 검출과 그에 따른 수정 상황에 대한 문서를 작성한다.

조성윤    Tester, Configureation Manager  개발자의 결과물을 테스트하고 피드백을 제공한다. 오류 검출과 그에 따른 수정 상황에 대한 문서를 작성한다. 
                                          또한 회의록 작성과 문서 관리를 책임진다.

 
 
 
4. 도구

(1) 일정 관리 도구

Redmine

웹 기반 오픈소스 이슈 관리 도구로, 화면 기반의 프로젝트 관리에 도움이 되도록 다양한 기능을 제공한다. 이슈 관리, PM, 개발자, QA 등 역할에 따른 권한 제어, Gantt 차트 및 달력, 주요 형상 관리 도구와의 연동하는 기능을 제공하여 사용자가 프로젝트를 체계적으로 관리할 수 있도록 돕는다

 

(2) 형상 관리 도구

Git

소스 코드를 포함한 모든 문서 관리를 위한 분산 버전 관리 시스템이다. 지속적으로 변경이 되는 파일들을 관리하는데 최신 버전 뿐만 아니라 전체 변경 이력을 기록한다. 각 사용자는 서버(Github)의 저장소 자체를 받아 서버와 동일한 환경에서 작업할 수 있다.

 

(3) 소스코드 작성 도구

Eclipse

프로젝트 개발 언어인 JAVA를 사용하는데 필요한 통합개발환경(IDE)이다.

 

(4) 빌드 시스템

Maven3

Apache Maven은 프로젝트 관리 도구로 POM(Project Object Model)의 개념을 바탕으로 프로젝트의 빌드를 관리한다. 또한 분산되어 있는 라이브러리를 중앙 집중 형태로 모아 관리한다.

 

(5) 문서 관리 도구

MS Word, MS Powerpoint

모든 문서 작성의 환경 및 양식은 MS Word로 통일한다. 또한 발표에 필요한 PPT는 MS Powerpoint를 사용한다.

 
 
 
5. 주요 기능 및 설명

(1) 로그인 기능

사용자는 To do List프로그램을

사용하기 위해 로그인을 해야한다.

고객 기능 요구사항: 로그인

 

(2) 수강과목 등록 기능

사용자가 수강하는 과목을 등록할 수 있다.

고객 기능 요구사항: 수강과목 등록/수정/삭제

 

(3) 과목 별 To do 항목 등록 기능

사용자는 과목 별로 To do 항목(해야할 일)을 등록할 수 있다.

고객 기능 요구사항: 과목별 To do List 등록/수정/삭제

 

(4) 별도 표시 기능

사용자가 To do 항목 등록 또는 수정하는 과정에서 중요도 1, 2, 3 중 하나를 선택할 경우,

해당 항목은 그 과목의 To do리스트에서 중요도가 숫자로 표현된다.

고객 기능 요구사항: 중요 To do 항목 별도 표시, To do List 정렬 기능,

To do 완료 항목 숨기기, To do 완료 항목 보이기

 

(5) 휴지통 기능

삭제된 To do 항목들을 모아 조회할 수 있는 휴지통 기능을 제공한다.

고객 기능 요구사항: 휴지통 항목 삭제, 휴지통 복구

 

(6) To do List 전체 조회 기능

모든 과목의 To do 항목들을 조회할 수 있는 기능을 제공한다.

고객 기능 요구사항: 전체 과목 To do List 조회
