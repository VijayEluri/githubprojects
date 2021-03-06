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
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;

/**
 * Example file.
 */
public class CwDisclosurePanel extends ContentWidget {
  /**
   * The constants used in this Content Widget.
   */
  public static interface CwConstants extends Constants,
      ContentWidget.CwConstants {
    String cwDisclosurePanelDescription();

    String cwDisclosurePanelFormAdvancedCriteria();

    String cwDisclosurePanelFormDescription();

    String cwDisclosurePanelFormGender();

    String[] cwDisclosurePanelFormGenderOptions();

    String cwDisclosurePanelFormLocation();

    String cwDisclosurePanelFormName();

    String cwDisclosurePanelFormTitle();

    String cwDisclosurePanelName();
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
  public CwDisclosurePanel(CwConstants constants) {
    super(constants);
    this.constants = constants;
  }

  @Override
  public String getDescription() {
    return constants.cwDisclosurePanelDescription();
  }

  @Override
  public String getName() {
    return constants.cwDisclosurePanelName();
  }

  /**
   * Initialize this example.
   */
  @Override
  public Widget onInitialize() {
    // Add the disclosure panels to a panel
    VerticalPanel vPanel = new VerticalPanel();
    vPanel.setSpacing(8);
    vPanel.add(createAdvancedForm());

    // Return the panel
    return vPanel;
  }

  /**
   * Create a form that contains undisclosed advanced options.
   */
  private Widget createAdvancedForm() {
    // Create a table to layout the form options
    FlexTable layout = new FlexTable();
    layout.setCellSpacing(6);
    layout.setWidth("300px");
    FlexCellFormatter cellFormatter = layout.getFlexCellFormatter();

    // Add a title to the form
    layout.setHTML(0, 0, constants.cwDisclosurePanelFormTitle());
    cellFormatter.setColSpan(0, 0, 2);
    cellFormatter.setHorizontalAlignment(0, 0,
        HasHorizontalAlignment.ALIGN_CENTER);

    // Add some standard form options
    layout.setHTML(1, 0, constants.cwDisclosurePanelFormName());
    layout.setWidget(1, 1, new TextBox());
    layout.setHTML(2, 0, constants.cwDisclosurePanelFormDescription());
    layout.setWidget(2, 1, new TextBox());

    // Create some advanced options
    HorizontalPanel genderPanel = new HorizontalPanel();
    String[] genderOptions = constants.cwDisclosurePanelFormGenderOptions();
    for (int i = 0; i < genderOptions.length; i++) {
      genderPanel.add(new RadioButton("gender", genderOptions[i]));
    }
    Grid advancedOptions = new Grid(2, 2);
    advancedOptions.setCellSpacing(6);
    advancedOptions.setHTML(0, 0, constants.cwDisclosurePanelFormLocation());
    advancedOptions.setWidget(0, 1, new TextBox());
    advancedOptions.setHTML(1, 0, constants.cwDisclosurePanelFormGender());
    advancedOptions.setWidget(1, 1, genderPanel);

    // Add advanced options to form in a disclosure panel
    DisclosurePanel advancedDisclosure = new DisclosurePanel(
        constants.cwDisclosurePanelFormAdvancedCriteria());
    advancedDisclosure.setAnimationEnabled(true);
    advancedDisclosure.ensureDebugId("cwDisclosurePanel");
    advancedDisclosure.setContent(advancedOptions);
    layout.setWidget(3, 0, advancedDisclosure);
    cellFormatter.setColSpan(3, 0, 2);

    // Wrap the contents in a DecoratorPanel
    DecoratorPanel decPanel = new DecoratorPanel();
    decPanel.setWidget(layout);
    return decPanel;
  }
}
