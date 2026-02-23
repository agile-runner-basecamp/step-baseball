import { ConsoleUmpire, printResult, Umpire } from './consoleUmpire';

// TODO: 이 테스트 코드를 어떻게 짜야 할지 막막할 것입니다!
// ConsoleUmpire 가 값을 반환하는 대신 화면에 출력(console.log)만 하고 있기 때문입니다.
// 이 코드를 리팩토링하여 반환값을 갖게 만들고, 아래에 정상적인 단언(expect)을 작성해 보세요.
describe('Umpire', () => {
    const umpire = new Umpire();
    it('1스트라이크', () => {
        const result = umpire.judge([1, 2, 3], [1, 4, 5]);
        expect(result.strikes).toBe(1);
        expect(result.balls).toBe(0);
    });

    it('3스트라이크', () => {
        const result = umpire.judge([1, 2, 3], [1, 2, 3]);
        expect(result.strikes).toBe(3);
        expect(printResult(result)).toBe("3스트라이크");
    });
    it('낫싱',() => {
        const result = umpire.judge([1, 2, 3], [4, 5, 6]);
        expect(result.strikes).toBe(0);
        expect(result.balls).toBe(0);
        expect(printResult(result)).toBe("낫싱");
    });
    it('1볼 1스트라이크',() => {
        const result = umpire.judge([1, 2, 3], [1, 3, 4]);
        expect(result.strikes).toBe(1);
        expect(result.balls).toBe(1);
        expect(printResult(result)).toBe("1스트라이크 1볼");
    })
});
