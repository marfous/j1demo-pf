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
package javaone.con3638.facescomponentlibrary;

import java.io.IOException;
import javax.faces.application.Resource;
import javax.faces.application.ResourceHandler;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.inject.Inject;

/**
 * This component defines name and namespace explicitly. Be careful you don't
 * need to define it within any *.taglib.xml library but you still need
 * faces-config.xml file inside the META-INF directory to enable JSF component
 * detection.
 *
 * @author Martin Fousek <marfous@netbeans.org>
 */
@FacesComponent(createTag = true,
        tagName = "clockFromJAR",
        namespace = "http://xmlns.jcp.org/jsf/remoteLibrary")
public class ExternalClockComponent extends UIComponentBase {

    // Since JSF 2.2, we are able to use CDI within the component definition
    @Inject
    HtmlContentBuider contentBuilder;

    @Override
    public String getFamily() {
        return "javaone.con3638.facescomponentlibrary";
    }

    @Override
    public void encodeBegin(FacesContext context) throws IOException {
        contentBuilder.renderJavaScriptTag(context, getResourcePath(context, "js", "jquery.js"));
        contentBuilder.renderJavaScriptTag(context, getResourcePath(context, "js", "clock.js"));
        
        contentBuilder.renderStylesheetTag(context, getResourcePath(context, "css", "styles.css"));

        renderClockComponent(context);
    }

    private static void renderClockComponent(FacesContext context) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        writer.append('\n');
        writer.startElement("div", null);
        writer.writeAttribute("class", "clock", null);
            writer.startElement("div", null);
            writer.writeAttribute("class", "date", null);
            writer.endElement("div");
            writer.startElement("ul", null);
                writer.startElement("li", null);
                writer.writeAttribute("class", "hours", null);
                writer.endElement("li");
                writer.startElement("li", null);
                writer.writeAttribute("class", "point", null);
                writer.writeText(":", null);
                writer.endElement("li");
                writer.startElement("li", null);
                writer.writeAttribute("class", "min", null);
                writer.endElement("li");
                writer.startElement("li", null);
                writer.writeAttribute("class", "point", null);
                writer.writeText(":", null);
                writer.endElement("li");
                writer.startElement("li", null);
                writer.writeAttribute("class", "sec", null);
                writer.endElement("li");
            writer.endElement("ul");
        writer.endElement("div");
        writer.append('\n');
    }

    private static String getResourcePath(FacesContext context, String libraryName, String resourceName) {
        ResourceHandler handler = context.getApplication().getResourceHandler();
        Resource resource = handler.createResource(resourceName, libraryName);
        return (resource != null) ? resource.getRequestPath() : "";
    }

}
