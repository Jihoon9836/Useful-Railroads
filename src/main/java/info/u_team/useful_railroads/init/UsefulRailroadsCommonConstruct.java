package info.u_team.useful_railroads.init;

import info.u_team.u_team_core.api.construct.Construct;
import info.u_team.u_team_core.api.construct.ModConstruct;
import info.u_team.u_team_core.util.registry.BusRegister;
import info.u_team.useful_railroads.UsefulRailroadsMod;
import info.u_team.useful_railroads.config.CommonConfig;
import info.u_team.useful_railroads.config.ServerConfig;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig.Type;

@Construct(modid = UsefulRailroadsMod.MODID)
public class UsefulRailroadsCommonConstruct implements ModConstruct {
	
	@Override
	public void construct() {
		ModLoadingContext.get().registerConfig(Type.COMMON, CommonConfig.CONFIG);
		ModLoadingContext.get().registerConfig(Type.SERVER, ServerConfig.CONFIG);
		
		BusRegister.registerMod(UsefulRailroadsBlocks::registerMod);
		BusRegister.registerMod(UsefulRailroadsCreativeTabs::registerMod);
		BusRegister.registerMod(UsefulRailroadsItems::registerMod);
		BusRegister.registerMod(UsefulRailroadsMenuTypes::registerMod);
		BusRegister.registerMod(UsefulRailroadsRecipeSerializers::registerMod);
		BusRegister.registerMod(UsefulRailroadsRecipeTypes::registerMod);
		BusRegister.registerMod(UsefulRailroadsBlockEntityTypes::registerMod);
	}
}
