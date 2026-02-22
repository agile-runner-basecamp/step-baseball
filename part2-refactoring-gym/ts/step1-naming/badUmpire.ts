export class BadUmpire {
    public doS(a: number[], b: number[]): number {
        let r = 0;
        for (let i = 0; i < 3; i++) {
            if (a[i] === b[i]) {
                r++;
            }
        }
        return r;
    }

    public doB(a: number[], b: number[]): number {
        let r = 0;
        for (let i = 0; i < 3; i++) {
            for (let j = 0; j < 3; j++) {
                if (i !== j && a[i] === b[j]) {
                    r++;
                }
            }
        }
        return r;
    }
}
