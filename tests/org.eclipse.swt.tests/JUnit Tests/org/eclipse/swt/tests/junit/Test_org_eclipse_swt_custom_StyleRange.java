/*******************************************************************************
 * Copyright (c) 2000, 2015 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Red Hat Inc. - Bug 462631
 *******************************************************************************/
package org.eclipse.swt.tests.junit;


import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Automated Test Suite for class org.eclipse.swt.custom.StyleRange
 *
 * @see org.eclipse.swt.custom.StyleRange
 */
public class Test_org_eclipse_swt_custom_StyleRange {
	final static RGB RED = new RGB(255,0,0);
	final static RGB BLUE = new RGB(0,0,255);
	final static RGB GREEN = new RGB(0,255,0);
	Map<RGB, Color> colors = new HashMap<>();
private Color getColor(RGB rgb) {
	return colors.get(rgb);
}
protected void initializeColors() {
	Display display = Display.getDefault();
	colors.put(RED, new Color (display, RED));
	colors.put(GREEN, new Color (display, GREEN));
	colors.put(BLUE, new Color (display, BLUE));
}

@Before
public void setUp() {
	initializeColors();
}

@After
public void tearDown() {
	Iterator<RGB> elements = colors.keySet().iterator();
	while (elements.hasNext()) {
		Color color = colors.get(elements.next());
		color.dispose();
	}
}

@Test
public void test_Constructor() {
	StyleRange styleRange = new StyleRange();
	assertTrue(":a:", styleRange.start == 0);
	assertTrue(":a:", styleRange.length == 0);
	assertTrue(":a:", styleRange.foreground == null);
	assertTrue(":a:", styleRange.background == null);
	assertTrue(":a:", styleRange.fontStyle == SWT.NORMAL);
}

@Test
public void test_ConstructorIILorg_eclipse_swt_graphics_ColorLorg_eclipse_swt_graphics_Color() {
	StyleRange styleRange = new StyleRange(5, 10, getColor(RED), getColor(BLUE));
	assertTrue(":b:", styleRange.start == 5);
	assertTrue(":b:", styleRange.length == 10);
	assertTrue(":b:", styleRange.foreground == getColor(RED));
	assertTrue(":b:", styleRange.background == getColor(BLUE));
	assertTrue(":b:", styleRange.fontStyle == SWT.NORMAL);
}

@Test
public void test_ConstructorIILorg_eclipse_swt_graphics_ColorLorg_eclipse_swt_graphics_ColorI() {
	StyleRange styleRange = new StyleRange(5, 10, getColor(RED), getColor(BLUE), SWT.BOLD);
	assertTrue(":c:", styleRange.start == 5);
	assertTrue(":c:", styleRange.length == 10);
	assertTrue(":c:", styleRange.foreground == getColor(RED));
	assertTrue(":c:", styleRange.background == getColor(BLUE));
	assertTrue(":c:", styleRange.fontStyle == SWT.BOLD);
}

@Test
public void test_clone() {
	StyleRange styleRangeA = new StyleRange(6, 10, null, getColor(BLUE), SWT.NORMAL);
	StyleRange styleRangeB = (StyleRange)styleRangeA.clone();
	assertTrue(":g:", styleRangeA.equals(styleRangeB));
}

@Test
public void test_equalsLjava_lang_Object() {
	StyleRange styleRangeA = new StyleRange(5, 10, getColor(RED), getColor(BLUE), SWT.BOLD);
	StyleRange styleRangeB = new StyleRange(5, 10, getColor(RED), getColor(BLUE), SWT.BOLD);
	StyleRange styleRangeC = new StyleRange(5, 10, getColor(BLUE), getColor(BLUE), SWT.BOLD);
	StyleRange styleRangeD = new StyleRange(6, 10, getColor(RED), getColor(BLUE), SWT.BOLD);
	StyleRange styleRangeE = new StyleRange(5, 11, getColor(RED), getColor(BLUE), SWT.BOLD);
	StyleRange styleRangeF = new StyleRange(5, 11, getColor(RED), getColor(RED), SWT.BOLD);
	StyleRange styleRangeG = new StyleRange(5, 11, getColor(RED), getColor(BLUE), SWT.NORMAL);
	assertTrue(":d:", styleRangeA.equals(styleRangeB));
	assertTrue(":d:",!styleRangeA.equals(styleRangeC));
	assertTrue(":d:",!styleRangeA.equals(styleRangeD));
	assertTrue(":d:",!styleRangeA.equals(styleRangeE));
	assertTrue(":d:",!styleRangeA.equals(styleRangeF));
	assertTrue(":d:",!styleRangeA.equals(styleRangeG));
}

@Test
public void test_hashCode() {
	Set<StyleRange> set = new HashSet<>();
	Color testColor = new Color(Display.getDefault(), 0, 0, 0);
	
	//regression test for bug 30924
	set.add(new StyleRange());
	set.add(new StyleRange(0, 1, testColor, null));
	set.add(new StyleRange(0, 1, testColor, testColor));
	set.add(new StyleRange(0, 1, testColor, testColor, SWT.BOLD));
	testColor.dispose();
}

@Test
public void test_isUnstyled() {
	StyleRange styleRangeA = new StyleRange(5, 10, null, null, SWT.NORMAL);
	StyleRange styleRangeB = new StyleRange(5, 10, getColor(RED), null, SWT.NORMAL);
	StyleRange styleRangeC = new StyleRange(5, 10, null, null, SWT.BOLD);
	StyleRange styleRangeD = new StyleRange(6, 10, null, getColor(BLUE), SWT.NORMAL);
	StyleRange styleRangeE = new StyleRange(5, 10, null, null);
	assertTrue(":e:", styleRangeA.isUnstyled());
	assertTrue(":e:",!styleRangeB.isUnstyled());
	assertTrue(":e:",!styleRangeC.isUnstyled());
	assertTrue(":e:",!styleRangeD.isUnstyled());
	assertTrue(":e:", styleRangeE.isUnstyled());
}

@Test
public void test_similarToLorg_eclipse_swt_custom_StyleRange() {
	StyleRange styleRangeA = new StyleRange(6, 10, getColor(RED), getColor(BLUE), SWT.NORMAL);
	StyleRange styleRangeB = new StyleRange(5, 5, getColor(RED), getColor(BLUE), SWT.NORMAL);
	StyleRange styleRangeC = new StyleRange(6, 10, getColor(RED), getColor(BLUE), SWT.NORMAL);
	StyleRange styleRangeD = new StyleRange(6, 10, getColor(BLUE), getColor(BLUE), SWT.NORMAL);
	StyleRange styleRangeE = new StyleRange(6, 10, getColor(RED), getColor(RED), SWT.NORMAL);
	StyleRange styleRangeF = new StyleRange(6, 10, getColor(RED), getColor(BLUE), SWT.BOLD);
	assertTrue(":f:", styleRangeA.similarTo(styleRangeB));
	assertTrue(":f:", styleRangeA.similarTo(styleRangeC));
	assertTrue(":f:", !styleRangeA.similarTo(styleRangeD));
	assertTrue(":f:", !styleRangeA.similarTo(styleRangeE));
	assertTrue(":f:", !styleRangeA.similarTo(styleRangeF));
}

@Test
public void test_toString() {
	StyleRange styleRange = new StyleRange(6, 10, null, getColor(BLUE), SWT.NORMAL);
	styleRange.toString();
}
}
