export class MassiveUmpire {
    public playGame(rawAnswer: string[], rawGuess: string[]): [number, number] {
        // 1. 입력 검증
        if (!rawAnswer || !rawGuess) {
            throw new Error("입력값은 null이나 undefined일 수 없습니다.");
        }
        if (rawAnswer.length !== 3 || rawGuess.length !== 3) {
            throw new Error("입력값의 길이가 3이어야 합니다.");
        }

        // 2. 파싱 (String -> Number)
        const answer: number[] = [];
        const guess: number[] = [];
        for (let i = 0; i < 3; i++) {
            const parsedAnswer = Number(rawAnswer[i]);
            const parsedGuess = Number(rawGuess[i]);

            if (Number.isNaN(parsedAnswer) || Number.isNaN(parsedGuess)) {
                throw new Error("숫자만 입력 가능합니다.");
            }

            answer.push(parsedAnswer);
            guess.push(parsedGuess);
        }

        // 3. 스트라이크 판정
        let strikeCount = 0;
        for (let i = 0; i < 3; i++) {
            if (answer[i] === guess[i]) {
                strikeCount++;
            }
        }

        // 4. 볼 판정
        let ballCount = 0;
        for (let i = 0; i < 3; i++) {
            for (let j = 0; j < 3; j++) {
                if (i !== j && answer[i] === guess[j]) {
                    ballCount++;
                }
            }
        }

        // 5. 결과 반환 [스트라이크, 볼]
        return [strikeCount, ballCount];
    }
}
