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
import net.s17fabu.vip.gwt.showcase.client.Showcase;

import com.google.gwt.i18n.client.Constants;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Example file.
 */
public class CwTabPanel extends ContentWidget {
  /**
   * The constants used in this Content Widget.
   */
  public static interface CwConstants extends Constants,
      ContentWidget.CwConstants {
    String cwTabPanelDescription();

    String cwTabPanelName();

    String cwTabPanelTab0();

    String cwTabPanelTab2();

    String[] cwTabPanelTabs();
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
  public CwTabPanel(CwConstants constants) {
    super(constants);
    this.constants = constants;
  }

  @Override
  public String getDescription() {
    return constants.cwTabPanelDescription();
  }

  @Override
  public String getName() {
    return constants.cwTabPanelName();
  }

  /**
   * Initialize this example.
   */
  @Override
  public Widget onInitialize() {
    // Create a tab panel
    DecoratedTabPanel tabPanel = new DecoratedTabPanel();
    tabPanel.setWidth("400px");
    tabPanel.setAnimationEnabled(true);

    // Add a home tab
    String[] tabTitles = constants.cwTabPanelTabs();
    HTML homeText = new HTML(constants.cwTabPanelTab0());
    tabPanel.add(homeText, tabTitles[0]);

    // Add a tab with an image
    VerticalPanel vPanel = new VerticalPanel();
    vPanel.add(Showcase.images.gwtLogo().createImage());
    tabPanel.add(vPanel, tabTitles[1]);

    // Add a tab
    HTML moreInfo = new HTML(constants.cwTabPanelTab2());
    tabPanel.add(moreInfo, tabTitles[2]);

    // Return the content
    tabPanel.selectTab(0);
    tabPanel.ensureDebugId("cwTabPanel");
    return tabPanel;
  }
}
