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
package javaone.con3638.expressionlanguage3;

import javax.el.ELProcessor;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author marfous
 */
@Named
@RequestScoped
public class ElProcessorBean {

    private static final ELProcessor EL_PROCESSOR = new ELProcessor();

    private static final String HELLO_WORLD = "'Hello' += 'World' += '!'";
    private static final String MATH_OPERATION = "5 * 8 % 6";
    private static final String MORE_EVALUATIONS = "a = 50; b = 51; a + b";
//    private static final String HELLO_WORLD = "";
//    private static final String HELLO_WORLD = "";

    public String getStringKey() {
        return HELLO_WORLD;
    }

    public Object getStringValue() {
        return EL_PROCESSOR.eval(HELLO_WORLD);
    }

    public String getMathExpressionKey() {
        return MATH_OPERATION;
    }

    public Object getMathExpressionValue() {
        return EL_PROCESSOR.eval(MATH_OPERATION);
    }

    public String getMoreEvaluationsKey() {
        return MORE_EVALUATIONS;
    }

    public Object getMoreEvaluationsValue() {
        return EL_PROCESSOR.eval(MORE_EVALUATIONS);
    }

}
