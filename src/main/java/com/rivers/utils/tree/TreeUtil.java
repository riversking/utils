package com.rivers.utils.tree;

import com.google.common.collect.Lists;
import com.rivers.utils.dto.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author riversking
 */
public class TreeUtil {
    /**
     * 两层循环实现建树
     */
    public static <T extends TreeNode> List<T> bulid(List<T> treeNodes, Object root) {

        List<T> trees = new ArrayList<>();

        for (T treeNode : treeNodes) {

            if (root.equals(treeNode.getParentId())) {
                trees.add(treeNode);
            }

            for (T it : treeNodes) {
                if (it.getParentId() == treeNode.getId()) {
                    if (treeNode.getChildren() == null) {
                        treeNode.setChildren(new ArrayList<TreeNode>());
                    }
                    treeNode.add(it);
                }
            }
        }
        return trees;
    }

    /**
     * 使用递归方法建树
     *
     * @param treeNodes treeNodes
     * @return
     */
    public static <T extends TreeNode> List<T> buildByRecursive(List<T> treeNodes, Object root) {
        List<T> trees = new ArrayList<>();
        for (T treeNode : treeNodes) {
            if (root.equals(treeNode.getParentId())) {
                trees.add(findChildren(treeNode, treeNodes));
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点
     *
     * @param treeNodes treeNodes
     * @return
     */
    public static <T extends TreeNode> T findChildren(T treeNode, List<T> treeNodes) {
        for (T it : treeNodes) {
            if (treeNode.getId() == it.getParentId()) {
                if (treeNode.getChildren() == null) {
                    treeNode.setChildren(new ArrayList<TreeNode>());
                }
                treeNode.add(findChildren(it, treeNodes));
            }
        }
        return treeNode;
    }

    /**
     * java8 实现树
     */
    public static <T extends TreeNode> void buildTree(List<T> treeNodes, List<T> roots) {
        roots.forEach(root -> {
            List<T> children = treeNodes
                    .stream()
                    .filter(i -> root.getId() == i.getParentId())
                    .collect(Collectors.toList());
            if (root.getChildren() == null || children.isEmpty()) {
                root.setChildren(Lists.newArrayList(children));
            } else {
                root.getChildren().addAll(children);
            }
            buildTree(treeNodes, children);
        });
    }

}
