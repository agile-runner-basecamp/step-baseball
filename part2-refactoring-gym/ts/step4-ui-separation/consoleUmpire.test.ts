import { ConsoleUmpire } from './consoleUmpire';

// TODO: 이 테스트 코드를 어떻게 짜야 할지 막막할 것입니다!
// ConsoleUmpire 가 값을 반환하는 대신 화면에 출력(console.log)만 하고 있기 때문입니다.
// 이 코드를 리팩토링하여 반환값을 갖게 만들고, 아래에 정상적인 단언(expect)을 작성해 보세요.
describe('ConsoleUmpire', () => {
    it('출력테스트는_어떻게_할까요', () => {
        const umpire = new ConsoleUmpire();
        const answer = [1, 2, 3];
        const guess = [1, 4, 5];

        // 실행은 되지만 테스트 코드에서 결과를 검증할 방법이 없습니다!
        umpire.play(answer, guess);

        // TODO: 아래와 비슷한 검증이 가능해지도록 콘솔 로직을 걷어내세요.
        // const result = umpire.judge(answer, guess);
        // expect(result).toBe("1스트라이크");
    });
});
