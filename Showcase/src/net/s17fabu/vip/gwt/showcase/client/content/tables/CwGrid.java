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
package net.s17fabu.vip.gwt.showcase.client.content.tables;

import net.s17fabu.vip.gwt.showcase.client.ContentWidget;
import net.s17fabu.vip.gwt.showcase.client.Showcase;

import com.google.gwt.i18n.client.Constants;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Widget;

/**
 * Example file.
 */
public class CwGrid extends ContentWidget {
  /**
   * The constants used in this Content Widget.
   */
  public static interface CwConstants extends Constants,
      ContentWidget.CwConstants {
    String cwGridDescription();

    String cwGridName();
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
  public CwGrid(CwConstants constants) {
    super(constants);
    this.constants = constants;
  }

  @Override
  public String getDescription() {
    return constants.cwGridDescription();
  }

  @Override
  public String getName() {
    return constants.cwGridName();
  }

  @Override
  public boolean hasStyle() {
    return false;
  }

  /**
   * Initialize this example.
   */
  @Override
  public Widget onInitialize() {
    // Create a grid
    Grid grid = new Grid(4, 4);

    // Add images to the grid
    int numRows = grid.getRowCount();
    int numColumns = grid.getColumnCount();
    for (int row = 0; row < numRows; row++) {
      for (int col = 0; col < numColumns; col++) {
        grid.setWidget(row, col, Showcase.images.gwtLogo().createImage());
      }
    }

    // Return the panel
    grid.ensureDebugId("cwGrid");
    return grid;
  }
}
