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
package javaone.con3638.facescomponent;

import java.io.IOException;
import javax.faces.application.Resource;
import javax.faces.application.ResourceHandler;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

/**
 * This component uses default naming and namespace definition. It means that it
 * can be called as "clock" tag (lowercased initial letter) and it's defined in
 * "http://xmlns.jcp.org/jsf/component" namespace.
 *
 * @author marfous
 */
@FacesComponent(createTag = true)
public class Clock extends UIComponentBase {

    private static final String COMPONENT_NAME = "clock";

    @Override
    public String getFamily() {
        return "javaone.con3638.facescomponent";
    }

    @Override
    public void encodeBegin(FacesContext context) throws IOException {
        renderJavaScriptTag(context, getResourcePath(context, "jquery.js"));
        renderJavaScriptTag(context, getResourcePath(context, "clock.js"));
        
        renderStylesheetTag(context, getResourcePath(context, "styles.css"));

        renderClockComponent(context);
    }

    private static void renderStylesheetTag(FacesContext context, String src) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        writer.append('\n');
        writer.startElement("link", null);
        writer.writeAttribute("type", "text/css", null);
        writer.writeAttribute("rel", "stylesheet", null);
        writer.writeAttribute("href", src, null);
        writer.endElement("link");
        writer.append('\n');
    }

    private static void renderJavaScriptTag(FacesContext context, String src) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        writer.append('\n');
        writer.startElement("script", null);
        writer.writeAttribute("type", "text/javascript", null);
        writer.writeAttribute("src", src, null);
        writer.endElement("script");
        writer.append('\n');
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

    private static String getResourcePath(FacesContext context, String resourceName) {
        ResourceHandler handler = context.getApplication().getResourceHandler();
        Resource resource = handler.createResource(resourceName, COMPONENT_NAME);
        return (resource != null) ? resource.getRequestPath() : "";
    }

}
