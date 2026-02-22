export class ConsoleUmpire {
    public play(answer: number[], guess: number[]): void {
        if (answer.length !== 3 || guess.length !== 3) {
            console.log("[ERROR] 숫자는 3자리여야 합니다.");
            return;
        }

        const strikeCount = this.countStrike(answer, guess);
        const ballCount = this.countBall(answer, guess);

        this.printResult(strikeCount, ballCount);
    }

    private countStrike(answer: number[], guess: number[]): number {
        let count = 0;
        for (let i = 0; i < 3; i++) {
            if (answer[i] === guess[i]) {
                count++;
            }
        }
        return count;
    }

    private countBall(answer: number[], guess: number[]): number {
        let count = 0;
        for (let i = 0; i < 3; i++) {
            for (let j = 0; j < 3; j++) {
                if (i !== j && answer[i] === guess[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private printResult(strikeCount: number, ballCount: number): void {
        if (strikeCount === 3) {
            console.log("3스트라이크");
            console.log("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }

        if (strikeCount === 0 && ballCount === 0) {
            console.log("낫싱");
            return;
        }

        const msgs: string[] = [];
        if (ballCount > 0) {
            msgs.push(`${ballCount}볼`);
        }
        if (strikeCount > 0) {
            msgs.push(`${strikeCount}스트라이크`);
        }
        console.log(msgs.join(" "));
    }
}
