package info.u_team.useful_railroads.util;

import static net.minecraft.client.renderer.model.ModelBakery.STATE_CONTAINER_OVERRIDES;

import java.util.*;

import com.google.common.collect.ImmutableMap;

import net.minecraft.block.*;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ResourceLocation;

public class ModelUtil {
	
	static {
		if (STATE_CONTAINER_OVERRIDES instanceof ImmutableMap) {
			final Map<ResourceLocation, StateContainer<Block, BlockState>> mutableMap = new HashMap<>();
			STATE_CONTAINER_OVERRIDES.forEach(mutableMap::put);
			STATE_CONTAINER_OVERRIDES = mutableMap;
		}
	}
	
	public static void addCustomStateContainer(ResourceLocation location, StateContainer<Block, BlockState> container) {
		STATE_CONTAINER_OVERRIDES.put(location, container);
	}
	
}
