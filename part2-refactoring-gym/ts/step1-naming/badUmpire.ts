export class BadUmpire {
    public countStrike(target: number[], answer: number[]): number {
        let result = 0;
        for (let i = 0; i < 3; i++) {
            if (target[i] === answer[i]) {
                result++;
            }
        }
        return result;
    }

    public countBall(target: number[], answer: number[]): number {
        let result = 0;
        for (let i = 0; i < 3; i++) {
            for (let j = 0; j < 3; j++) {
                if (i !== j && target[i] === answer[j]) {
                    result++;
                }
            }
        }
        return result;
    }
}
