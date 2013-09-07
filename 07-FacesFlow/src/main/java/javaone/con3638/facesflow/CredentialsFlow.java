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
package javaone.con3638.facesflow;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;
import javax.inject.Named;

/**
 * Defines the CredentialsFlow flow. It specifies the start node, view nodes and
 * related actions, flow call, return node, finalizer and more.
 *
 * @author Martin Fousek <marfous@netbeans.org>
 */
@Named
@Dependent
public class CredentialsFlow {

    private static final long serialVersionUID = 1;

    /** ID of the flow. */
    public static final String ID = "credentialsFlow";

    // Defines that this method produces definition of the flow.
    @Produces @FlowDefinition
    // @FlowBuilderParameter causes that FlowBuilder will be passed to this method
    public Flow defineFlow(@FlowBuilderParameter FlowBuilder flowBuilder) {
        flowBuilder.id("", ID);

        // return node from the flow
        flowBuilder.returnNode("index").fromOutcome("/index");

        // 1. page - start node
        flowBuilder.viewNode(ID, "/" + ID + "/first.xhtml").markAsStartNode();

        // 2. page - explicitly named
        flowBuilder.viewNode("address", "/" + ID + "/second.xhtml");

        // 3. page - we can use also implicit navigation/naming if the action is
        //   called as the view node
//         flowBuilder.viewNode("third", "/" + ID + "/third.xhtml");

        // switch flow to the avatarChooser one
        flowBuilder.flowCallNode("chooseAvatar")
                // which flow to call
                .flowReference("", "avatarChooser")
                // outgoing parameters - name of the user
                .outboundParameter("firstName", "#{personBean.firstName}")
                .outboundParameter("secondName", "#{personBean.secondName}");

        // store data by leaving the flow - can be restored then
        flowBuilder.finalizer("#{storageBean.storeData()}");

        // restore data by calling "restore" action
        flowBuilder.methodCallNode("restore")
                // method to call
                .expression("#{storageBean.restoreData()}")
                // where to go then
                .defaultOutcome(ID);

        // saved information about avatar set to the personBean
        flowBuilder.inboundParameter("avatar", "#{personBean.avatar}");

        return flowBuilder.getFlow();
    }

    public String getId() {
        return ID;
    }

}
