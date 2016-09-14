package com.snatchybuckles.pixelmoncheck.proxy;

import com.snatchybuckles.pixelmoncheck.PixelmonCheck;
import com.snatchybuckles.pixelmoncheck.gui.PixelmonMissingScreen;
import com.snatchybuckles.pixelmoncheck.gui.PixelmonWrongVersionScreen;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy
{

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
	}

	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
	}

	@Override
	public void postInit(final FMLPostInitializationEvent e) {
		super.postInit(e);
		List<ModContainer> modList = Loader.instance().getActiveModList();
		boolean modFound = false;
		boolean versionFound = false;
		for(ModContainer mod : modList)
		{
			if(mod.getName().equalsIgnoreCase("pixelmon"))
			{
				modFound = true;
				if(mod.getVersion().equalsIgnoreCase(PixelmonCheck.PIXELMON_VERSION))
				{
					versionFound = true;
				}
			}
		}
		if(!modFound)
		{
			throw new PixelmonMissingScreen();
		}
		else
		{
			if(!versionFound)
			{
				throw new PixelmonWrongVersionScreen();
			}
		}
	}
}
