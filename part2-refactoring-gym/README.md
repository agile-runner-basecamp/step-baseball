# Part 2: Refactoring Gym — 나쁜 코드 고치기 훈련장

의도적으로 나쁘게 작성된 코드 4종이 준비되어 있습니다.
**모든 테스트는 이미 통과**합니다. 기능을 추가할 필요는 없습니다.

목표는 단 하나: **읽기 좋은 코드로 개선하기.**

> 🖥️ **프로젝트 열기:**
> - **BE (Java):** IntelliJ에서 `part2-refactoring-gym/java/` 폴더를 열어주세요.
> - **FE (TypeScript):** VSCode에서 `part2-refactoring-gym/ts/` 폴더를 열고, `npm install`을 실행하세요.

---

## 🏋️‍♂️ 훈련 코스

각 스텝 폴더의 `README.md`를 읽고 리팩토링하세요.

### Step 1: `step1-naming` — 이름 짓기
- 😱 `doS`, `doB`, `a`, `b`, `r` — 이 코드가 뭘 하는 건지 아무도 모릅니다.
- ✏️ 의미 있는 이름 붙이기 + 매직 넘버 상수 추출

### Step 2: `step2-early-return` — Early Return
- 😱 `if-else`가 3~4단계로 중첩. 읽기 싫은 코드의 정석.
- ✏️ `else` 전부 제거하고 depth를 1단계로 평탄화

### Step 3: `step3-method-sep` — 메서드 분리
- 😱 입력 검증부터 결과 반환까지 50줄이 한 메서드 안에 뭉쳐있음.
- ✏️ "한 메서드 = 한 가지 일" 원칙으로 잘게 쪼개기

### Step 4: `step4-ui-separation` — 관심사 분리
- 😱 판정 로직 한가운데에 `System.out.println` / `console.log`가 섞여 있음.
- ✏️ 도메인(Model)과 출력(View) 분리 → 테스트 가능한 순수 로직 만들기

---

> 💡 **리팩토링의 황금 원칙:**
> 코드를 한 줄 고쳤다면, **테스트를 돌려서 Green인지 확인**하세요.
> 테스트가 깨졌다면 `Ctrl+Z`로 되돌리고 더 작게 시도하세요. 이것이 TDD 리팩토링입니다.
