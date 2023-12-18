고민 상담 챗봇 기반 영화 추천 시스템 - We:Lover
---
## 팀원 소개
<table>
  <tr>
    <td align="center"><a href="https://github.com/pjho4746">박지호(PM)</a></td>
    <td align="center">서채은</td>
    <td align="center">김서영</td>
    <td align="center">이재현</td>
  </tr>
  <tr>
    <td align="center">pjho4746@gmail.com</td>
    <td align="center">@gmail.com</td>
    <td align="center">@gmail.com</td>
    <td align="center">@gmail.com</td>
  </tr>
  <tr>
    <td align="center">풀스택 개발자</td>
    <td align="center">풀스택 개발자</td>
    <td align="center">풀스택 개발자</td>
    <td align="center">풀스택 개발자</td>
  </tr>
  <tr>
    <td align="center"><img src="https://github.com/DSHanul2023/Hanul-Backend/assets/126854628/606bbf95-fe28-4e01-8789-e8ba93e05995?raw=true" width="100px"></td>
    <td align="center"><img src="https://github.com/DSHanul2023/Hanul-Backend/assets/126854628/e7a35f81-41e5-49d0-b25a-289d064dd551?raw=true" width="100px"></td>
    <td align="center"><img src="https://github.com/DSHanul2023/Hanul-Backend/assets/126854628/38607519-a067-4d00-9e9a-fe44fac12fad?raw=true" width="100px"></td>
    <td align="center"><img src="https://github.com/DSHanul2023/Hanul-Backend/assets/126854628/6a9a0a7d-4678-4558-b8db-565e6b9c9869?raw=true" width="100px"></td>
  </tr>
</table>

## 개요
정신건강은 현대 사회에서 중요한 문제 중 하나로 부상하고 있습니다. 국내 정신질환 평생 유병률은 27.8%로 나타나고 있으며, 이에 따른 정신건강 서비스의 필요성이 커지고 있습니다. 그러나 국내 정신건강 서비스 이용률은 7.2%에 그칩니다. 캐나다나 미국의 경우 정신건강 서비스 이용률이 각각 43.1%, 46.5%에 이른다는 점을 고려해 보았을 때 우리나라는 현저하게 낮은 수준입니다.

글로벌 디지털 정신건강 관리 솔루션 시장은 코로나 이후 크게 성장할 것으로 예측되는데, 정신건강 앱 다운로드 수가 코로나 발생 이전 대비 17.6% 증가했다는 보고가 있습니다. 심리적 불안 지속과 이동성 제약에 따라, 디지털 기술 기반의 비대면 정신건강 관리 서비스에 대한 소비자 인식과 수용도가 개선되었다고 봅니다. 

고민 상담 내용을 기반으로 영화 추천 및 위로와 조언을 제공하는 웹 기반 서비스를 구현했습니다. 사용자가 심리적 거리를 줄이고 쉽게 접근할 수 있도록 애완동물 콘셉트를 활용하였습니다. AI 챗봇을 활용한 고민 상담을 통해 위로 및 제안을 제공하고, 대화 내용을 기반으로 영화를 추천하는 시스템을 제안합니다. KoBert 모델을 이용하여 사용자의 감성을 분석하고, KoGPT 모델을 활용해 챗봇 응답을 생성합니다.

## 시연 영상
최종 결과물  
https://drive.google.com/file/d/169lrsR1uvXOvaUwd7PUo9AbA7ArDlu7L/view?usp=sharing  
중간 결과물 - 자막 설명 O  
https://drive.google.com/file/d/1O8J9JzyTLuCX4OO8brG8q5OUO2SSy6fR/view?usp=sharing 

