package com.firstlinecode.chalk.xeps.xdata;

import java.util.Properties;

import com.firstlinecode.basalt.protocol.oxm.convention.NamingConventionTranslatorFactory;
import com.firstlinecode.basalt.xeps.xdata.XData;
import com.firstlinecode.chalk.IChatSystem;
import com.firstlinecode.chalk.IPlugin;

public class XDataPlugin implements IPlugin {

	@Override
	public void init(IChatSystem chatSystem, Properties properties) {
		chatSystem.registerTranslator(XData.class,
				new NamingConventionTranslatorFactory<>(
						XData.class
				)
		);
	}

	@Override
	public void destroy(IChatSystem chatSystem) {
		chatSystem.unregisterTranslator(XData.class);
	}

}
