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

import com.vaadin.flow.router.internal.BeforePreserveHandler;

/**
 * A listener that may be added to the {@link com.vaadin.flow.component.UI}
 * using
 * {@link com.vaadin.flow.component.UI#addBeforePreserveListener(BeforePreserveListener)}.
 * <p>
 * All listeners added this way will be informed when a set of components
 * are going to be preserved, and moved to a new {@link com.vaadin.flow.component.UI}.
 * <p>
 *
 * All BeforePreserveListeners will be executed before the BeforePreserveObservers.
 */
@FunctionalInterface
public interface BeforePreserveListener extends BeforePreserveHandler {
}
