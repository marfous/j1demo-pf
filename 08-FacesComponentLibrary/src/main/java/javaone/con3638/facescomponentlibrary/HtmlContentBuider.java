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
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.inject.Named;

/**
 * Utility class which can render <script>, <style> tags into the writer.
 *
 * @author Martin Fousek <marfous@netbeans.org>
 */
@Named
@Dependent
public class HtmlContentBuider {

    public void renderStylesheetTag(FacesContext context, String src) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        writer.append('\n');
        writer.startElement("link", null);
        writer.writeAttribute("type", "text/css", null);
        writer.writeAttribute("rel", "stylesheet", null);
        writer.writeAttribute("href", src, null);
        writer.endElement("link");
        writer.append('\n');
    }

    public void renderJavaScriptTag(FacesContext context, String src) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        writer.append('\n');
        writer.startElement("script", null);
        writer.writeAttribute("type", "text/javascript", null);
        writer.writeAttribute("src", src, null);
        writer.endElement("script");
        writer.append('\n');
    }

}
