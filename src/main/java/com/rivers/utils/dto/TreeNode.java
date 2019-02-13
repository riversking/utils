package com.rivers.utils.dto;

import java.util.List;

/**
 * @author riversking
 */
public class TreeNode {
	protected int id;
	protected int parentId;
	protected List<TreeNode> children = null;

	public void add(TreeNode node) {
		children.add(node);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}
}