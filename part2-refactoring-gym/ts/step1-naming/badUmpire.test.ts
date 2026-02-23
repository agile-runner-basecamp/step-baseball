import { BadUmpire } from './badUmpire';

describe('BadUmpire', () => {
    it('같은자리 같은숫자는 스트라이크', () => {
        const u = new BadUmpire();
        const guess = [1, 2, 3];
        const answer = [1, 4, 5];
        const strikeCount = u.countStrikes(guess, answer);
        expect(strikeCount).toBe(1);
    });

    it('모든 자리가 같으면 3스트라이크', () => {
        const u = new BadUmpire();
        const guess = [1, 2, 3];
        const answer = [1, 2, 3];
        const strikeCount = u.countStrikes(guess, answer);
        expect(strikeCount).toBe(3);
    });

    it('다른자리 같은 숫자 볼', () => {
        const u = new BadUmpire();
        const guess = [1, 2, 3];
        const answer = [3, 1, 2];
        const ballCount = u.countBalls(guess, answer);
        expect(ballCount).toBe(3);
    });
});
