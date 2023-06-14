import java.util.*;

public class assignment {
    public static void main(String[] args) {
        int[] cpArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int[] inputNum = new int[3];
        int str = 0;
        int ball = 0;
        int cnt = 0;

        for (int i = 0; i < cpArr.length; i++) {
            cpArr[i] = (int) (Math.random() * 10); // 랜덤숫자를 나타냄
            for (int j = 0; j < i; j++) { // 같은 숫자가 있는지 확인
                if (cpArr[j] == cpArr[i]) {
                    i--;
                    break;
                }
            }
        }
        int[] anArr = {cpArr[0], cpArr[1], cpArr[2]}; //컴퓨터는 서로 다른 숫자 3개를 무작위로 뽑는다.

        System.out.println(Arrays.toString(anArr));

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("숫자를 입력하세요: ");
            int N = sc.nextInt();

            LinkedList<Integer> nNum = new LinkedList<Integer>();
            for (int i = 0; i < inputNum.length; i++) {
                nNum.push(N % 10);
                N = N / 10;
            }
            for (int i = 0; i < inputNum.length; i++) {
                inputNum[i] = nNum.pop();
            }
            cnt++;
            if (Arrays.equals(anArr, inputNum)) {
                System.out.println(cnt+"번만에 맞췄습니다.");
                System.out.println("게임을 종료합니다.");
                break;
            } else {
                for (int i = 0; i < anArr.length; i++)
                    for (int j = 0; j < inputNum.length; j++) {
                        if (anArr[i] == inputNum[j] && i == j)
                            str++;
                        else if (anArr[i] == inputNum[j] && i != j)
                            ball++;
                    }
                System.out.println(ball + "B" + str + "S");
                str = 0;
                ball = 0;

            }

        }
    }
}