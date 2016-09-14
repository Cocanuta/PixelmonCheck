package com.snatchybuckles.pixelmoncheck;

import com.snatchybuckles.pixelmoncheck.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
		modid = PixelmonCheck.MOD_ID,
		name = PixelmonCheck.MOD_NAME,
		version = PixelmonCheck.VERSION
)
public class PixelmonCheck
{

	public static final String MOD_ID = "pixelmoncheck";
	public static final String MOD_NAME = "PixelmonCheck";
	public static final String VERSION = "0.1";

	public static Configuration configFile;

	public static String PIXELMON_VERSION;

	@SidedProxy(clientSide="com.snatchybuckles.pixelmoncheck.proxy.ClientProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		proxy.preInit(event);
		configFile = new Configuration(event.getSuggestedConfigurationFile());
		syncConfig();
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		proxy.postInit(event);
	}

	public static void syncConfig()
	{
		PIXELMON_VERSION = configFile.getString("pixelmonversion", Configuration.CATEGORY_GENERAL, PIXELMON_VERSION, "pixelmonversion");

		if(configFile.hasChanged())
		{
			configFile.save();
		}
	}


}
