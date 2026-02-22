import { MassiveUmpire } from './massiveUmpire';

describe('MassiveUmpire', () => {
    it('정상_동작_판정_확인', () => {
        const umpire = new MassiveUmpire();
        const answer = ["1", "2", "3"];
        const guess = ["1", "4", "2"];

        const result = umpire.playGame(answer, guess);

        expect(result[0]).toBe(1); // 1스트라이크
        expect(result[1]).toBe(1); // 1볼
    });

    it('숫자가_아닌_문자_입력시_예외발생', () => {
        const umpire = new MassiveUmpire();
        const answer = ["1", "2", "3"];
        const guess = ["1", "a", "3"];

        expect(() => umpire.playGame(answer, guess)).toThrow('숫자만 입력 가능합니다.');
    });

    it('입력값이_null이면_예외발생', () => {
        const umpire = new MassiveUmpire();
        expect(() => umpire.playGame(null as any, ["1", "2", "3"])).toThrow();
    });

    it('모두_같은_숫자일때_3스트라이크_0볼', () => {
        const umpire = new MassiveUmpire();
        const result = umpire.playGame(["1", "2", "3"], ["1", "2", "3"]);
        expect(result[0]).toBe(3);
        expect(result[1]).toBe(0);
    });

    it('모두_다른_숫자일때_0스트라이크_0볼', () => {
        const umpire = new MassiveUmpire();
        const result = umpire.playGame(["1", "2", "3"], ["4", "5", "6"]);
        expect(result[0]).toBe(0);
        expect(result[1]).toBe(0);
    });
});
