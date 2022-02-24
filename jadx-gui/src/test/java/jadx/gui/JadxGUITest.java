package jadx.gui;

import javax.swing.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: jadx
 * @description:
 * @author: Mr. Su
 * @create: 2022-02-17 14:12
 **/

public class JadxGUITest {
	private static final Logger LOG = LoggerFactory.getLogger(JadxGUITest.class);

	/*
	 * Test class: JadxWrapper, JadxSettings, LogCollector, LafManager, NLS
	 */

	// @Test
	// void testLaunch(){
	// try {
	// LogCollector.register();
	// JadxSettings settings = JadxSettingsAdapter.load();
	// settings.setLogLevel(LogHelper.LogLevelEnum.INFO);
	// // overwrite loaded settings by command line arguments
	// if (!settings.overrideProvided(new String[0])) {
	// return;
	// }
	// //init GUI theme
	//// LafManager.init(settings);
	// NLS.setLocale(settings.getLangLocale());
	//
	// //init wrapper
	// JadxWrapper wrapper = new JadxWrapper(settings);
	// JadxProject jadxProject = new JadxProject();
	// jadxProject.setSettings(settings);
	// wrapper.setProject(jadxProject);
	//
	// //test open dex file and init wrapper's decompiler
	// File file = new File(getResourcePath("hello1.dex"));
	// List<Path> paths = FileUtils.toPaths(new File[]{file});
	// wrapper.openFile(paths);
	// RootNode root = wrapper.getDecompiler().getRoot();
	//
	// ArgType argType = ArgType.tryToResolveClassAlias(root, ArgType.OBJECT);
	// ArgType argTypeCls = ArgType.tryToResolveClassAlias(root, ArgType.CLASS);
	// assertEquals(ArgType.OBJECT, argType);
	// assertEquals(ArgType.CLASS, argTypeCls);
	// } catch (Exception e) {
	// LOG.error("Error: {}", e.getMessage(), e);
	// System.exit(1);
	// }
	// }
}
