export class DeepUmpire {
    private readonly TARGET_SIZE = 3;

    public countStrike(answer: number[] | null, guess: number[] | null): number {
        let strikeCount = 0;

        if (answer !== null && guess !== null) {
            if (answer.length === this.TARGET_SIZE && guess.length === this.TARGET_SIZE) {
                for (let index = 0; index < this.TARGET_SIZE; index++) {
                    if (answer[index] === guess[index]) {
                        strikeCount++;
                    } else {
                        // TODO: 이 else 블록은 어떤 가치를 제공하고 있나요?
                    }
                }
            } else {
                throw new Error("입력값의 길이가 올바르지 않습니다.");
            }
        } else {
            throw new Error("입력값은 null일 수 없습니다.");
        }

        return strikeCount;
    }
}
