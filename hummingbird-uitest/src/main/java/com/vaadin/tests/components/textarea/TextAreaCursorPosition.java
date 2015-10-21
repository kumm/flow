package com.vaadin.tests.components.textarea;

import com.vaadin.tests.components.TestBase;
import com.vaadin.ui.AbstractField;
import com.vaadin.ui.AbstractTextField;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

public class TextAreaCursorPosition extends TestBase {

    private TextField cursorPosition = new TextField("Cursor position");

    @Override
    public void setup() {
        Label label = new Label(
                "Test of calculation of cursor position of TextArea");
        TextArea textArea = new TextArea();
        addListener(textArea);
        add(label);
        add(textArea);
        add(cursorPosition);
        cursorPosition.setValue("?");
        add(new Button("Force position update"));
    }

    public void addListener(AbstractField newField) {
        AbstractTextField newTextField = (AbstractTextField) newField;
        // newTextField.setTextChangeEventMode(TextChangeEventMode.EAGER);
        //
        // newTextField.addTextChangeListener(new TextChangeListener() {
        // @Override
        // public void textChange(TextChangeEvent event) {
        // AbstractTextField component = (AbstractTextField) event
        // .getComponent();
        // cursorPosition.setValue(
        // String.valueOf(component.getCursorPosition()));
        // }
        // });
    }

    @Override
    protected String getTestDescription() {
        return "Writing something in the field updates the cursor position field. The position field can also be updated using the button.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 7726;
    }

}