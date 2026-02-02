
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    static int N;
    static int M;
    static int R;
    static int[][] array;
    static int[][] result;
    static boolean flipUD;
    static boolean flipLR;
    static int rotate=0;
    static int[] quad={0,1,2,3};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        M=Integer.parseInt(input[1]);
        R=Integer.parseInt(input[2]);
        array=new int[N][M];
        for(int i=0;i<N;i++){
            input=br.readLine().split(" ");
            for(int j=0;j<M;j++){
                array[i][j]=Integer.parseInt(input[j]);
            }
        }
        String[] order=(br.readLine().split(" "));
        Order(order);
        complete();
        print();

    }
    public static void Order(String[] order){
        for(int r=0;r<R;r++){
            int cmd=Integer.parseInt(order[r]);
            if (cmd == 1) { // 상하 반전
                flipUD = !flipUD;
                swapQuad(0, 3);
                swapQuad(1, 2);
            } else if (cmd == 2) { // 좌우 반전
                flipLR = !flipLR;
                swapQuad(0, 1);
                swapQuad(3, 2);
            } else if (cmd == 3) {
                rotate = (rotate + 1) % 4;
                swapFlip();
                rotateQuadClock();
            } else if (cmd == 4) {
                rotate = (rotate + 3) % 4;
                swapFlip();
                rotateQuadCounterClock();
            } else if (cmd == 5) {
                rotateQuadClock();
            } else if (cmd == 6) {
                rotateQuadCounterClock();
            }
        }
    }
    // quad 배열의 두 요소를 바꾸는 헬퍼 함수
    public static void swapQuad(int idx1, int idx2) {
        int temp = quad[idx1];
        quad[idx1] = quad[idx2];
        quad[idx2] = temp;
    }
    public static void rotateQuadClock(){
        int temp = quad[3];
        quad[3] = quad[2];
        quad[2] = quad[1];
        quad[1] = quad[0];
        quad[0] = temp;
    }
    public static void rotateQuadCounterClock(){
        int temp = quad[0];
        quad[0] = quad[1];
        quad[1] = quad[2];
        quad[2] = quad[3];
        quad[3] = temp;
    }

    public static void complete() {
        // 최종 회전 각도에 따라 결과 배열의 크기 결정
        // 90도(1) 혹은 270도(3) 회전 시 N과 M이 바뀜
        int finalN = N;
        int finalM = M;
        if (rotate % 2 == 1) {
            finalN = M;
            finalM = N;
        }

        result = new int[finalN][finalM];

        // 4개의 영역(좌상, 우상, 우하, 좌하)을 채움
        // pos: 0=좌상, 1=우상, 2=우하, 3=좌하 (현재 결과 배열에서의 위치)
        for (int pos = 0; pos < 4; pos++) {
            int originalIdx = quad[pos]; // 해당 위치에 들어갈 원본 그룹 번호

            // 원본 그룹 데이터 가져오기 (변환 전)
            int[][] subBlock = getOriginalBlock(originalIdx);

            // 해당 블록 자체에 대해 global rotation/flip 적용
            int[][] transformedBlock = transformBlock(subBlock);

            // 결과 배열의 올바른 위치에 복사
            fillResult(transformedBlock, pos, finalN, finalM);
        }
    }

    // 원본 배열에서 해당 그룹(0~3)에 해당하는 부분 배열 추출
    public static int[][] getOriginalBlock(int groupIdx) {
        int rStart = 0, rEnd = N / 2;
        int cStart = 0, cEnd = M / 2;

        if (groupIdx == 1) { // 우상 (원본 기준)
            cStart = M / 2; cEnd = M;
        } else if (groupIdx == 2) { // 우하 (원본 기준)
            rStart = N / 2; rEnd = N;
            cStart = M / 2; cEnd = M;
        } else if (groupIdx == 3) { // 좌하 (원본 기준)
            rStart = N / 2; rEnd = N;
        }

        // 원본 배열에서 추출
        int[][] block = new int[N / 2][M / 2];
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                block[i][j] = array[rStart + i][cStart + j];
            }
        }
        return block;
    }

    // 작은 블록 하나에 대해 현재 global 상태(rotate, flip)를 적용
    public static int[][] transformBlock(int[][] block) {
        int r = block.length;    // N/2
        int c = block[0].length; // M/2

        // 1. 회전 적용
        int[][] rotated;
        if (rotate == 0) {
            rotated = block;
        } else if (rotate == 1) { // 90도
            rotated = new int[c][r];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    rotated[j][r - 1 - i] = block[i][j];
                }
            }
        } else if (rotate == 2) { // 180도
            rotated = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    rotated[r - 1 - i][c - 1 - j] = block[i][j];
                }
            }
        } else { // 270도
            rotated = new int[c][r];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    rotated[c - 1 - j][i] = block[i][j];
                }
            }
        }

        // 2. 상하 반전 적용
        if (flipUD) {
            int fr = rotated.length;
            int fc = rotated[0].length;
            int[][] temp = new int[fr][fc];
            for(int i=0; i<fr; i++) {
                temp[i] = rotated[fr-1-i];
            }
            rotated = temp;
        }

        // 3. 좌우 반전 적용
        if (flipLR) {
            int fr = rotated.length;
            int fc = rotated[0].length;
            int[][] temp = new int[fr][fc];
            for(int i=0; i<fr; i++) {
                for(int j=0; j<fc; j++) {
                    temp[i][j] = rotated[i][fc-1-j];
                }
            }
            rotated = temp;
        }

        return rotated;
    }

    // 변환된 블록을 결과 배열의 pos 위치(0~3)에 기록
    public static void fillResult(int[][] block, int pos, int H, int W) {
        int rStart = 0, cStart = 0;
        int h = block.length;    // 높이 (N/2 혹은 M/2)
        int w = block[0].length; // 너비 (M/2 혹은 N/2)

        // pos: 0=좌상, 1=우상, 2=우하, 3=좌하
        if (pos == 1) {
            cStart = W / 2;
        } else if (pos == 2) {
            rStart = H / 2;
            cStart = W / 2;
        } else if (pos == 3) {
            rStart = H / 2;
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                result[rStart + i][cStart + j] = block[i][j];
            }
        }
    }
    public static void swapFlip(){
        boolean tmp = flipUD;
        flipUD = flipLR;
        flipLR = tmp;
    }
    public static void print(){
        StringBuilder sb= new StringBuilder();
        for(int i=0;i< result.length;i++){
            for(int j=0;j<result[0].length;j++){
                sb.append(result[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
