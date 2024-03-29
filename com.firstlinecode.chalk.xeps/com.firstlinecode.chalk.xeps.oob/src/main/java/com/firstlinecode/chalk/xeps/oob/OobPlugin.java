package com.firstlinecode.chalk.xeps.oob;

import java.util.Properties;

import com.firstlinecode.basalt.protocol.oxm.convention.NamingConventionTranslatorFactory;
import com.firstlinecode.chalk.IChatSystem;
import com.firstlinecode.chalk.IPlugin;
import com.firstlinecode.basalt.xeps.oob.IqOob;
import com.firstlinecode.basalt.xeps.oob.XOob;

public class OobPlugin implements IPlugin {

	@Override
	public void init(IChatSystem chatSystem, Properties properties) {
		chatSystem.registerTranslator(IqOob.class,
				new NamingConventionTranslatorFactory<>(
						IqOob.class
				)
		);
		
		chatSystem.registerTranslator(XOob.class,
				new NamingConventionTranslatorFactory<>(
						XOob.class
				)
		);
	}

	@Override
	public void destroy(IChatSystem chatSystem) {
		chatSystem.unregisterTranslator(XOob.class);
		chatSystem.unregisterTranslator(IqOob.class);
	}

}
