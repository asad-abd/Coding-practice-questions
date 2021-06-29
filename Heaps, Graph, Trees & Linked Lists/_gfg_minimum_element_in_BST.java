public class _gfg_minimum_element_in_BST {
    int minValue(Node node)
    {
        if(node==null) return -1;
        
        else if(node.left==null) 
            return node.data;
        
        else
            return minValue(node.left);
    }
}
