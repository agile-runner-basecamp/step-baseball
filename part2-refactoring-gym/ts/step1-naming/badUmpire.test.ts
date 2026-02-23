import { BadUmpire } from './badUmpire';

describe('BadUmpire', () => {
    it('같은 자리에 같은 수가 있으면 스트라이크이다.', () => {
        const umpire = new BadUmpire();
        const target = [1, 2, 3];
        const answer = [1, 4, 5];
        const result = umpire.countStrike(target, answer);
        expect(result).toBe(1);
    });

    it('세 자리 모두 같으면 3스트라이크이고, 게임이 종료된다.', () => {
        const umpire = new BadUmpire();
        const target = [1, 2, 3];
        const answer = [1, 2, 3];
        const result = umpire.countStrike(target, answer);
        expect(result).toBe(3);
    });

    it('다른 자리에 같은 수가 있으면 볼이다.', () => {
        const umpire = new BadUmpire();
        const target = [1, 2, 3];
        const answer = [3, 1, 2];
        const result = umpire.countBall(target, answer);
        expect(result).toBe(3);
    });
});
