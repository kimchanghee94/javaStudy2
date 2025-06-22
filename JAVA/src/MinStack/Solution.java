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
