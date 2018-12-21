import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * <多叉树>
 * <功能详细描述>
 *
 * @author  soul390
 * @version
 */
public class TreeNode
{
    /**
     * 父节点的ID
     */
    private int parentId;

    private int selfId;

    protected String nodeName;

    protected Object object;

    protected TreeNode parentNode;

    /**
     * 孩子节点列表
     */
    protected List<TreeNode> childList;

    public String getNodeName()
    {
        return nodeName;
    }

    public void setNodeName(String nodeName)
    {
        this.nodeName = nodeName;
    }

    public List<TreeNode> getChildList()
    {
        return childList;
    }

    public void setChildList(List<TreeNode> childList)
    {
        this.childList = childList;
    }

    public int getParentId()
    {
        return parentId;
    }

    public void setParentId(int parentId)
    {
        this.parentId = parentId;
    }

    public int getSelfId()
    {
        return selfId;
    }

    public void setSelfId(int selfId)
    {
        this.selfId = selfId;
    }


    public TreeNode(int parentId, int selfId, String nodeName)
    {
        this.parentId = parentId;
        this.selfId = selfId;
        this.nodeName = nodeName;
    }

    public void initChildList()
    {
        if(null == childList)
        {
            childList = new ArrayList<>();
        }
    }

    public void addChildNode(TreeNode treeNode)
    {
        initChildList();
        childList.add(treeNode);
    }

    /**
     * <插入节点>
     * <功能详细描述>
     * @param treeNode
     * @return
     * @author soul390
     */
    public boolean insertJuniorNode(TreeNode treeNode)
    {
        int parentId = treeNode.getParentId();
        if(this.selfId == parentId)
        {
            addChildNode(treeNode);
            return true;
        }
        else
        {
            if(childList == null || childList.isEmpty())
            {
                return false;
            }
            for(TreeNode node:childList)
            {
                boolean f = node.insertJuniorNode(treeNode);
                if(f)
                {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * <深度优先遍历>
     * <功能详细描述>
     * @author soul390
     */
    public void depthTraverse()
    {
        System.out.println(nodeName);
        if(null == childList || childList.isEmpty())
        {
            return;
        }

        for(TreeNode node:childList)
        {
            node.depthTraverse();
        }
    }

    /**
     * <广度优先遍历>
     * <功能详细描述>
     * @author soul390
     */
    public void breadthTraverse()
    {
        // 使用队列暂存节点
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(this);

        while(!linkedList.isEmpty())
        {
            TreeNode node = linkedList.pop();
            System.out.println(node.getNodeName());
            if(node.getChildList() == null || node.getChildList().isEmpty())
            {
                continue;
            }
            for(TreeNode treeNode:node.getChildList())
            {
                linkedList.add(treeNode);
            }
        }
    }

}