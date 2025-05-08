package CyclicRotation;

public class Solution {
    public int[] solution(int[] A, int K) {
        int ASize = A.length;
        K %= ASize;

        for(int k=0; k<K; k++){
            int tmp = A[ASize-1];

            for(int i=ASize-1; i>0; i--){
                A[i] = A[i-1];
            }

            A[0] = tmp;
        }

        return A;
    }
}
