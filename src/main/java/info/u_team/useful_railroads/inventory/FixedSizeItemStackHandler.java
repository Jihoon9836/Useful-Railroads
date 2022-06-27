package info.u_team.useful_railroads.inventory;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.ContainerHelper;
import net.minecraftforge.items.ItemStackHandler;

public class FixedSizeItemStackHandler extends ItemStackHandler {
	
	public FixedSizeItemStackHandler(int size) {
		super(size);
	}
	
	@Override
	public void setSize(int size) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public CompoundTag serializeNBT() {
		final CompoundTag compound = new CompoundTag();
		ContainerHelper.saveAllItems(compound, stacks, false);
		return compound;
	}
	
	@Override
	public void deserializeNBT(CompoundTag compound) {
		ContainerHelper.loadAllItems(compound, stacks);
		onLoad();
	}
}
