/*
 * Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.

In a Unix-style file system, 
    a period '.' refers to the current directory, 
    a double period '..' refers to the directory up a level, 
    and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. 
For this problem, any other format of periods such as '...' are treated as file/directory names.

The canonical path should have the following format:

The path starts with a single slash '/'.
Any two directories are separated by a single slash '/'.
The path does not end with a trailing '/'.
The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
Return the simplified canonical path.
 */
class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        // using LL so that no need to reverse while poping
        for(String s: path.split("/")){
            if(s.equals("..")){ // move out of the directory/file -> pop the top
                if(stack.size() > 0)
                    stack.removeLast();
            }
            else if(!s.equals("") && !s.equals(".")){ // move into the directory/file -> push to top
                stack.addLast(s);
            // System.out.println(stack);
                
            }
        }
        
        StringBuilder str = new StringBuilder("/"); 
        while(stack.size() > 0){
            str.append(stack.removeFirst()+"/");
        }
        if(str.length() > 1)
            str.deleteCharAt(str.length() - 1);
        
        return str.toString();
    }
}