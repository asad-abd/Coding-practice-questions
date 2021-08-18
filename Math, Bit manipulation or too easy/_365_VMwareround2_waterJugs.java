class _365_VMwareround2_waterJugs {
    /* States of the jug. x<y
                        (0,0)
                (x,0)           (0,y)   
            (0,x)   (x,y)   (x,y-x) (x,y)
            
                        (0,0)
                (3,0)           (0,5)
            (0,3)   (3,5)   (3,5)       (3,2)
                                    (0,2)   (1,5)
                                    (2,0)    
                                        
    */
    class State{
        int x,y;
        State(int a, int b){
            this.x=a;
            this.y=b;
        }
    } 
    //runs correctly for the testcases. memory limit exceeded though.
    public boolean canMeasureWater(int x, int y, int z) {
        if(x>y){
            int temp=y;
            y=x;
            x=temp;
        }
        boolean visited[][]=new boolean[x+1][y+1];//state visited table of jugs
        State start=new State(0,0);
        Queue<State> q=new LinkedList<>();
        q.add(start);
        //run a bfs. don't add already visited states
        while(q.size()>0){
            int n=q.size();
            State curr=q.poll();
            if(curr.x+curr.y==z)
                return true;
            visited[curr.x][curr.y]=true;
            
            int newY,newX;
            //pour x->y ********************* option 1
            newX=curr.x-Math.min(curr.x,y-curr.y);
            newY=curr.y+Math.min(curr.x,y-curr.y);
            if(!visited[newX][newY])
                q.add(new State(newX,newY));
            
            //pour x<-y ********************* option 2
            newX=curr.x+Math.min(curr.y,x-curr.x);
            newY=curr.y-Math.min(curr.y,x-curr.x);
            if(!visited[newX][newY])
                q.add(new State(newX,newY));
            
            //expty x   ********************* option 3
            newX=0;
            newY=curr.y;//same
            if(!visited[newX][newY])
                q.add(new State(newX,newY));
            
            //empty y   ********************* option 4
            newX=curr.x;//same
            newY=0;
            if(!visited[newX][newY])
                q.add(new State(newX,newY));
            
            //fill x    ********************* option 5
            newX=x;//max capacity
            newY=curr.y;
            if(!visited[newX][newY])
                q.add(new State(newX,newY));
            
            //fill y    ********************* option 6
            newX=curr.x;
            newY=y;//max capacity
            if(!visited[newX][newY])
                q.add(new State(newX,newY));
        }
        return false;
    }
}
