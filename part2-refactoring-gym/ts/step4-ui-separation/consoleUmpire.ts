export type UmpireResult = {
    strikes: number;
    balls: number;
};


export class Umpire {
    private readonly TARGET_SIZE = 3;
    public judge(answer: number[], guess: number[]): UmpireResult {
        if (answer.length !== this.TARGET_SIZE || guess.length !== this.TARGET_SIZE) {
            throw new Error("입력값의 길이가 3이어야 합니다.");
        }

        const strikeCount = this.countStrike(answer, guess);
        const ballCount = this.countBall(answer, guess);

        return { strikes: strikeCount, balls: ballCount };
    }

    private countStrike(answer: number[], guess: number[]): number {
        let count = 0;
        for (let i = 0; i < this.TARGET_SIZE; i++) {
            if (answer[i] === guess[i]) {
                count++;
            }
        }
        return count;
    }

    private countBall(answer: number[], guess: number[]): number {
        let count = 0;
        for (let i = 0; i < this.TARGET_SIZE; i++) {
            for (let j = 0; j < this.TARGET_SIZE; j++) {
                if (i !== j && answer[i] === guess[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}

export function printResult(result: UmpireResult): string {
    const { strikes, balls } = result;

    if (strikes === 3) {
        return "3스트라이크";
    }

    if (strikes === 0 && balls === 0) {
        return "낫싱";
    }

    const msgParts: string[] = [];
    if (strikes > 0) {
        msgParts.push(`${strikes}스트라이크`);
    }

    if (balls > 0) {
        msgParts.push(`${balls}볼`);
    }
    return msgParts.join(" ");
}

export class ConsoleUmpire {
    private readonly umpire = new Umpire();

    play(answer: number[], guess: number[]): void {
        try {
            const result = this.umpire.judge(answer, guess);
            console.log(printResult(result));
        } catch (error) {
            console.error("게임 중 오류가 발생했습니다:", error);
        }
        
    }
}