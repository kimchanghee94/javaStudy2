package SimplifyPath;

import java.util.*;

public class Solution {
    public String simplifyPath(String path) {
        Stack<String> s=new Stack<>();
        String[] dirs=path.split("/");
        for(String dir:dirs){
            if(dir.equals(".")||dir.equals("")) continue;
            else if(dir.equals("..")) {
                if(!s.isEmpty()) s.pop();
            }
            else s.push(dir);
        }
        return "/"+String.join("/",s);
    }
}
