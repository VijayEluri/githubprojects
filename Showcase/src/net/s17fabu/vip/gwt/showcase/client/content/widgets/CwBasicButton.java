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
package net.s17fabu.vip.gwt.showcase.client.content.widgets;

import net.s17fabu.vip.gwt.showcase.client.ContentWidget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.Constants;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Example file.
 */
public class CwBasicButton extends ContentWidget {
	private final ClickButtonResponseServiceAsync clickButtonResponseService = GWT
			.create(ClickButtonResponseService.class);

	/**
	 * The constants used in this Content Widget.
	 */
	public static interface CwConstants extends Constants,
			ContentWidget.CwConstants {
		String cwBasicButtonClickMessage();

		String cwBasicButtonDescription();

		String cwBasicButtonDisabled();

		String cwBasicButtonName();

		String cwBasicButtonNormal();
	}

	/**
	 * An instance of the constants.
	 */
	private CwConstants constants;

	/**
	 * Constructor.
	 * 
	 * @param constants
	 *            the constants
	 */
	public CwBasicButton(CwConstants constants) {
		super(constants);
		this.constants = constants;
	}

	@Override
	public String getDescription() {
		return constants.cwBasicButtonDescription();
	}

	@Override
	public String getName() {
		return constants.cwBasicButtonName();
	}

	/**
	 * Initialize this example.
	 */
	@Override
	public Widget onInitialize() {
		// Create a panel to align the widgets
		HorizontalPanel hPanel = new HorizontalPanel();
		hPanel.setSpacing(10);

		// Add a normal button
		Button normalButton = new Button(constants.cwBasicButtonNormal(),
				new ClickHandler() {
					public void onClick(ClickEvent event) {
						clickButtonResponseService.clickButtonResponse(new AsyncCallback<String>(){

							@Override
							public void onFailure(Throwable caught) {
								Window.alert("Error:"+caught.getMessage());
							}

							@Override
							public void onSuccess(String result) {
								Window.alert(result);
							}
							
						});
					}
				});
		normalButton.ensureDebugId("cwBasicButton-normal");
		hPanel.add(normalButton);

		// Add a disabled button
		Button disabledButton = new Button(constants.cwBasicButtonDisabled());
		disabledButton.ensureDebugId("cwBasicButton-disabled");
		disabledButton.setEnabled(false);
		hPanel.add(disabledButton);

		// Return the panel
		return hPanel;
	}
}
