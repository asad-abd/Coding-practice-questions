import java.util.*;
import java.io.*;


class TreeTopView {

    /* 
    
    class Node 
        int data;
        Node left;
        Node right;
    */

    public static int heightTree(Node node)
    {
        if(node==null)
            return 0;
        return 1+(Math.max(heightTree(node.left),heightTree(node.right)));
    }
    public static void topView(Node root) {
       int n=heightTree(root);
        int grid[][]=new int[2*n+1][n];
        for(int i=0;i<2*n+1;i++)
            for(int j=0;j<n;j++)
                grid[i][j]=0;
        int rev[]=new int[n];int p=0;
        int notrev[]=new int[n];int q=0;
        if(root!=null)
        {
            MakeGrid(root,grid,0,0);
            for(int i=0;i<2*n+1;i++)
            {
                if(i%2!=0)
                for(int j=0;j<n;j++)
                {
                    if(grid[i][j]!=0)
                    {
                        rev[p++]=grid[i][j];
                        break;
                    }
                }
                else if(i%2==0)
                for(int j=0;j<n;j++)
                {
                    if(grid[i][j]!=0)
                    {
                        notrev[q++]=grid[i][j];
                        break;
                    }
                }
            }
            //not printing
            for(int i=rev.length-1;i>=0;i--)
                if(rev[i]!=0)
                    System.out.print(rev[i]+" ");
            for(int i=0;i<notrev.length;i++)
                if(notrev[i]!=0)
                    System.out.print(notrev[i]+" ");
               
        }
    }
    public static void MakeGrid(Node node,int grid[][],int x,int y)
    {
       if(node!=null)
       {
            if(x>=0)
                grid[x*2][y]=node.data;
            else if(x<0)
                grid[2*x*(-1)-1][y]=node.data;
            if(node.left!=null)
                MakeGrid(node.left,grid,x-1,y+1);
            if(node.right!=null)
                MakeGrid(node.right,grid,x+1,y+1);
       }
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }   
}