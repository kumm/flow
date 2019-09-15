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
package com.vaadin.flow.router;

import java.util.Collections;
import java.util.EventObject;
import java.util.List;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.UI;

/**
 * Event created before preserve by @PreserveOnReload
 *
 * @author Vaadin Ltd
 * @since 1.0
 */
public class BeforePreserveEvent extends EventObject {
    private final UI targetUi;
    private UI sourceUi;

    private final List<HasElement> chain;

    /**
     * Construct a new BeforePreserveEvent event
     *
     * @param event
     *            NavigationEvent that is on-going
     * @param chain
     *            a list of router target and parent layout instances,
     *            starting from the innermost part to be preserved
     */
    public BeforePreserveEvent(NavigationEvent event, List<HasElement> chain) {
        super(event.getSource());
        this.chain = Collections.unmodifiableList(chain);
        this.targetUi = event.getUI();
        HasElement root = chain.get(chain.size() - 1);
        root.getElement().getComponent()
                .flatMap(Component::getUI).ifPresent(ui -> sourceUi = ui);
    }

    public UI getTargetUi() {
        return targetUi;
    }

    public List<HasElement> getChain() {
        return chain;
    }

    public UI getSourceUi() {
        return sourceUi;
    }
}
