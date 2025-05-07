package 동영상재생기;

public class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLen = calc(video_len);
        int posSec = calc(pos);
        int opStrt = calc(op_start);
        int opEnd = calc(op_end);

        for(int i=0; i<commands.length; i++){
            String command = commands[i];

            if(opStrt <= posSec && posSec <= opEnd){
                posSec = opEnd;
            }

            if(command.equals("prev")){
                posSec -= 10;

                if(posSec < 0){
                    posSec = 0;
                }
            }else if(command.equals("next")){
                posSec += 10;

                if(posSec > videoLen){
                    posSec = videoLen;
                }
            }
        }

        if(opStrt <= posSec && posSec <= opEnd){
            posSec = opEnd;
        }

        String min = posSec/60 < 10 ? "0" + posSec/60 + ":" : posSec/60 + ":";
        String sec = posSec%60 < 10 ? "0" + posSec%60 : posSec%60 + "";

        return min + sec;
    }

    int calc(String val){
        String[] tmp = val.split(":");

        int min = Integer.valueOf(tmp[0]) * 60;
        int sec = Integer.valueOf(tmp[1]);

        return min + sec;
    }
}
