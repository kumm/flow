/*
 * Copyright 2000-2017 Vaadin Ltd.
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
package com.vaadin.flow.demo.views;

import com.vaadin.annotations.HtmlImport;
import com.vaadin.components.paper.button.PaperButton;
import com.vaadin.components.paper.dialog.PaperDialog;
import com.vaadin.flow.demo.ComponentDemo;
import com.vaadin.flow.html.Div;
import com.vaadin.flow.html.H2;
import com.vaadin.flow.html.HtmlComponent;

/**
 * View for {@link PaperDialog} demo.
 */
@ComponentDemo(name = "Paper Dialog", href = "paper-dialog")
@HtmlImport("frontend://bower_components/neon-animation/neon-animations.html")
@HtmlImport("frontend://bower_components/neon-animation/web-animations.html")
public class PaperDialogView extends DemoView {

    private Div message;

    @Override
    void initView() {
        createPlainDialog();
        createModalDialog();
        createNestedDialogs();
        createDialogWithActions();
        createAnimatedDialog();

        message = new Div();
        message.setId("dialogsMessage");
        add(message);
    }

    private void createPlainDialog() {
        // begin-source-example
        // source-example-heading: Plain dialog
        PaperDialog dialog = createDialog("Plain dialog",
                "Plain dialog with plain text. Click anywhere on the page to close.");

        PaperButton open = new PaperButton("Plain dialog");
        open.setRaised(true);
        open.addClickListener(evt -> addAndOpen(dialog));
        // end-source-example
        add(open);
    }

    private void createModalDialog() {
        // begin-source-example
        // source-example-heading: Modal dialog
        PaperDialog dialog = createDialog("Modal dialog",
                "Modal dialog with plain text.");
        dialog.setModal(true);

        PaperButton close = new PaperButton("Close dialog");
        close.addClickListener(evt -> dialog.close());
        dialog.add(createDivForButton(close));

        PaperButton open = new PaperButton("Modal dialog");
        open.setRaised(true);
        open.addClickListener(evt -> addAndOpen(dialog));
        // end-source-example
        add(open);
    }

    private void createNestedDialogs() {
        // begin-source-example
        // source-example-heading: Nested dialogs
        PaperDialog dialog = createDialog("Nested dialogs",
                "Click on the button to open the nested dialog. Click anywhere on the page to close.");

        PaperDialog second = createDialog("Second dialog",
                "This is the second dialog. Click anywhere on the page to close.");
        second.setId("second-dialog");

        PaperButton openSecond = new PaperButton("Open second dialog");
        openSecond.addClickListener(evt -> addAndOpen(second));
        dialog.add(createDivForButton(openSecond));

        PaperButton open = new PaperButton("Nested dialogs");
        open.setRaised(true);
        open.addClickListener(evt -> addAndOpen(dialog));
        // end-source-example
        add(open);
    }

    private void createDialogWithActions() {
        // begin-source-example
        // source-example-heading: Dialog with actions
        PaperDialog dialog = createDialog("Dialog with actions",
                "A dialog can have any number of actions. Click anywhere on the page to close.");

        PaperButton dummyAction = new PaperButton("Do nothing");

        PaperButton decline = new PaperButton("Decline");
        decline.getElement().setAttribute("dialog-dismiss", true);

        PaperButton accept = new PaperButton("Accept");
        accept.getElement().setAttribute("dialog-confirm", true);
        accept.getElement().setAttribute("autofocus", true);

        dialog.add(createDivForButton(dummyAction, decline, accept));

        PaperButton open = new PaperButton("Dialog with actions");
        open.setRaised(true);
        open.addClickListener(evt -> addAndOpen(dialog));
        // end-source-example
        add(open);
    }

    private void createAnimatedDialog() {
        // begin-source-example
        // source-example-heading: Animated dialog
        PaperDialog dialog = createDialog("Animated dialog",
                "Isn't it cool? Click anywhere on the page to close.");

        dialog.setEntryAnimation("scale-up-animation");
        dialog.setExitAnimation("scale-down-animation");
        dialog.setWithBackdrop(true);

        PaperButton open = new PaperButton("Animated dialog");
        open.setRaised(true);
        open.addClickListener(evt -> addAndOpen(dialog));
        // end-source-example
        add(open);
    }

    // begin-source-example
    // source-example-heading: Helper methods
    private PaperDialog createDialog(String title, String text) {
        PaperDialog dialog = new PaperDialog();
        dialog.add(new H2(title));
        HtmlComponent p = new HtmlComponent("p");
        p.getElement().setText(text);
        dialog.add(p);
        dialog.addOpenedChangedListener(evt -> message
                .setText(dialog.isOpened() ? (title + " was opened")
                        : (title + " was closed")));
        return dialog;
    }

    private Div createDivForButton(PaperButton... buttons) {
        Div div = new Div(buttons);
        div.setClassName("buttons");
        return div;
    }

    private void addAndOpen(PaperDialog dialog) {
        if (dialog.getElement().getParent() == null) {
            getUI().ifPresent(ui -> ui.add(dialog));
        }
        dialog.open();
    }
    // end-source-example
}