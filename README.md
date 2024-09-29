# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


# 기능 항목
- 사용자는 2가지를 입력한다.몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
  - 자동차 수
  - 이동 가능한 횟수
- 아래의 조건이 만족되면 전진한다.
  - 각 라운드마다 0에서 9까지의 랜덤한 숫자를 뽑고, 숫자가 4 이상일 경우 해당 자동차는 전진한다.
- 라운드가 끝날 때마다 각 자동차의 전진 상태를 출력한다.

