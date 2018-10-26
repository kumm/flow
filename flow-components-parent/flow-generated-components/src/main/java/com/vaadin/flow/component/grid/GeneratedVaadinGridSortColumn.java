/*
 * Copyright 2000-2018 Vaadin Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.flow.component.grid;

import javax.annotation.Generated;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Synchronize;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.shared.Registration;

/**
 * <p>
 * Description copied from corresponding location in WebComponent:
 * </p>
 * <p>
 * {@code <vaadin-grid-sort-column>} is a helper element for the
 * {@code <vaadin-grid>} that provides default header template and functionality
 * for sorting.
 * </p>
 * <h4>Example:</h4>
 * <p>
 * &lt;vaadin-grid items=&quot;[[items]]&quot;&gt; &lt;vaadin-grid-sort-column
 * path=&quot;name.first&quot;
 * direction=&quot;asc&quot;&gt;&lt;/vaadin-grid-sort-column&gt;
 * </p>
 * <p>
 * &lt;vaadin-grid-column&gt; ...
 * </p>
 */
@Generated({ "Generator: com.vaadin.generator.ComponentGenerator#1.2-SNAPSHOT",
        "WebComponent: Vaadin.GridSortColumnElement#5.2.1",
        "Flow#1.2-SNAPSHOT" })
@Tag("vaadin-grid-sort-column")
@HtmlImport("frontend://bower_components/vaadin-grid/src/vaadin-grid-sort-column.html")
public abstract class GeneratedVaadinGridSortColumn<R extends GeneratedVaadinGridSortColumn<R>>
        extends GeneratedVaadinGridColumn<R> implements HasStyle {

    /**
     * <p>
     * Description copied from corresponding location in WebComponent:
     * </p>
     * <p>
     * JS Path of the property in the item used for sorting the data.
     * <p>
     * This property is not synchronized automatically from the client side, so
     * the returned value may not be the same as in client side.
     * </p>
     * 
     * @return the {@code path} property from the webcomponent
     */
    protected String getPathString() {
        return getElement().getProperty("path");
    }

    /**
     * <p>
     * Description copied from corresponding location in WebComponent:
     * </p>
     * <p>
     * JS Path of the property in the item used for sorting the data.
     * </p>
     * 
     * @param path
     *            the String value to set
     */
    protected void setPath(String path) {
        getElement().setProperty("path", path == null ? "" : path);
    }

    /**
     * <p>
     * Description copied from corresponding location in WebComponent:
     * </p>
     * <p>
     * How to sort the data. Possible values are {@code asc} to use an ascending
     * algorithm, {@code desc} to sort the data in descending direction, or
     * {@code null} for not sorting the data.
     * <p>
     * This property is synchronized automatically from client side when a
     * 'direction-changed' event happens.
     * </p>
     * 
     * @return the {@code direction} property from the webcomponent
     */
    @Synchronize(property = "direction", value = "direction-changed")
    protected String getDirectionString() {
        return getElement().getProperty("direction");
    }

    /**
     * <p>
     * Description copied from corresponding location in WebComponent:
     * </p>
     * <p>
     * How to sort the data. Possible values are {@code asc} to use an ascending
     * algorithm, {@code desc} to sort the data in descending direction, or
     * {@code null} for not sorting the data.
     * </p>
     * 
     * @param direction
     *            the String value to set
     */
    protected void setDirection(String direction) {
        getElement().setProperty("direction",
                direction == null ? "" : direction);
    }

    public static class DirectionChangeEvent<R extends GeneratedVaadinGridSortColumn<R>>
            extends ComponentEvent<R> {
        private final String direction;

        public DirectionChangeEvent(R source, boolean fromClient) {
            super(source, fromClient);
            this.direction = source.getDirectionString();
        }

        public String getDirection() {
            return direction;
        }
    }

    /**
     * Adds a listener for {@code direction-changed} events fired by the
     * webcomponent.
     * 
     * @param listener
     *            the listener
     * @return a {@link Registration} for removing the event listener
     */
    protected Registration addDirectionChangeListener(
            ComponentEventListener<DirectionChangeEvent<R>> listener) {
        return getElement()
                .addPropertyChangeListener("direction",
                        event -> listener.onComponentEvent(
                                new DirectionChangeEvent<R>((R) this,
                                        event.isUserOriginated())));
    }
}