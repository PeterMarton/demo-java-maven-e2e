package org.reference.util;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.conditions.Visible;
import com.codeborne.selenide.conditions.And;

public class Conditions {

	public static Condition CLICKABLE = And.and("can be clicked", Visible.visible, Visible.enabled);

}
