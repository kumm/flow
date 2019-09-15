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
package com.vaadin.flow.router.internal;

import java.io.Serializable;

import com.vaadin.flow.router.BeforePreserveEvent;

/**
 * The base interface for every {@link BeforePreserveEvent} handler.
 */
@FunctionalInterface
public interface BeforePreserveHandler extends Serializable {

    /**
     * Callback executed before preservation of a Component chain is made.
     *
     * @param event
     *            before preserve event with event details
     */
    void beforePreserve(BeforePreserveEvent event);
}