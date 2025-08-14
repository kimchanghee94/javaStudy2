package MinStack;

public class Solution {
    int s[],ms[];
    int t,mt;

    public Solution() {
        this.s = new int[30005];
        this.ms = new int[30005];
        this.t=-1;
        this.mt=-1;
    }

    public void push(int val) {
        if(mt==-1||val<=ms[mt]) ms[++mt]=val;
        s[++t]=val;
    }

    public void pop() {
        if(s[t]==ms[mt]) --mt;
        --t;
    }

    public int top() {
        return s[t];
    }

    public int getMin() {
        return ms[mt];
    }
}

/*
class MinStack {
    int[] arr, mArr;
    int top, mTop;

    public MinStack() {
        arr=new int[30005];
        mArr=new int[30005];
        top=0;
        mTop=0;
    }

    public void push(int val) {
        if(mTop==0 || val<=mArr[mTop-1]) mArr[mTop++]=val;
        arr[top++]=val;
    }

    public void pop() {
        if(mArr[mTop-1]==arr[top-1]) mTop--;
        top--;
    }

    public int top() {
        return arr[top-1];
    }

    public int getMin() {
        return mArr[mTop-1];
    }
}
*/