## 프로그램 흐름
![프로그램 흐름](https://github.com/DSHanul2023/Hanul-Backend/assets/126854628/19275386-fb62-4c02-b8d3-0a5ff4e3a0a2)

## 기술 아키텍쳐
![아키텍처](https://github.com/DSHanul2023/Hanul-Backend/assets/126854628/59080cd0-ae92-446d-bea6-c119fb041ec0)

## 메인 기능
1. 챗봇 서비스  
Dialogflow의 action을 기반으로 인사, 위로 및 조언, 추천 순서의 대화 흐름을 가지고 있습니다. Dialogflow Webhook을 통해 사용자의 입력을 처리하며, action이 위로 및 조언인 경우 Flask를 통해 생성된 KoGPT2 모델의 응답을 반환합니다. 이 모델은 고민 상담 목적의 챗봇을 위해 파인 튜닝 되었으며, 사용자의 고민에 대해 부드럽게 반응하고 공감하며 조언을 제공하는 데 중점을 두었습니다. 생성 모델은 미리 학습된 가중치를 기반으로 사용자의 입력 문장을 받아 응답을 생성합니다. 모델 훈련 과정에서는 Aihub의 웰니스 대화 스크립트 데이터셋이 사용되었으며 Cross Entropy Loss와 Adam Optimizer를 사용하여 진행하였습니다.
![챗봇서비스](https://github.com/DSHanul2023/Hanul-Backend/assets/126854628/d56d894f-f0f4-46cc-839f-90c16189a72e)<br>

2.  감정 분류<br>
감성 분류 모델은 사용자의 발화에서 감성을 분류합니다. 감성 분류 모델은 웰니스 대화 스크립트 데이터셋 (AI허브)와 한국어 단발성 대화 데이터셋 (AI허브)을 사용하여 kobert에 학습하였습니다.
![감정분류](https://github.com/DSHanul2023/Hanul-Backend/assets/126854628/42a46f7e-19c6-4ec7-a220-cadaa9537f75)<br>
분류된 감성은 미리 정의된 장르로 매핑됩니다. <br>

3. 맞춤 영화 추천
<table>
  <tr>
    <th>감정</th>
    <th>장르</th>
  </tr>
  <tr>
    <td>화</td>
    <td>액션, 범죄</td>
  </tr>
  <tr>
    <td>걱정</td>
    <td>드라마, 로맨스, 가족</td>
  </tr>
  <tr>
    <td>불안</td>
    <td>로맨스, 드라마</td>
  </tr>
  <tr>
    <td>우울</td>
    <td>드라마, 음악, 코미디</td>
  </tr>
  <tr>
    <td>두려움</td>
    <td>애니메이션, 가족</td>
  </tr>
  <tr>
    <td>슬픔</td>
    <td>드라마, 애니메이션, 코미디</td>
  </tr>
  <tr>
    <td>기쁨</td>
    <td>판타지, 모험, 액션</td>
  </tr>
  <tr>
    <td>중립</td>
    <td>모험</td>
  </tr>
</table>

매핑된 장르를 기반으로 영화를 1차 필터링한다.  
(1) 사용자 발화를 벡터화하여 영화 줄거리 간의 코사인 유사도를 계산한다.  
(2) 사용자 선호 영화와 1차 필터링된 영화의 메타데이터(키워드, 감독, 배우, 장르)를 계산하여 유사도를 계산한다.  <br><br>
(1)과 (2)의 결과를 더해 정규화하여 결괏값이 높은 순으로 추천 영화 8개를 추천합니다. 이와 같은 흐름으로 사용자는 채팅을 기반으로 맞춤 영화를 추천받을 수 있습니다.
![맞춤영화 추천](https://github.com/DSHanul2023/Hanul-Backend/assets/126854628/3aaf1ccc-d0ed-4bca-a9b1-e6f9bf717a51) <br>

5. 영화 스트리밍 연결  
TMDB API를 활용하여 다양한 영화 데이터를 구축했습니다. 사용자는 해당 서비스에서 추천받은 영화를 스크롤을 통해 구현한 넷플릭스, 디즈니플러스, 티빙 등의 영화 스트리밍 사이트로 쉽게 연결할 수 있습니다. 이를 통해 사용자는 선호하는 스트리밍 플랫폼에서 즉시 영화를 시청할 수 있습니다.<br>

6. 영화 추천 체험  
회원 가입 없이 간단한 설문조사를 통해 영화 추천 기능 체험 가능합니다. 사용자는 현재 감정과 선호하는 장르를 선택하여 영화 추천을 받을 수 있습니다.
![체험](https://github.com/DSHanul2023/Hanul-Backend/assets/126854628/0ee41f0d-37df-4ff4-8a3e-8c4e06e75e59)

