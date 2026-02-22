import { BadUmpire } from './badUmpire';

describe('BadUmpire', () => {
    it('t1', () => {
        const u = new BadUmpire();
        const a = [1, 2, 3];
        const b = [1, 4, 5];
        const r = u.doS(a, b);
        expect(r).toBe(1);
    });

    it('t2', () => {
        const u = new BadUmpire();
        const a = [1, 2, 3];
        const b = [1, 2, 3];
        const r = u.doS(a, b);
        expect(r).toBe(3);
    });

    it('t3', () => {
        const u = new BadUmpire();
        const a = [1, 2, 3];
        const b = [3, 1, 2];
        const r = u.doB(a, b);
        expect(r).toBe(3);
    });
});
