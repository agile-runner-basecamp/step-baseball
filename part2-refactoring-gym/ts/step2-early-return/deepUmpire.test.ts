import { DeepUmpire } from './deepUmpire';

describe('DeepUmpire', () => {
    it('정상_동작', () => {
        const umpire = new DeepUmpire();
        const answer = [1, 2, 3];
        const guess = [1, 4, 5];
        const strike = umpire.countStrike(answer, guess);
        expect(strike).toBe(1);
    });

    it('입력값이_null이면_예외발생', () => {
        const umpire = new DeepUmpire();
        expect(() => umpire.countStrike(null, [1, 2, 3])).toThrow('입력값은 null일 수 없습니다.');
    });

    it('입력값의_크기가_다르면_예외발생', () => {
        const umpire = new DeepUmpire();
        expect(() => umpire.countStrike([1, 2], [1, 2, 3])).toThrow('입력값의 길이가 올바르지 않습니다.');
    });
});
