import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
 
public class TreeHelper
{
    private TreeNode root;
     
    public TreeNode getRoot()
    {
        return root;
    }
 
 
    public void setRoot(TreeNode root)
    {
        this.root = root;
    }
 
    private List<TreeNode> TreeNodeList;
     
    public TreeHelper(List<TreeNode> TreeNodeList)
    {
        this.TreeNodeList = TreeNodeList;
        generateTree();
    }
     
    /**
     *
     * <生成树>
     * <功能详细描述>
     * @author soul390
     */
    private void generateTree()
    {
        HashMap<Integer, TreeNode> TreeNodeMap = putTreeNodesIntoMap();//获取根，并保存map
        putChildIntoParent(TreeNodeMap);
    }
     
    /**
     *
     * <根据节点的selfId，生成HashMap>
     * <功能详细描述>
     * @return
     * @author soul390
     */
    protected HashMap<Integer, TreeNode> putTreeNodesIntoMap()
    {
        int maxId = Integer.MAX_VALUE;
        HashMap<Integer, TreeNode> hashMap = new HashMap<>();
         
        for(TreeNode TreeNode:TreeNodeList)
        {
            int selfId = TreeNode.getSelfId();
             
            if(selfId < maxId)
            {
                // 根节点
                root = TreeNode;
                maxId = selfId;
            }
             
            hashMap.put(selfId, TreeNode);
        }
         
        return hashMap;
    }
     
    /**
     *
     * <建立节点之间的联系>
     * <功能详细描述>
     * @param TreeNodeMap
     * @author soul390
     */
    public void putChildIntoParent(HashMap<Integer, TreeNode> TreeNodeMap)
    {
        Iterator<TreeNode> iterator = TreeNodeMap.values().iterator();
        while (iterator.hasNext())
        {
            TreeNode TreeNode = iterator.next();
            int parentId = TreeNode.getParentId();
            if(TreeNodeMap.containsKey(parentId))
            {
                // 找到父节点，并加入父节点的子节点列表
                TreeNode parentTreeNode = TreeNodeMap.get(parentId);
                parentTreeNode.addChildNode(TreeNode);
            }
        }
    }
}