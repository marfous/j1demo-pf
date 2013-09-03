/*
 * Copyright (C) 2013 Martin Fousek & Mert Caliskan
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package javaone.con3638.primetime;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.TreeDragDropEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author mertcaliskan
 */
@Named(value = "treeBean")
@SessionScoped
public class TreeBean implements Serializable {
    
    private TreeNode root1;  
    private TreeNode root2;  

    public TreeBean() {
        root1 = new DefaultTreeNode("Root1", null);  
        TreeNode node0 = new DefaultTreeNode("Node 0", root1);  
        TreeNode node1 = new DefaultTreeNode("Node 1", root1);  
        TreeNode node2 = new DefaultTreeNode("Node 2", root1);  
          
        TreeNode node00 = new DefaultTreeNode("Node 0.0", node0);  
        TreeNode node01 = new DefaultTreeNode("Node 0.1", node0);  
          
        TreeNode node10 = new DefaultTreeNode("Node 1.0", node1);  
        TreeNode node11 = new DefaultTreeNode("Node 1.1", node1);  
          
        TreeNode node000 = new DefaultTreeNode("Node 0.0.0", node00);  
        TreeNode node001 = new DefaultTreeNode("Node 0.0.1", node00);  
        TreeNode node010 = new DefaultTreeNode("Node 0.1.0", node01);  
          
        TreeNode node100 = new DefaultTreeNode("Node 1.0.0", node10);  
          
        root2 = new DefaultTreeNode("Root2", null);  
        TreeNode item0 = new DefaultTreeNode("Item 0", root2);  
        TreeNode item1 = new DefaultTreeNode("Item 1", root2);  
        TreeNode item2 = new DefaultTreeNode("Item 2", root2);  
          
        TreeNode item00 = new DefaultTreeNode("Item 0.0", item0);  
    }

    public TreeNode getRoot1() {
        return root1;
    }

    public void setRoot1(TreeNode root1) {
        this.root1 = root1;
    }

    public TreeNode getRoot2() {
        return root2;
    }

    public void setRoot2(TreeNode root2) {
        this.root2 = root2;
    }
    
    public void onDragDrop(TreeDragDropEvent event) {  
        TreeNode dragNode = event.getDragNode();  
        TreeNode dropNode = event.getDropNode();  
        int dropIndex = event.getDropIndex();  
          
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dragged " + dragNode.getData(), "Dropped on " + dropNode.getData());  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }  
}