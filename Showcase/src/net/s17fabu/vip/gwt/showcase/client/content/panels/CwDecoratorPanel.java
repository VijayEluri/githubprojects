/*
 * Copyright 2008 Google Inc.
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
package net.s17fabu.vip.gwt.showcase.client.content.panels;

import net.s17fabu.vip.gwt.showcase.client.ContentWidget;

import com.google.gwt.i18n.client.Constants;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;

/**
 * Example file.
 */
public class CwDecoratorPanel extends ContentWidget {
  /**
   * The constants used in this Content Widget.
   */
  public static interface CwConstants extends Constants,
      ContentWidget.CwConstants {
    @DefaultStringValue("Add rounded corners to any Widget using the Decorator Panel")
    String cwDecoratorPanelDescription();

    @DefaultStringValue("Description:")
    String cwDecoratorPanelFormDescription();

    @DefaultStringValue("Name:")
    String cwDecoratorPanelFormName();

    @DefaultStringValue("Enter Search Criteria")
    String cwDecoratorPanelFormTitle();

    @DefaultStringValue("Decorator Panel")
    String cwDecoratorPanelName();
  }

  /**
   * An instance of the constants.
   */
  private CwConstants constants;

  /**
   * Constructor.
   * 
   * @param constants the constants
   */
  public CwDecoratorPanel(CwConstants constants) {
    super(constants);
    this.constants = constants;
  }

  @Override
  public String getDescription() {
    return constants.cwDecoratorPanelDescription();
  }

  @Override
  public String getName() {
    return constants.cwDecoratorPanelName();
  }

  /**
   * Initialize this example.
   */
  @Override
  public Widget onInitialize() {
    // Create a table to layout the form options
    FlexTable layout = new FlexTable();
    layout.setCellSpacing(6);
    FlexCellFormatter cellFormatter = layout.getFlexCellFormatter();

    // Add a title to the form
    layout.setHTML(0, 0, constants.cwDecoratorPanelFormTitle());
    cellFormatter.setColSpan(0, 0, 2);
    cellFormatter.setHorizontalAlignment(0, 0,
        HasHorizontalAlignment.ALIGN_CENTER);

    // Add some standard form options
    layout.setHTML(1, 0, constants.cwDecoratorPanelFormName());
    layout.setWidget(1, 1, new TextBox());
    layout.setHTML(2, 0, constants.cwDecoratorPanelFormDescription());
    layout.setWidget(2, 1, new TextBox());

    // Wrap the content in a DecoratorPanel
    DecoratorPanel decPanel = new DecoratorPanel();
    decPanel.setWidget(layout);
    return decPanel;
  }
}
